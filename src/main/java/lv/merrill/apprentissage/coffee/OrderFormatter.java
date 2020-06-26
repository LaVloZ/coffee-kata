package lv.merrill.apprentissage.coffee;

import lv.merrill.apprentissage.coffee.util.Quantity;
import lv.merrill.apprentissage.coffee.util.QuantityFormatter;

class OrderFormatter {
	
	private static final String COMMAND_PATTERN = "%s:%s:%s";
	private static final String MESSAGE_PATTERN = "M:%s";
	
	private static final QuantityFormatter QUANTITY_FORMATTER = new QuantityFormatter();

	DrinkMakerMessage format(Order order) {
		return createFrom(order);
	}
	
	DrinkMakerMessage format(String message) {
		return new DrinkMakerMessage("M:" + message);
	}
	
	private DrinkMakerMessage createFrom(Order order) {
		
		try {
			String drink = getDrink(order);
			String sugar = getSugar(order);
			String stick = getStick(order);
			
			String message = String.format(COMMAND_PATTERN, drink, sugar, stick);

			return new DrinkMakerMessage(message);
		
		} catch (CoffeeMessageException e) {
			String exceptionnalMessage = e.getMessage();
			String message = String.format(MESSAGE_PATTERN, exceptionnalMessage);
			return new DrinkMakerMessage(message);
		}
	}

	private String getStick(Order order) {
		if(order.hasSugar()) {
			return "0";
		}
		else {
			return "";
		}
	}

	private String getSugar(Order order) throws CoffeeMessageException {
		
		if(order.hasSugar()) {
			Quantity sugar = order.getSugar();
			return QUANTITY_FORMATTER.format(sugar);
		}
		else {
			return "";
		}
	}

	private String getDrink(Order order) throws CoffeeMessageException {
		return order.getDrink().getCode();
	}
}
