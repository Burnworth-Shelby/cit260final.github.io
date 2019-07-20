package views;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.RestaurantMenu;

// import MainMenuView;

public class Sample {
	private static RestaurantMenu restaurantMenu;
	private static String fileLoaded;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainMenuView mainMenu = new MainMenuView();
		mainMenu.display();
		System.out.printf("Game Over.");
	}

	/**
	 * @return the restaurantMenu
	 */
	public static RestaurantMenu getRestaurantMenu() {
		return restaurantMenu;
	}

	/**
	 * @param restaurantMenu the restaurantMenu to set
	 */
	public static void setRestaurantMenu(RestaurantMenu myMenu) {
		restaurantMenu = myMenu;
	}

	public static boolean getSavedMenu(String filePath) {
		restaurantMenu = null;
		fileLoaded = filePath;
		try (FileInputStream fips = new FileInputStream(filePath)) {
			ObjectInputStream input = new ObjectInputStream(fips);

			restaurantMenu = (RestaurantMenu) input.readObject();
			System.out.println("Menu was successfully loaded.");
		} catch (Exception e) {
			System.out.println("Failed to load the menu. Error:" + e.getMessage());
			return false;
		}
		return true;
	}

	public static boolean saveMenu(String filePath) {
		if (restaurantMenu.getRestaurantName().isBlank()) {
			restaurantMenu.setRestaurantName(filePath);
		}
		try (FileOutputStream fops = new FileOutputStream(filePath)) {
			ObjectOutputStream output = new ObjectOutputStream(fops);
			output.writeObject(restaurantMenu);
			System.out.println("Successfully saved the menu.");
			return true;
		} catch (Exception e) {
			System.out.println("Failed to save the menu. Error: " + e.getMessage());
		}
		return false;
	}

	public static String getCurrentFileLoaded() {
		return fileLoaded;
	}
}
