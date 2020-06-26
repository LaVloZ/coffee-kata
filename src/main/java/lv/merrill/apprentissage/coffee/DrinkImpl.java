package lv.merrill.apprentissage.coffee;

import lv.merrill.apprentissage.coffee.util.Money;

class DrinkImpl implements HoltyDrink {

	private String name;
	private String code;
	private Money price;

	DrinkImpl(String name, String code, Money price) {
		this.name = name;
		this.code = code;
		this.price = price;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public Money getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		DrinkImpl other = (DrinkImpl) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}
}
