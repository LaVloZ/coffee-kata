package lv.merrill.apprentissage.coffee.reporting.printer;

import java.io.PrintWriter;

import lv.merrill.apprentissage.coffee.reporting.Report;
import lv.merrill.apprentissage.coffee.reporting.ReportPrinter;
import lv.merrill.apprentissage.coffee.util.MoneyFormatter;

public class FlatReportPrinter implements ReportPrinter {
	
	private static final String HEAD = "Report:";
	private static final String FOOTER_PATTERN = "Total amount : %s€";
	
	private static final MoneyFormatter MONEY_FORMATTER = new MoneyFormatter(); 

	private PrintWriter writer;
	
	private FlatReportItemPrinter itemPrinter;

	public FlatReportPrinter(PrintWriter writer) {
		this.writer = writer;
		this.itemPrinter = new FlatReportItemPrinter(writer);
	}

	@Override
	public void print(Report report) {
		writer.println(HEAD);
		
		report.getItems().stream()
			.forEach(itemPrinter::print);
		
		String money = MONEY_FORMATTER.format(report.getTotal());
		String footer = String.format(FOOTER_PATTERN, money);
		writer.println(footer);
		
		writer.flush();
	}
}
