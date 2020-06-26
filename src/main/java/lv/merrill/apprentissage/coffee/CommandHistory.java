package lv.merrill.apprentissage.coffee;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {

	private List<Command> commands;
	
	public CommandHistory() {
		this(new ArrayList<Command>());
	}
	
	CommandHistory(List<Command> commands) {
		this.commands = commands;
	}
	
	public Command historify(Order order) {
		Command command = new Command(order);
		commands.add(command);
		
		return command;
	}
	
	public List<Command> getCommands() {
		return commands;
	}
}
