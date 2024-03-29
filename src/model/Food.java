/**
* The Food class is a subclass of RestaurantMenuItem.  It adds 
* additional properties applicable to food items and a method 
* for outputting as a String.
*
* @author  Carson Fairbourn & Shelby Burnworth
*/

package model;

import java.io.Serializable;

public class Food extends RestaurantMenuItem implements Serializable {
	private String description;
	private String itemType;

	public Food() {
		super("", 0, 0);
		this.setDescription("");
		this.setItemType("");
	}

	public Food(String name, double price, int calories, String description, String itemType) {
		super(name, price, calories);
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
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@Override
	public String getItemType() {
		return this.itemType;
	}

	@Override
	public String asString() {
		// TODO Auto-generated method stub
		return super.asString() + "      " + this.description;
	}
}
