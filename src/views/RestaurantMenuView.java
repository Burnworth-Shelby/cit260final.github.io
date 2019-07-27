package views;

import java.util.ArrayList;

import model.Beverage;
import model.Food;
import model.RestaurantMenu;
import model.RestaurantMenuItem;

public class RestaurantMenuView extends View {

	public RestaurantMenuView() {
		super(getRestaurantMenuString());
	}

	@Override
	public boolean doAction(String choice) {
		choice = choice.toUpperCase();

		switch (choice) {
		case "A": // create a menu item
			this.addMenuItem();
			break;
		case "E": // edit a menu item
			this.editMenuItem();
			break;
		case "D": // delete a menu item
			this.deleteMenuItem();
			break;
		case "R": // rename the restaurant
			this.renameRestaurant();
			break;
		case "P": // print menu to console
			this.printMenu();
			break;
		default:
			System.out.printf(this.getClass().getName() + "\n***Invalid selection. Try again.");
			break;
		}

		displayMessage = getRestaurantMenuString();

		return false;
	}

	private void addMenuItem() {
		String itemName = getInput("What is the item called?");
		RestaurantMenuItem newItem = null;
		boolean promptType = true;
		while (promptType) {
			String itemType = getInput("What type of item is \"" + itemName
					+ "\"?\n A - Appetizer\n E - Entree\n D - Dessert\n B - Beverage");
			itemType = itemType.toUpperCase();
			if (itemType.equals("A") || itemType.equals("E") || itemType.equals("D")) {

				switch (itemType) {
				case "A": // add an appetizer menu item
					itemType = "Appetizer";
					break;
				case "E": // add an entree menu item
					itemType = "Entree";
					break;
				case "D": // add a dessert menu item
					itemType = "Dessert";
					break;
				}
				Food newFoodItem = new Food();
				newFoodItem.setItemType(itemType);
				newFoodItem.setDescription(getInput("Please provide a description for\"" + itemName + "\""));
				newItem = newFoodItem;
				promptType = false;
			} else if (itemType.equals("B")) {
				Beverage newBeverageItem = new Beverage();
				boolean refillable = false;
				boolean promptRefillable = true;
				while (promptRefillable) {
					String refillableInput = getInput("Is this item refillable? (y/n)");
					refillableInput = refillableInput.toUpperCase();
					if (refillableInput.equals("Y")) {
						refillable = true;
						promptRefillable = false;
					} else if (refillableInput.equals("N")) {
						promptRefillable = false;
					} else {
						System.out.println("***Invalid input.  Try again.");
					}
				}
				newBeverageItem.setRefillable(refillable);
				newItem = newBeverageItem;
				promptType = false;
			} else {
				System.out.println("***Invalid input.  Try again.");
			}
			newItem.setName(itemName);
			newItem.setCalories(getInt("\nHow many calories does a serving of " + itemName + " contain? "));
			newItem.setPrice(getDouble("How much does " + itemName + " cost? "));
			RestaurantMenu currentMenu = Sample.getRestaurantMenu();
			currentMenu.addMenuItem(newItem);
			Sample.setRestaurantMenu(currentMenu);
		}

	}

	private void editMenuItem() {
		RestaurantMenu currentMenu = Sample.getRestaurantMenu();
		int index = 1;
		String editPrompt = "Which item would you like to edit?";
		for (RestaurantMenuItem item : currentMenu.getMenuItems()) {
			editPrompt += "\n " + index + " - " + item.getName() + " (" + item.getPrice() + ")";
			index++;
		}
		editPrompt += "\n";
		int editItemIndex = getInt(editPrompt) - 1;

		View EditItemMenu = new EditItemView(currentMenu.getMenuItem(editItemIndex));
		EditItemMenu.display();
	}

	private void deleteMenuItem() {
		RestaurantMenu currentMenu = Sample.getRestaurantMenu();
		int index = 1;
		String deletePrompt = "Which item would you like to edit?";
		for (RestaurantMenuItem item : currentMenu.getMenuItems()) {
			deletePrompt += "\n " + index + " - " + item.getName() + " (" + item.getPrice() + ")";
			index++;
		}
		deletePrompt += "\n";
		int deleteItemIndex = getInt(deletePrompt) - 1;
		currentMenu.removeMenuItem(deleteItemIndex);
	}

	private void renameRestaurant() {
		String newName = getInput("What is the new name of your restaurant?");
		Sample.getRestaurantMenu().setRestaurantName(newName);
	}

	private void printMenu() {
		RestaurantMenu currentMenu = Sample.getRestaurantMenu();
		ArrayList<RestaurantMenuItem> currentMenuItems = currentMenu.getMenuItems();
		String separator = "------------------------------------------------------------\n";
		System.out.println("\n\n" + separator + separator + "             " + currentMenu.getRestaurantName() + "\n"
				+ separator + separator);
		System.out.println("  APPETIZERS");
		for (RestaurantMenuItem item : currentMenuItems) {
			if (item.getItemType().equals("Appetizer")) {
				System.out.println(item.asString());
			}
		}
		System.out.println("\n  ENTREES");
		for (RestaurantMenuItem item : currentMenuItems) {
			if (item.getItemType().equals("Entree")) {
				System.out.println(item.asString());
			}
		}
		System.out.println("\n  BEVERAGES    * indicates that beverage is refillable");
		for (RestaurantMenuItem item : currentMenuItems) {
			if (item.getItemType().equals("Beverage")) {
				System.out.println(item.asString());
			}
		}
		System.out.println("\n  DESSERTS");
		for (RestaurantMenuItem item : currentMenuItems) {
			if (item.getItemType().equals("Dessert")) {
				System.out.println(item.asString());
			}
		}
	}

	// menu display to user
	private static String getRestaurantMenuString() {
		return "\n---------------------------------------------------" + "\n  Restaurant Menu Creator - "
				+ Sample.getRestaurantMenu().getRestaurantName()
				+ "\n---------------------------------------------------" + "\nA - Add a menu item"
				+ "\nE - Edit a menu item" + "\nD - Delete a menu item" + "\nR - Rename restaurant"
				+ "\nP - Print menu to console" + "\nQ - Return to main menu"
				+ "\n---------------------------------------------------" + "\nPlease enter your choice: ";
	}
}
