package lv.merrill.apprentissage.coffee.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Money implements ExtendedComparable<Money> {
	
	private static final MoneyFormatter FORMATTER = new MoneyFormatter();
	
	private static final Money ZERO = new Money();
	
	private BigDecimal value;

	private Money(BigDecimal value) {
		if (value == null) {
			throw new IllegalArgumentException("value cannot be null");
		}

		if (!isCorrectMoneyValue(value)) {
			throw new IllegalArgumentException("value is not correct");
		}

		this.value = value.setScale(2, RoundingMode.HALF_EVEN);
	}
	
	private Money() {
		this.value = BigDecimal.valueOf(0).setScale(2, RoundingMode.HALF_EVEN);
	}
	
	public static Money zero() {
		return ZERO;
	}
	
	private boolean isCorrectMoneyValue(BigDecimal value) {
		return value.compareTo(BigDecimal.ZERO) > 0;
	}

	public static Money valueOf(BigDecimal value) {
		return new Money(value);
	}
	
	public static Money valueOf(double value) {
		BigDecimal bigDecimal = BigDecimal.valueOf(value);
		return new Money(bigDecimal);
	}
	
	public Money add(Money money) {
		BigDecimal value = this.value.add(money.value);
		return new Money(value);
	}
	
	public Money substract(Money money) {
		BigDecimal value = this.value.subtract(money.value);
		return new Money(value);
	}
	
	public Money multiplyBy(Quantity time) {
		BigDecimal timeBg = BigDecimal.valueOf(time.asInteger()).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal multiplied = value.multiply(timeBg);
		return valueOf(multiplied);
	}

	BigDecimal getBigDecimal() {
		return value;
	}

	double asDouble() {
		return value.doubleValue();
	}

	@Override
	public int compareTo(Money anotherMoney) {
		return value.compareTo(anotherMoney.value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return FORMATTER.format(this);
	}
}
