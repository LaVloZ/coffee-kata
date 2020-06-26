package lv.merrill.apprentissage.coffee.util;

public final class Quantity implements ExtendedComparable<Quantity> {
	
	private static final Quantity NOTHING = new Quantity(0);
	
	private static final QuantityFormatter FORMATTER = new QuantityFormatter();

	private int value;

	private Quantity(int value) {
		this.value = value;
	}
	
	public static Quantity quantify(int value) {
		if(value == 0) {
			return nothing();
		}
		
		if(value < 0) {
			throw new IllegalArgumentException("cannot have a negative quantity");
		}
		
		return new Quantity(value);
	}
	
	public static Quantity nothing() {
		return NOTHING;
	}
	
	int asInteger() {
		return value;
	}

	@Override
	public int compareTo(Quantity another) {
		return Integer.valueOf(value).compareTo(another.value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
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
		Quantity other = (Quantity) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return FORMATTER.format(this);
	}
}
