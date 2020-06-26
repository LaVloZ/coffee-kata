package lv.merrill.apprentissage.coffee;

class DrinkMakerMessage {
	
	private String message;
	
	DrinkMakerMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return message;
	}
}
