package lv.merrill.apprentissage.coffee;

import static lv.merrill.apprentissage.coffee.Drinks.chocolate;
import static lv.merrill.apprentissage.coffee.Drinks.coffee;
import static lv.merrill.apprentissage.coffee.Drinks.tea;
import static lv.merrill.apprentissage.coffee.util.Quantity.nothing;
import static lv.merrill.apprentissage.coffee.util.Quantity.quantify;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class OrderFormatterTest {
	
	private OrderFormatter formatter = new OrderFormatter();

	@Test
	public void chocolateWithoutSugar() {
		Order order = new Order(chocolate(), nothing());

		String actual = formatter.format(order).toString();
		
		String expected = "H::";
		assertThat(actual, is(equalTo(expected)));
	}
	
	@Test
	public void chocolateWithSugar() {
		Order order = new Order(chocolate(), quantify(1));
		
		String actual = formatter.format(order).toString();
		
		String expected = "H:1:0";
		assertThat(actual, is(equalTo(expected)));
	}
	
	@Test
	public void teaWithoutSugar() {
		Order order = new Order(tea(), nothing());
		
		String actual = formatter.format(order).toString();
		
		String expected = "T::";
		assertThat(actual, is(equalTo(expected)));
	}
	
	@Test
	public void teaWithSugar() {
		Order order = new Order(tea(), quantify(1));
		
		String actual = formatter.format(order).toString();
		
		String expected = "T:1:0";		
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void coffeeWithoutSugar() {
		Order order = new Order(coffee(), nothing());
		
		String actual = formatter.format(order).toString();
		
		String expected = "C::";
		assertThat(actual, is(equalTo(expected)));
	}
	
	@Test
	public void coffeeWithSugar() {
		Order order = new Order(coffee(), quantify(1));
		
		String actual = formatter.format(order).toString();
		
		String expected = "C:1:0";
		assertThat(actual, is(equalTo(expected)));
	}
	
	@Test
	public void chocolateWithTwoSugars() {
		Order order = new Order(chocolate(), quantify(2));
		
		String actual = formatter.format(order).toString();
		
		String expected = "H:2:0";
		assertThat(actual, is(equalTo(expected)));
	}
	
	@Test
	public void extraHotCoffeeWithSugar() {
		Order order = new Order(coffee().extraHot(), quantify(1));
		
		String actual = formatter.format(order).toString();
		
		String expected = "Ch:1:0";
		assertThat(actual, is(equalTo(expected)));
	}

	@Test
	public void nullDrink() {
		assertThrows(NullPointerException.class, () -> {
			new Order(null, quantify(1));
		});
	}
}
