/**
* The Sample class is the main controller where the program starts.
*
* @author  Carson Fairbourn & Shelby Burnworth
*/

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
		MainMenuView mainMenu = new MainMenuView();
		mainMenu.display();
		System.out.printf("Program Terminated.");
	}

	/**
	 * @return the restaurantMenu
	 */
	public static RestaurantMenu getRestaurantMenu() {
		return restaurantMenu;
	}

	/**
	 * @param restaurantMenu
	 * @param myMenu
	 */
	public static void setRestaurantMenu(RestaurantMenu myMenu) {
		restaurantMenu = myMenu;
	}

	// load file
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

	// save file
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
