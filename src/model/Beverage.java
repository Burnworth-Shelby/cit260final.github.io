/**
* The Beverage class is a subclass of RestaurantMenuItem.  It adds 
* additional properties applicable to beverage items and a method 
* for outputting as a String.
*
* @author  Carson Fairbourn & Shelby Burnworth
*/

package model;

public class Beverage extends RestaurantMenuItem {
	private boolean refillable;

	public Beverage() {
		super();
		this.setName("");
		this.setPrice(0);
		this.setCalories(0);
		this.setRefillable(false);
	}

	public Beverage(String name, double price, int calories, boolean refillable) {
		super();
		this.setName(name);
		this.setPrice(price);
		this.setCalories(calories);
		this.setRefillable(refillable);
	}

	// return if drink is refillable
	public boolean isRefillable() {
		return refillable;
	}

	// determine if drink is refillable
	public void setRefillable(boolean refillable) {
		this.refillable = refillable;
	}

	@Override
	public String getItemType() {
		return "Beverage";
	}

	@Override
	public String asString() {
		// TODO Auto-generated method stub
		return super.asString() + this.refillable;
	}
}
