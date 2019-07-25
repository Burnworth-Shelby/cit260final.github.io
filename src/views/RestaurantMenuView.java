package views;

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
		System.out.printf("You selected add item to menu");
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
