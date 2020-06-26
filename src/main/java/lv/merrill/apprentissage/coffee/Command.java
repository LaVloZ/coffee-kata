package lv.merrill.apprentissage.coffee;

import lv.merrill.apprentissage.coffee.util.Money;

public class Command {
	
	private Order order;

	//This is not a duplication of the price in Drink.price
	private Money price;
	
	Command(Order order) {
		this.order = order;
		this.price = order.getDrink().getPrice();
	}

	public Order getOrder() {
		return order;
	}

	public Money getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
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
		Command other = (Command) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Command [order=" + order + ", price=" + price + "]";
	}
}
