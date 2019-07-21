/**
* The RestaurantMenuItem class is an abstract super class for the Beverage 
* and Food classes.  It contains the basic properties applicable for all of 
* it's inherited classes and provides methods to manipulate those properties.
*
* @author  Carson Fairbourn & Shelby Burnworth
*/

package model;

import java.io.Serializable;

public abstract class RestaurantMenuItem implements Serializable {
	private String name;
	private double price;
	private int calories;

	// get and return restaurant name
	public String getName() {
		return name;
	}

	// set the restaurant name
	public void setName(String name) {
		this.name = name;
	}

	// get and return price of item
	public double getPrice() {
		return price;
	}

	// set the price of item
	public void setPrice(double price) {
		this.price = price;
	}

	// get the calories of item
	public int getCalories() {
		return calories;
	}

	// set calorites for item
	public void setCalories(int calories) {
		this.calories = calories;
	}

	abstract String getItemType();

	// return name, price and calories of item
	public String asString() {
		return this.name + this.price + this.calories;
	}
}
