package lv.merrill.apprentissage.coffee;

import static lv.merrill.apprentissage.coffee.util.Quantity.quantify;

import java.util.List;

public final class MistFactory {
	
	private MistFactory() {
	}

	public static Order createOrder(Drink drink, int sugar) {
		return new Order(drink, quantify(sugar));
	}
	
	public static Command createCommand(Order order) {
		return new Command(order);
	}
	
	public static Command createCommand(Drink drink, int sugar) {
		Order order = createOrder(drink, sugar);
		return createCommand(order);
	}
	
	public static CommandHistory createHistory(List<Command> commands) {
		return new CommandHistory(commands);
	}
}
