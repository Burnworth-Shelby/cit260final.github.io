package views;

import model.RestaurantMenu;

public class MainMenuView extends View {

	public MainMenuView() {
		super(getMainMenuString());
	}

	@Override
	public boolean doAction(String choice) {
		choice = choice.toUpperCase();

		switch (choice) {
		case "N": // create and start a new game
			this.createNewMenu();
			break;
		case "L": // get and start an existing game
			this.loadExistingMenu();
			break;
		case "C": // display help menu
			this.continueEditing();
			break;
		case "S":
			this.saveMenu();
			break;
		default:
			System.out.printf(this.getClass().getName() + "\n***Invalid selection. Try again.");
			break;
		}

		displayMessage = getMainMenuString();

		return false;
	}

	// output to user creating new menu
	private void createNewMenu() {
		String restaurantName = this.getInput("What is the name of your restaurant?");
		Sample.setRestaurantMenu(new RestaurantMenu(restaurantName));
		View createMenu = new RestaurantMenuView();
		createMenu.display();
	}

	// output to user loading menu
	private void loadExistingMenu() {
		String fileName = getInput("Enter filename:");
		if (Sample.getSavedMenu(fileName)) {
			displayMessage = getMainMenuString();
		}
	}

	// edit menu output to user
	private void continueEditing() {
		if (Sample.getRestaurantMenu() != null) {
			RestaurantMenuView restaurantMenuView = new RestaurantMenuView();
			restaurantMenuView.display();
		} else {
			System.out.printf("That's not a valid option.");
		}
	}

	private void saveMenu() {
		String fileName = getInput("Enter filename:");
		if (Sample.saveMenu(fileName)) {
			displayMessage = getMainMenuString();
		}
	}

	private static String getContinueMenuString() {
		if (Sample.getRestaurantMenu() != null) {
			return "\nC - Continue editing menu, \"" + Sample.getRestaurantMenu().getRestaurantName() + "\"";
		} else {
			return "";
		}
	}

	private static String getSaveMenuString() {
		if (Sample.getRestaurantMenu() != null) {
			return "\nS - Save menu, \"" + Sample.getRestaurantMenu().getRestaurantName() + "\"";
		} else {
			return "";
		}
	}

	// menu display to user
	private static String getMainMenuString() {
		return "\n---------------------------------------------------"
				+ "\n|  Main Menu                                      |"
				+ "\n---------------------------------------------------" + "\nN - Create new menu"
				+ "\nL - Load menu from a file" + getContinueMenuString() + getSaveMenuString() + "\nQ - Quit"
				+ "\n---------------------------------------------------" + "\nPlease enter your choice: ";
	}
}
