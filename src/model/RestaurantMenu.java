package model;

import java.util.ArrayList;

public class RestaurantMenu {
	private ArrayList<RestaurantMenuItem> menuItems;

	RestaurantMenu() {

	}

	RestaurantMenu(ArrayList<RestaurantMenuItem> menuItems) {
		this.menuItems = menuItems;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
