package views;

import java.util.Scanner;

// import ViewInterface;

public abstract class View implements ViewInterface {
	protected String displayMessage;

	public Scanner input = new Scanner(System.in);

	public View() {
	}

	public View(String message) {
		this.displayMessage = message;
	}

	@Override
	public void display() {
		boolean done = false; // set flag to not done

		do { // prompt for and get selected menu option
			System.out.println("\n" + this.displayMessage);
			String value = this.getInput();

			if (value.toUpperCase().equals("Q")) // user wants to quit
				return; // exit the menu

			// this will do the requested action and display the next view

			done = this.doAction(value);

		} while (!done);
	}

	/**
	 * The getInput Method purpose: to get input from the user
	 * 
	 * @param prompt
	 * @return value
	 */
	public String getInput(String prompt) {
		System.out.println("\n" + prompt);
		String value = this.getInput();
		return value;
	}

	@Override
	public String getInput() {
		String value = ""; // value to be returned
		boolean valid = false; // initialize to not valid
		try {
			while (!valid) { // loop while an invalid value is entered

				value = input.nextLine(); // get next line typed on keyboard
				value = value.trim(); // trim off leading and trailing blanks

				if (value.length() < 1) { // value is blank
					System.out.printf(this.getClass().getName(), "\nInvalid value: value cannot be blank");
					continue;
				}
				break; // end the loop
			}
		} catch (Exception e) {
			System.out.printf(this.getClass().getName(), "Error reading input: " + e.getMessage());
		}
		return value; // return the value entered
	}

	public double getDouble(String message) {
		try {
			System.out.print(message);
			String testString = getInput();
			double test2 = Double.parseDouble(testString);
			return test2;
		} catch (Exception e) {
			System.out.println("Invalid value.  Error: " + e.getMessage());
		}
		return -1;
	}

	public Integer getInt(String message) {
		try {
			System.out.print(message);
			String testString = getInput();
			int test2 = Integer.parseInt(testString);
			return test2;
		} catch (Exception e) {
			System.out.println("Invalid value.  Error: " + e.getMessage());
		}
		return -1;
	}
}
