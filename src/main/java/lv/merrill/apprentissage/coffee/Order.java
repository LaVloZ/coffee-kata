package lv.merrill.apprentissage.coffee;

import static lv.merrill.apprentissage.coffee.util.Quantity.nothing;

import java.util.Objects;
import java.util.UUID;

import lv.merrill.apprentissage.coffee.util.Quantity;

public class Order {
	
	private UUID id;

	private Drink drink;
	private Quantity sugar;

	public Order(Drink drink, Quantity sugar) {
		Objects.requireNonNull(drink);
		
		this.id = UUID.randomUUID();
		
		this.drink = drink;
		
		if(sugar == null) {
			this.sugar = nothing();
		}
		else {
			this.sugar = sugar;
		}
	}

	public Drink getDrink() {
		return drink;
	}
	
	public Quantity getSugar() {
		return sugar;
	}

	public boolean hasSugar() {
		return sugar.isBiggerThan(nothing());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [drink=" + drink + ", sugar=" + sugar + "]";
	}
}
