package views;

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
		case "H": // display help menu
			this.showHelpMenu();
			break;
		default:
			System.out.printf(this.getClass().getName() + "\n***Invalid selection. Try again.");
			break;
		}
		return false;
	}

	//output to user creating new menu
	private void createNewMenu() {
		System.out.printf("You selected Create New Menu");
	}

	//output to user loading menu
	private void loadExistingMenu() {
		System.out.printf("You selected Load Menu");
	}

	//display help menu
	private void showHelpMenu() {
		View helpMenu = new HelpMenuView();
		helpMenu.display();

	}

	//edit menu output to user
	private void continueEditing() {
		if (Sample.getRestaurantMenu() != null) {
			System.out.printf("You selected Continue Editing");
		} else {
			System.out.printf("That's not a valid option.");
		}
	}

	private static String getContinueMenuString() {
		if (Sample.getRestaurantMenu() != null) {
			return "\nC - Continue editing current menu";
		} else {
			return "";
		}
	}
	
	//menu display to user
	private static String getMainMenuString() {
		return "\n---------------------------------------------------"
				+ "\n|  Main Menu                                      |"
				+ "\n---------------------------------------------------" + "\nN - Create new menu"
				+ "\nL - Load existing menu" + getContinueMenuString() + "\nH - Get help on how to use this program"
				+ "\nQ - Quit" + "\n---------------------------------------------------" + "\n" + "\n"
				+ "\nPlease enter your choice: ";
	}
}
