package views;

import model.RestaurantMenu;

// import MainMenuView;

public class Sample {
	private static RestaurantMenu restaurantMenu;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainMenuView mainMenu = new MainMenuView();
		mainMenu.display();
		System.out.printf("Game Over.");
	}

	/**
	 * @return the restauraneMenu
	 */
	public static RestaurantMenu getRestaurantMenu() {
		return restaurantMenu;
	}

	/**
	 * @param restauraneMenu the restauraneMenu to set
	 */
	public static void setRestaurantMenu(RestaurantMenu restaurantMenu) {
		Sample.restaurantMenu = restaurantMenu;
	}

}
