package lv.merrill.apprentissage.coffee.util;

public interface ExtendedComparable<T> extends Comparable<T> {

	public default boolean isBiggerThan(T type) {
		return compareTo(type) > 0;
	}

	public default boolean isBiggerThanOrEqualsTo(T type) {
		return compareTo(type) >= 0;
	}

	public default boolean isLessThan(T type) {
		return compareTo(type) < 0;
	}

	public default boolean isLessThanOrEqualsTo(T type) {
		return compareTo(type) <= 0;
	}

	public default boolean isEqualTo(T type) {
		return compareTo(type) == 0;
	}
}
