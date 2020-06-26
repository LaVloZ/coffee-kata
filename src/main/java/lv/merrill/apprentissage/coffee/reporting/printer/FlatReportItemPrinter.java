package lv.merrill.apprentissage.coffee.reporting.printer;

import java.io.PrintWriter;

import lv.merrill.apprentissage.coffee.reporting.ReportItem;
import lv.merrill.apprentissage.coffee.util.QuantityFormatter;

class FlatReportItemPrinter {

	private static final String PATTERN = "Drink : %s, sold quantity : %s";

	private static final QuantityFormatter QUANTITY_FORMATTER = new QuantityFormatter();

	private PrintWriter writer;

	public FlatReportItemPrinter(PrintWriter writer) {
		this.writer = writer;
	}

	void print(ReportItem item) {

		String name = item.getDrink().getName();
		String quantity = QUANTITY_FORMATTER.format(item.getQuantity());

		String line = String.format(PATTERN, name, quantity);

		writer.println(line);
	}
}
