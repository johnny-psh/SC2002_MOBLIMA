// Login plus display  menu in our main function
import java.util.Scanner;
import java.io.*;

public class MainMenuUI {
	
	static Scanner scanner = new Scanner(System.in);
   
	public static void displayMenu() throws IOException {
		
		int userOption = 0;
		while(userOption != 8) {
			System.out.println("1. Search/List movie");
			System.out.println("2. View movie details");
			System.out.println("3. Book and purchase ticket");
			System.out.println("4. View booking history");
			System.out.println("5. List the Top 5 ranking by ticket sales OR by overall reviewers’ ratings");
			System.out.println("6. Admin Login");
			System.out.println("7. Exit");
			System.out.print("Option > ");
			userOption = scanner.nextInt();
			
			switch(userOption) {
				case 1:
                    MovieListUI.displayMenu();
					break;
				case 2:
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
                    try {
                        LoginModule.Login();
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
				case 7:
					System.out.println("Goodbye!");	
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

