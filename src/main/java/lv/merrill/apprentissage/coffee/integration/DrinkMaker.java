package lv.merrill.apprentissage.coffee.integration;

import lv.merrill.apprentissage.coffee.reporting.Report;

public interface DrinkMaker {

	public void send(String command);
	
	public void display(Report report);
}
