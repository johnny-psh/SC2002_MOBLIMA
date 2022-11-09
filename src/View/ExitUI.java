package View;
import java.util.Scanner;

public class ExitUI {
    static Scanner scanner = new Scanner(System.in);
    
    public static void displayMenu(){
        System.out.print("\nEnter any character to exit: ");
        scanner.next().charAt(0);
        System.out.println("\nReturning to main menu...\n");
        return;
    }
}
