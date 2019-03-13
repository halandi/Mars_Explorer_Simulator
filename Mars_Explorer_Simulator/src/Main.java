import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static String command;

	public static void main(String[] args) {
		
		String regex;
		Pattern pattern;
		Matcher matcher;
		boolean matches;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Whats your name? : ");
		
		String user_name = input.nextLine();
		
		System.out.print("Hi " + user_name + ", Welcome to Mars Explorer Simulator \n");
		
		Game game = new Game();
		game.GameMap();
		
		while(true) {
		
		System.out.println("Enter your command:\n");
		
		command = input.nextLine();
		
		
		if(command.contains("PLACE")) {
			 regex = "(PLACE( )[0-4](,)[0-4])";
			 pattern = Pattern.compile(regex);
			 matcher = pattern.matcher(command);
			 matches = matcher.matches();
			
			if (matches == true) {
				
				 int X = Integer.parseInt(String.valueOf(command.charAt(6)));
				 int Y = Integer.parseInt(String.valueOf(command.charAt(8)));

				 game.placeExplorer(X, Y);
			}
			
		} else if (command.contains("EXIT")){
			System.out.println("Exiting...");
			System.exit(0);
		} else if (game.isExplorerDeployed == true) {
			if (command.contains("REPORT")) {
				game.reportExplorer();
			} else if (command.contains("MOVE") ) {
				 regex = "(MOVE( )[0-4](,)[0-4])";
				 pattern = Pattern.compile(regex);
				 matcher = pattern.matcher(command);
				 matches = matcher.matches();
				 System.out.println(command);

				 if (matches == true) {
					 int X = Integer.parseInt(String.valueOf(command.charAt(5)));
					 int Y = Integer.parseInt(String.valueOf(command.charAt(7)));

					 game.moveExplorer(X, Y);
				 } else {
					System.out.println("Invalid Command");
				 }
			} else {
				System.out.println("Invalid Command");
			}
		} else {
			System.out.println("Invalid Command");
		}

		//game.placeExplorer(0, 1);
		//game.reportExplorer();
		//game.moveExplorer(3, 4);
		
		game.update();
		}
		
	}

}
