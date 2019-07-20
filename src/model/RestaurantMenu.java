package model;

import java.io.Serializable;
import java.util.ArrayList;

public class RestaurantMenu implements Serializable {
	private String restaurantName;
	private ArrayList<RestaurantMenuItem> menuItems;

	RestaurantMenu() {
		this.restaurantName = "";
		this.menuItems = new ArrayList<RestaurantMenuItem>();
	}

	RestaurantMenu(String restaurantName) {
		this.restaurantName = restaurantName;
		this.menuItems = new ArrayList<RestaurantMenuItem>();
	}

	/**
	 * @return the restaurantName
	 */
	public String getRestaurantName() {
		return restaurantName;
	}

	/**
	 * @param restaurantName the restaurantName to set
	 */
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public void addMenuItem(RestaurantMenuItem menuItem) {
		menuItems.add(menuItem);
	}

	public void removeMenuItem(int index) {
		menuItems.remove(index);
	}

	public RestaurantMenuItem getMenuItem(int index) {
		return menuItems.get(index);
	}

	/**
	 * @return the menuItems
	 */
	public ArrayList<RestaurantMenuItem> getMenuItems() {
		return menuItems;
	}

	public String asString() {
		// TODO Auto-generated method stub
		return null;
	}
}
