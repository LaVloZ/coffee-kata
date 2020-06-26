package lv.merrill.apprentissage.coffee.util;

import static lv.merrill.apprentissage.coffee.util.Quantity.quantify;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

public class MoneyTest {

	@Test
	public void fromBigDecimalgetBigDecimal() {
		Money money = Money.valueOf(BigDecimal.ONE);
		
		BigDecimal expectedBigDecimal = BigDecimal.ONE.setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal actualBigDecimal = money.getBigDecimal();
		
		assertThat("incorrect BigDecimal value", actualBigDecimal, is(equalTo(expectedBigDecimal)));
	}
	
	@Test
	public void fromBigDecimalAsDouble() {
		Money money = Money.valueOf(BigDecimal.ONE);
		
		double expectedDouble = 1;
		double actualDouble = money.asDouble();
		
		assertThat("incorrect double value", expectedDouble, is(equalTo(actualDouble)));
	}
	
	@Test
	public void fromDoublegetBigDecimal() {
		Money money = Money.valueOf(1);
		
		BigDecimal expectedBigDecimal = BigDecimal.ONE.setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal actualBigDecimal = money.getBigDecimal();
		
		assertThat("incorrect BigDecimal value", actualBigDecimal, is(equalTo(expectedBigDecimal)));
	}
	
	@Test
	public void fromDoubleAsDouble() {
		Money money = Money.valueOf(1);
		
		double expectedDouble = 1;
		double actualDouble = money.asDouble();
		
		assertThat("incorrect double value", expectedDouble, is(equalTo(actualDouble)));
	}
	
	@Test
	public void nullValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			Money.valueOf(null);
		}, "null value");
	}
	
	@Test
	public void zeroValue() {
		assertThrows(IllegalArgumentException.class, () -> {
			Money.valueOf(BigDecimal.ZERO);
		}, "zero value");
	}
	
	@Test
	public void compareOneMoneyAgainstTenMoney() {
		Money money1 = Money.valueOf(BigDecimal.ONE);
		Money money2 = Money.valueOf(BigDecimal.TEN);
		
		int expected = -1;
		int actual = money1.compareTo(money2);
		
		assertThat("", expected, is(equalTo(actual)));
	}
	
	@Test
	public void compareTenMoneyAgaisntOneMoney() {
		Money money1 = Money.valueOf(BigDecimal.TEN);
		Money money2 = Money.valueOf(BigDecimal.ONE);
		
		int expected = 1;
		int actual = money1.compareTo(money2);
		
		assertThat("", expected, is(equalTo(actual)));
	}
	
	@Test
	public void compareOneMoneyAgaisntOneMoney() {
		Money money1 = Money.valueOf(BigDecimal.ONE);
		Money money2 = Money.valueOf(BigDecimal.ONE);
		
		int expected = 0;
		int actual = money1.compareTo(money2);
		
		assertThat("", expected, is(equalTo(actual)));
	}
	
	@Test
	public void equals() {
		Money money1 = Money.valueOf(BigDecimal.ONE);
		Money money2 = Money.valueOf(BigDecimal.ONE);
		
		boolean expected = true;
		boolean actual = money1.equals(money2);
		
		assertThat("", expected, is(equalTo(actual)));
	}
	
	@Test
	public void notEquals() {
		Money money1 = Money.valueOf(BigDecimal.ONE);
		Money money2 = Money.valueOf(BigDecimal.TEN);
		
		boolean expected = false;
		boolean actual = money1.equals(money2);
		
		assertThat("", expected, is(equalTo(actual)));
	}
	
	@Test
	public void add() {
		Money money1 = Money.valueOf(BigDecimal.ONE);
		Money money2 = Money.valueOf(BigDecimal.TEN);
		
		Money expected = Money.valueOf(11);
		Money actual = money1.add(money2);
		
		assertThat("", expected, is(equalTo(actual)));
	}
	
	@Test
	public void substract() {
		Money money1 = Money.valueOf(BigDecimal.ONE);
		Money money2 = Money.valueOf(BigDecimal.TEN);
		
		Money expected = Money.valueOf(9);
		Money actual = money2.substract(money1);
		
		assertThat("", expected, is(equalTo(actual)));
	}
	
	@Test
	public void substractUnderZero() {
		Money money1 = Money.valueOf(BigDecimal.ONE);
		Money money2 = Money.valueOf(BigDecimal.TEN);
		
		assertThrows(IllegalArgumentException.class, () -> {
			money1.substract(money2);
		}, "cannot have a negative amount of money");
	}
	
	@Test
	public void multiplyBy() {
		Money money = Money.valueOf(BigDecimal.TEN);
		Quantity quantity = quantify(2);
		
		Money expected = Money.valueOf(20);
		Money actual = money.multiplyBy(quantity);
		
		assertThat("", actual, is(equalTo(expected)));
	}
}
