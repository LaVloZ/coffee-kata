package lv.merrill.apprentissage.coffee;

import lv.merrill.apprentissage.coffee.integration.Balance;
import lv.merrill.apprentissage.coffee.integration.BeverageQuantityChecker;
import lv.merrill.apprentissage.coffee.integration.DrinkMaker;
import lv.merrill.apprentissage.coffee.integration.EmailNotifier;
import lv.merrill.apprentissage.coffee.util.Money;
import lv.merrill.apprentissage.coffee.util.MoneyFormatter;

public class CommandService {

	private static final String INSUFFISENT_MONEY_PATTERN = "insuffisent money, please insert %s€.";
	private static final String SHORTAGE_BEVERAGE_PATTERN = "shortage beverage, administrator got notified";

	private static final MoneyFormatter MONEY_FORMATTER = new MoneyFormatter();

	// Current inserted money.
	private Balance balance;

	private DrinkMaker drinkMaker;

	private CommandHistory history;

	private BeverageQuantityChecker checker;
	
	private EmailNotifier notifier;

	private OrderFormatter formatter = new OrderFormatter();

	public CommandService(Balance balance, DrinkMaker drinkMaker, CommandHistory history,
			BeverageQuantityChecker checker, EmailNotifier notifier) {
		this.balance = balance;
		this.drinkMaker = drinkMaker;
		this.history = history;
		this.checker = checker;
		this.notifier = notifier;
	}

	public void command(Order order) {
		DrinkMakerMessage message = null;
		
		String drink = order.getDrink().getName();
		if (checker.isEmpty(drink)) {
			message = formatShortageBeverage(order);
			notifier.notifyMissingDrink(drink);
		} else {
			Money insertMoney = balance.getMoney();

			Money price = order.getDrink().getPrice();
			if (price.isBiggerThan(insertMoney)) {
				message = formatMissingMoneyMessage(insertMoney, price);
			} else {
				message = formatter.format(order);
				history.historify(order);
			}
		}
		
		String stringuifiedMessage = message.toString();
		drinkMaker.send(stringuifiedMessage);
	}

	private DrinkMakerMessage formatShortageBeverage(Order order) {
		String name = order.getDrink().getName();
		String text = String.format(SHORTAGE_BEVERAGE_PATTERN, name);
		return formatter.format(text);
	}

	private DrinkMakerMessage formatMissingMoneyMessage(Money insertMoney, Money price) {
		Money missingMoney = price.substract(insertMoney);
		String formatted = MONEY_FORMATTER.format(missingMoney);
		String text = String.format(INSUFFISENT_MONEY_PATTERN, formatted);
		return formatter.format(text);
	}
}
