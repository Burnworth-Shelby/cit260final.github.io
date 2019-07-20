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

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

	@Override
	String getItemType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
