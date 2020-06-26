package lv.merrill.apprentissage.coffee;

class CoffeeMessageException extends Exception {

	private static final long serialVersionUID = 5396127525682931921L;

	CoffeeMessageException() {
	}

	CoffeeMessageException(String message) {
		super(message);
	}
}
