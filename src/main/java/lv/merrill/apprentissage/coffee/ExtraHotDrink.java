package lv.merrill.apprentissage.coffee;

import java.util.Objects;

import lv.merrill.apprentissage.coffee.util.Money;

class ExtraHotDrink implements Drink {
	
	private static final String PATTERN = "%sh";
	
	private Drink drink;
	
	public ExtraHotDrink(Drink drink) {
		Objects.requireNonNull(drink);
		
		this.drink = drink;
	}
	
	@Override
	public String getName() {
		return drink.getName();
	}

	@Override
	public String getCode() {
		String code = drink.getCode();
		return String.format(PATTERN, code, "h");
	}

	@Override
	public Money getPrice() {
		return drink.getPrice();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drink == null) ? 0 : drink.hashCode());
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
		ExtraHotDrink other = (ExtraHotDrink) obj;
		if (drink == null) {
			if (other.drink != null)
				return false;
		} else if (!drink.equals(other.drink))
			return false;
		return true;
	}
}
