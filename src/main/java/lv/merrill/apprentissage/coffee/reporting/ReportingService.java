package lv.merrill.apprentissage.coffee.reporting;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

import java.util.Map.Entry;
import java.util.Set;

import lv.merrill.apprentissage.coffee.CommandHistory;

public class ReportingService {

	//Usualy get injected.
	private CommandHistory history;

	public ReportingService(CommandHistory history) {
		this.history = history;
	}

	public Report makeReport() {
		
		Set<ReportItem> items = history.getCommands().stream()
			.collect(groupingBy(c -> c.getOrder().getDrink()))
			.entrySet()
			.stream()
			.map(Entry::getValue)
			.map(ReportItem::new)
			.collect(toSet());
		
		return new Report(items);
	};
}
