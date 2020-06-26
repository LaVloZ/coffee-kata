package lv.merrill.apprentissage.coffee.reporting;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

import lv.merrill.apprentissage.coffee.CommandHistory;
import lv.merrill.apprentissage.coffee.util.Money;

public class ReportingServiceTest {

	@Test
	public void makeReport() {
		CommandHistory history = ReportFactory.prepareHistory();
		ReportingService service = new ReportingService(history);

		Money expectedTotal = Money.valueOf(4.4);

		Report actual = service.makeReport();
		Money actualTotal = actual.getTotal();

		assertThat("", actualTotal, is(equalTo(expectedTotal)));
		
		//No time to test the rest of the report :(
	}
}
