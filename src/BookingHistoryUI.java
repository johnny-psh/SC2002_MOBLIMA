import java.util.ArrayList;
import java.util.Scanner;

public class BookingHistoryUI {
    static Scanner scanner = new Scanner(System.in);

    public static void displayMenu(){
        String username;

        System.out.print("Enter your username: ");
        username = scanner.next();

        ArrayList<Transaction> transactionList = BookingHistoryController.readByUsername(username);
        if(transactionList.isEmpty()){
            System.out.println("\nYour booking history is empty. Book a ticket now!");
            System.out.println("Returning to main menu...\n");
            return;
        }
        else{
            System.out.println("\nBooking history of " + username + ":\n");
            for (Transaction transaction: transactionList){
                TransactionPrinter transactionPrinter = new TransactionPrinter(transaction);
                 transactionPrinter.printTransaction();
            }
            System.out.print("Enter any character to exit: ");
            scanner.next().charAt(0);
            return;
        }
    }
}
