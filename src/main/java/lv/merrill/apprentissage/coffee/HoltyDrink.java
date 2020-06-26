package lv.merrill.apprentissage.coffee;

public interface HoltyDrink extends Drink {

	public default Drink extraHot() {
		return new ExtraHotDrink(this);
	}
}
