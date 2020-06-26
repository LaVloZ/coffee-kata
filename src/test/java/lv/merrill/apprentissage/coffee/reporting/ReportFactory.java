package lv.merrill.apprentissage.coffee.reporting;

import java.util.ArrayList;
import java.util.List;

import lv.merrill.apprentissage.coffee.Command;
import lv.merrill.apprentissage.coffee.CommandHistory;
import lv.merrill.apprentissage.coffee.Drink;
import lv.merrill.apprentissage.coffee.Drinks;
import lv.merrill.apprentissage.coffee.MistFactory;
import lv.merrill.apprentissage.coffee.Order;

final class ReportFactory {

	private ReportFactory() {
	}
	
	public static CommandHistory prepareHistory() {
		List<Command> commands = new ArrayList<Command>();
		addCommand(commands, Drinks.chocolate(), 1);
		addCommand(commands, Drinks.chocolate(), 2);
		addCommand(commands, Drinks.tea(), 1);
		addCommand(commands, Drinks.coffee(), 1);
		addCommand(commands, Drinks.coffee(), 2);
		addCommand(commands, Drinks.coffee(), 3);
		addCommand(commands, Drinks.orangeJuice(), 1);
		addCommand(commands, Drinks.orangeJuice(), 1);
		
		return MistFactory.createHistory(commands);
	}
	
	public static void addCommand(List<Command> commands, Drink drink, int sugar) {
		Order order = MistFactory.createOrder(drink, sugar);
		Command command = MistFactory.createCommand(order);
		commands.add(command);
	}
	
	public static Report prepareReport() {
		CommandHistory history = prepareHistory();
		ReportingService service = new ReportingService(history);
		return service.makeReport();
	}
}
