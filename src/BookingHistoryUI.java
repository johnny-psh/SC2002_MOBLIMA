import java.util.ArrayList;
import java.util.Scanner;

public class BookingHistoryUI {
    static Scanner scanner = new Scanner(System.in);

    public static void displayMenu(){
        String username;

        System.out.print("Enter your username: ");
        username = scanner.next();
        System.out.println("\nBooking history of " + username + ":\n");

        ArrayList<Transaction> transactionList = BookingHistoryController.readByMovieGoerUsername(username);
        if(transactionList.isEmpty()){
            System.out.println("Your booking history is empty. Book a ticket now!");
        }
        else{
            transactionList.forEach(transaction -> System.out.println(transaction.toString()));
            System.out.print("Enter any character to exit: ");
            scanner.next().charAt(0);
            return;
        }
    }
}
