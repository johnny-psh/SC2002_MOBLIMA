package View;
import java.util.Scanner;
import java.io.*;
/**
 * Class of user interface for main menu
 * @author Group 6 
 * @version 1.0
 * @since 12/11/2022
 */
public class MainMenuUI {
	
	static Scanner scanner = new Scanner(System.in);
	/**
	 * Method to display main menu
	 * @throws IOException
	 */
	public static void displayMenu() throws IOException {
		
		int userOption = 0;
		while(userOption != 8) {
			System.out.println("Main Menu:");
			System.out.println("1. List movies");
			System.out.println("2. Search and view movie details");
			System.out.println("3. Book and purchase ticket");
			System.out.println("4. View booking history");
			System.out.println("5. List the Top 5 ranking by ticket sales OR by overall reviewers ratings");
			System.out.println("6. Review a movie");
			System.out.println("7. Admin Login");
			System.out.println("8. Exit");
			System.out.print("Option > ");
			userOption = scanner.nextInt();
			
			switch(userOption) {
				case 1:
                    MovieListUI.displayMenu();
					break;
				case 2:
				//Done
                    ViewMovieDetailUI.displayMenu();
					break;
				case 3:
					BookingUI.displayMenu();
					break;
				case 4:
                    BookingHistoryUI.displayMenu();
					break;
				case 5:
                    ListTopMoviesUI.displayMenu();
					break;
				case 6:
					ReviewUI.displayMenu();
					break;
				case 7:
                    try {
                        LoginModule.Login();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
				case 8:
					System.out.println("\nGoodbye!");	
					System.out.println("   ______      __  __                   _______                  __                       ");
					System.out.println("  / ____/___ _/ /_/ /_  ____ ___  __   / ____(_)___  ___  ____  / /__  _  _____  _____    ");
					System.out.println(" / /   / __ `/ __/ __ \\/ __ `/ / / /  / /   / / __ \\/ _ \\/ __ \\/ / _ \\| |/_/ _ \\/ ___/   ");
					System.out.println("/ /___/ /_/ / /_/ / / / /_/ / /_/ /  / /___/ / / / /  __/ /_/ / /  __/>  </  __(__  )     ");
					System.out.println("\\____/\\__,_/\\__/_/ /_/\\__,_/\\__, /   \\____/_/_/ /_/\\___/ .___/_/\\___/_/|_|\\___/____/      ");
					System.out.println("                           /____/                     /_/                                 ");
					break;
				default:
					System.out.println("Invalid Option!");
					System.out.println("Please re-enter!");
					break;
			}
		}
	}

}

