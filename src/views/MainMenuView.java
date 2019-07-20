package views;


public class MainMenuView extends View {
	    
	public MainMenuView() {
		    super("\n---------------------------------------------------"
		        +"\n|  Main Menu                                      |"
		        +"\n---------------------------------------------------"
		        +"\nN - Start new game        "
		        +"\nG - Sart Existing Game"    
		        +"\nH - Get help on how to play the game"
		        +"\nS - Save Game"
		        +"\nQ - Quit"
		        +"\n---------------------------------------------------"
		        +"\n"
		        +"\n"
		        +"\nPlease enter your choice: ");
		}

	@Override
	public boolean doAction(String choice) {
	    choice = choice.toUpperCase();
	    
	    switch (choice) {
	        case "N": //create and start a new game
			                this.startNewGame();
	            break;
	        case "G": //get and start an existing game
		                this.startExistingGame();
	            break;   
	        case "H": //display help menu
			                this.showHelpMenu();
	            break;
	        default:
	        	System.out.printf(this.getClass().getName() +
	                    "\n***Invalid selection. Try again.");
	            break;
	    }
	    return false;
	}
	
	private void startNewGame()
	{
		System.out.printf("You selected startNewGame");
	}

	private void startExistingGame()
	{
		System.out.printf("You selected startExistingGame");
	}
	
	private void showHelpMenu()
	{
		View helpMenu = new HelpMenuView();
		helpMenu.display();
		
	}
}
