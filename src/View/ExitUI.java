package View;
import java.util.Scanner;
/**
 * Class for exiting user interface 
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class ExitUI {
    static Scanner scanner = new Scanner(System.in);
    /**
     * Method to display exit menu
     */
    public static void displayMenu(){
        System.out.print("\nEnter any character to exit: ");
        scanner.next().charAt(0);
        System.out.println("\nReturning to main menu...\n");
        return;
    }
}
