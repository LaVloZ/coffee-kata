package lv.merrill.apprentissage.coffee;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CommandHistoryTest {

	@Test
	public void historify() {

		CommandHistory history = new CommandHistory();
		HoltyDrink chocolate = Drinks.chocolate();
		Order order = MistFactory.createOrder(chocolate, 2);

		Command expected = MistFactory.createCommand(order);

		Command actual = history.historify(order);

		assertThat("", actual, is(equalTo(expected)));
	}

	@Test
	public void getCommands() {

		CommandHistory history = new CommandHistory();

		Order expectedOrder = MistFactory.createOrder(Drinks.chocolate(), 1);
		Command expectedCommand = MistFactory.createCommand(expectedOrder);

		history.historify(expectedOrder);

		List<Command> actual = history.getCommands();

		assertThat("", actual, is(equalTo(actual)));
	}
}
