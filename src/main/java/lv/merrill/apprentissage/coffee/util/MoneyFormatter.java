package lv.merrill.apprentissage.coffee.util;

import java.text.DecimalFormat;
import java.util.Currency;

public class MoneyFormatter {

	private static final ThreadLocal<DecimalFormat> DECIMAL_FORMATTER = new ThreadLocal<DecimalFormat>() {
		protected DecimalFormat initialValue() {
			DecimalFormat formatter = new DecimalFormat();
			Currency euro = Currency.getInstance("EUR");

			formatter.setCurrency(euro);
			formatter.setMaximumFractionDigits(2);
			formatter.setMinimumFractionDigits(2);
			formatter.setGroupingUsed(false);

			return formatter;
		};
	};
	
	public String format(Money money) {
		return DECIMAL_FORMATTER.get().format(money.getBigDecimal());
	}
}
