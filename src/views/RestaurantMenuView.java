package views;

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
			System.out.println(itemType);
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
			} else if (itemType == "B") {
				Beverage newBeverageItem = new Beverage();
				boolean refillable = false;
				boolean promptRefillable = true;
				while (promptRefillable) {
					String refillableInput = getInput("Is this item refillable? (y/n)");
					refillableInput = refillableInput.toUpperCase();
					if (refillableInput == "Y") {
						refillable = true;
						promptRefillable = false;
					} else if (refillableInput == "N") {
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
			newItem.setCalories(getInt("How many calories does a serving of " + itemName + " contain?"));
			newItem.setPrice(getDouble("How much does " + itemName + " cost?"));
			RestaurantMenu currentMenu = Sample.getRestaurantMenu();
			currentMenu.addMenuItem(newItem);
			Sample.setRestaurantMenu(currentMenu);
		}

	}

	private void editMenuItem() {
		System.out.printf("You selected edit menu item");
	}

	private void deleteMenuItem() {
		System.out.printf("You selected delete menu item");
	}

	private void renameRestaurant() {
		System.out.printf("You selected rename restaurant");
	}

	private void printMenu() {
		System.out.printf("You selected print menu");
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
