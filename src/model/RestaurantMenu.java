/**
* The RestaurantMenu class contains an array list of RestaurantMenuItems (menuItems) 
* and provides basic methods to be able to manipulate the items in that list
*
* @author  Carson Fairbourn & Shelby Burnworth
*/

package model;

import java.io.Serializable;
import java.util.ArrayList;

public class RestaurantMenu implements Serializable {
	private String restaurantName;
	private ArrayList<RestaurantMenuItem> menuItems;

	// create an array of restaurant menu items
	RestaurantMenu() {
		this.restaurantName = "";
		this.menuItems = new ArrayList<RestaurantMenuItem>();
	}

	RestaurantMenu(String restaurantName) {
		this.restaurantName = restaurantName;
		this.menuItems = new ArrayList<RestaurantMenuItem>();
	}

	/**
	 * The getRestaurantName Method Purpose: get the name of the restaurant from
	 * user
	 * 
	 * @return restaurantName
	 */
	public String getRestaurantName() {
		return restaurantName;
	}

	/**
	 * The setRestaurantName Method Purpose: set the restaurant name
	 * 
	 * @param restaurantName the restaurantName to set
	 */
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	/**
	 * The addMenuItem Method Purpose: add a menu item
	 * 
	 * @param menuItems.add(menuItem)
	 */
	public void addMenuItem(RestaurantMenuItem menuItem) {
		menuItems.add(menuItem);
	}

	/**
	 * The removeMenuItem Method Purpose: remove a menu item
	 * 
	 * @param menuItems.remove(index)
	 */
	public void removeMenuItem(int index) {
		menuItems.remove(index);
	}

	/**
	 * The RestaurantMenuItem Method Purpose: get a menu item
	 * 
	 * @param getMenuItem
	 * @return menuItem
	 */
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
