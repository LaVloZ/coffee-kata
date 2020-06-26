package lv.merrill.apprentissage.coffee.reporting;

import static lv.merrill.apprentissage.coffee.util.Money.zero;
import static lv.merrill.apprentissage.coffee.util.Quantity.quantify;

import java.util.List;

import lv.merrill.apprentissage.coffee.Command;
import lv.merrill.apprentissage.coffee.Drink;
import lv.merrill.apprentissage.coffee.util.Money;
import lv.merrill.apprentissage.coffee.util.Quantity;

public class ReportItem {

	private List<Command> commands;

	ReportItem(List<Command> commands) {
		this.commands = commands;
	}

	public Drink getDrink() {
		return commands.get(0).getOrder().getDrink();
	}

	public Quantity getQuantity() {
		int size = commands.size();
		return quantify(size);
	}
	
	Money getTotal() {
		return commands.stream()
				.map(Command::getPrice)
				.reduce(zero(), Money::add);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getDrink() == null) ? 0 : getDrink().hashCode());
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
		ReportItem other = (ReportItem) obj;
		if (getDrink() == null) {
			if (other.getDrink() != null)
				return false;
		} else if (!getDrink().equals(other.getDrink()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReportItem [commands=" + commands + "]";
	}
}
