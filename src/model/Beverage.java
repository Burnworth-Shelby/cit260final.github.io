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

	/**
	 * @return the refillable
	 */
	public boolean isRefillable() {
		return refillable;
	}

	/**
	 * @param refillable the refillable to set
	 */
	public void setRefillable(boolean refillable) {
		this.refillable = refillable;
	}

	@Override
	public String getItemType() {
		return "Beverage";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
