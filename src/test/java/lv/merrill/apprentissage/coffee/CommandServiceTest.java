package lv.merrill.apprentissage.coffee;

import static lv.merrill.apprentissage.coffee.Drinks.chocolate;
import static lv.merrill.apprentissage.coffee.util.Quantity.quantify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import lv.merrill.apprentissage.coffee.integration.Balance;
import lv.merrill.apprentissage.coffee.integration.BeverageQuantityChecker;
import lv.merrill.apprentissage.coffee.integration.DrinkMaker;
import lv.merrill.apprentissage.coffee.integration.EmailNotifier;
import lv.merrill.apprentissage.coffee.util.Money;

public class CommandServiceTest {
	
	private Balance balance = mock(Balance.class);
	
	private DrinkMaker drinkMaker = mock(DrinkMaker.class);
	
	private CommandHistory history = mock(CommandHistory.class);
	
	private BeverageQuantityChecker checker = mock(BeverageQuantityChecker.class);
	
	private EmailNotifier notifier = mock(EmailNotifier.class);
	
	private CommandService service = new CommandService(balance, drinkMaker, history, checker, notifier);
	
	@Test
	public void commandWithInsuffisentMoney() {
		Order order = new Order(chocolate(), quantify(1));
		
		when(balance.getMoney()).thenReturn(Money.valueOf(0.1));
		service.command(order);
		
		String expected = "M:insuffisent money, please insert 0,40€.";
		
		verify(drinkMaker).send(expected);
	}
	
	@Test
	public void commandWithInsuffisentBeverage() {
		when(checker.isEmpty("Chocolate")).thenReturn(true);
		Order order = new Order(chocolate(), quantify(1));
		
		service.command(order);
		
		verify(checker).isEmpty("Chocolate");
		verify(notifier).notifyMissingDrink("Chocolate");
	}
	
	@Test
	public void commandWithSuffisentMoney() {
		Order order = new Order(chocolate(), quantify(1));
		
		when(balance.getMoney()).thenReturn(Money.valueOf(1));
		service.command(order);
		
		String expected = "H:1:0";
		
		verify(drinkMaker).send(expected);
		verify(history).historify(order);
	}
}
