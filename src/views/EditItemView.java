package views;

import model.Beverage;
import model.Food;
import model.RestaurantMenuItem;

public class EditItemView extends View {

	private RestaurantMenuItem editItem = null;

	public EditItemView(RestaurantMenuItem myEditItem) {
		super(getEditPrompt(myEditItem));
		this.editItem = myEditItem;
	}

	@Override
	public boolean doAction(String choice) {
		choice = choice.toUpperCase();

		switch (choice) {
		case "N": // create and start a new menu
			this.newName();
			break;
		case "P": // get and start an existing menu
			this.newPrice();
			break;
		case "C": // get and start an existing menu
			this.newCalories();
			break;
		case "R": // get and start an existing menu
			this.newRefillable();
			break;
		case "D": // get and start an existing menu
			this.newDescription();
			break;
		case "T": // get and start an existing menu
			this.newItemType();
			break;
		default:
			System.out.printf(this.getClass().getName() + "\n***Invalid selection. Try again.");
			break;
		}

		displayMessage = getEditPrompt(this.editItem);
		return false;
	}

	private void newItemType() {
		boolean promptType = true;
		while (promptType) {
			String itemType = getInput(
					"What type of item is \"" + editItem.getName() + "\"?\n A - Appetizer\n E - Entree\n D - Dessert");
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
				((Food) editItem).setItemType(itemType);
				promptType = false;
			} else {
				System.out.println("***Invalid input.  Try again.");
			}
		}

	}

	private void newDescription() {
		String newDesc = getInput("What should the new description be?\n");
		((Food) editItem).setDescription(newDesc);
	}

	private void newRefillable() {
		boolean refillable = false;
		boolean promptRefillable = true;
		while (promptRefillable) {
			String refillableInput = getInput("Is this item refillable? (y/n) ");
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
		((Beverage) editItem).setRefillable(refillable);
	}

	private void newCalories() {
		int newCalories = getInt("\nHow many calories are in a serving of this item? ");
		editItem.setCalories(newCalories);
	}

	private void newPrice() {
		double newPrice = getDouble("\nWhat is the price of this item? ");
		editItem.setPrice(newPrice);
	}

	private void newName() {
		String newName = getInput("What is the name of this item? ");
		editItem.setName(newName);
	}

	private static String getEditPrompt(RestaurantMenuItem editItem) {
		String editPrompt = "\n\nWhat attribute would you like to edit?";
		editPrompt += "\n N - Name || " + editItem.getName() + "\n P - Price || " + editItem.getPrice()
				+ "\n C - Calories || " + editItem.getCalories();

		if (editItem.getItemType().equals("Beverage")) {
			Beverage myEditItem = (Beverage) editItem;
			String refillableMarker = "No";
			if (myEditItem.isRefillable()) {
				refillableMarker = "Yes";
			}
			editPrompt += "\n R - Refillable || " + refillableMarker;
		} else {
			Food myEditItem = (Food) editItem;
			editPrompt += "\n D - Description || " + myEditItem.getDescription();
			editPrompt += "\n T - Item Type || " + myEditItem.getItemType();
		}
		editPrompt += "\n Q - Return to previous menu";
		return editPrompt;
	}

	private void OtherHelp() {
		System.out.printf("You selected OtherHelp");

	}

	private void ClassHelp() {
		// TODO Auto-generated method stub
		System.out.printf("You selected ClassHelp");
	}

}
