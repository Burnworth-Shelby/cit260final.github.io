/**
* The Food class is a subclass of RestaurantMenuItem.  It adds 
* additional properties applicable to food items and a method 
* for outputting as a String.
*
* @author  Carson Fairbourn & Shelby Burnworth
*/

package model;

public class Food extends RestaurantMenuItem {
	private String description;
	private int itemType;

	public Food() {
		super();
		this.setName("");
		this.setPrice(0);
		this.setCalories(0);
		this.setDescription("");
		this.setItemType(0);
	}

	public Food(String name, double price, int calories, String description, int itemType) {
		super();
		this.setName(name);
		this.setPrice(price);
		this.setCalories(calories);
		this.setDescription(description);
		this.setItemType(itemType);
	}

	// return description of item
	public String getDescription() {
		return description;
	}

	// set description of item
	public void setDescription(String description) {
		this.description = description;
	}

	// set item type
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

	@Override
	String getItemType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String asString() {
		// TODO Auto-generated method stub
		return super.asString() + this.description + this.getItemType();
	}
}
