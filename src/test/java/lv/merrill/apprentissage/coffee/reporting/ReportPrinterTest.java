package lv.merrill.apprentissage.coffee.reporting;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lv.merrill.apprentissage.coffee.reporting.printer.FlatReportPrinter;

public class ReportPrinterTest {
	
	//Use System.out to print to console
	
	private ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
	private OutputStreamWriter outWriter;
	
	private byte[] expected;
	
	@BeforeEach
	public void initTesCase() throws UnsupportedEncodingException {
		outWriter = new OutputStreamWriter(out, "UTF-8");
		
		expected = ("Report:\r\n" + 
				"Drink : Orange juice, sold quantity : 2\r\n" + 
				"Drink : Coffee, sold quantity : 3\r\n" + 
				"Drink : Tea, sold quantity : 1\r\n" + 
				"Drink : Chocolate, sold quantity : 2\r\n" + 
				"Total amount : 4,40€\r\n")
				.getBytes("UTF-8");
	}

	@Test
	public void prinToMemory() throws UnsupportedEncodingException {
		Report report = ReportFactory.prepareReport();
		
		PrintWriter writer = new PrintWriter(outWriter);
		FlatReportPrinter printer = new FlatReportPrinter(writer);
		
		printer.print(report);
		
		byte[] actual = out.toByteArray();
		
		assertThat("", actual, is(equalTo(expected)));
	}
}
