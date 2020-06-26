package lv.merrill.apprentissage.coffee;

import static lv.merrill.apprentissage.coffee.util.Money.valueOf;

public final class Drinks {

	private static final String ORANGE_JUICE_CODE = "O";
	private static final String CHOCOLATE_CODE = "H";
	private static final String TEA_CODE = "T";
	private static final String COFFEE_CODE = "C";
	
	private static final String ORANGE_JUICE_NAME = "Orange juice";
	private static final String CHOCOLATE_NAME = "Chocolate";
	private static final String TEA_NAME = "Tea";
	private static final String COFFEE_NAME = "Coffee";

	private Drinks() {
	}

	public static HoltyDrink coffee() {
		return new DrinkImpl(COFFEE_NAME, COFFEE_CODE, valueOf(0.6));
	}

	public static HoltyDrink tea() {
		return new DrinkImpl(TEA_NAME, TEA_CODE, valueOf(0.4));
	}

	public static HoltyDrink chocolate() {
		return new DrinkImpl(CHOCOLATE_NAME, CHOCOLATE_CODE, valueOf(0.5));
	}

	public static Drink orangeJuice() {
		return new DrinkImpl(ORANGE_JUICE_NAME, ORANGE_JUICE_CODE, valueOf(0.6));
	}
}
