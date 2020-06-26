package lv.merrill.apprentissage.coffee.util;

public class QuantityFormatter {

	public String format(Quantity quantity) {
		int value = quantity.asInteger();
		return String.valueOf(value);
	}
}
