package lv.merrill.apprentissage.coffee.reporting;

import static lv.merrill.apprentissage.coffee.util.Money.zero;

import java.util.Collections;
import java.util.Set;

import lv.merrill.apprentissage.coffee.util.Money;

public class Report {

	private Set<ReportItem> items;

	Report(Set<ReportItem> items) {
		this.items = items;
	}

	public Set<ReportItem> getItems() {
		return Collections.unmodifiableSet(items);
	}
	
	public Money getTotal() {
		return items.stream()
			.map(ReportItem::getTotal)
			.reduce(zero(), Money::add);
	}

	@Override
	public String toString() {
		return "Report [items=" + items + "]";
	}
}
