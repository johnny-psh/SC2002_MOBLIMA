package View;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.ViewBookingHistoryController;
import Model.Transaction;
/**
 * Class of user interface for booking history 
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class BookingHistoryUI {
    static Scanner scanner = new Scanner(System.in);
    /**
     * Method to display booking history menu 
     */
    public static void displayMenu(){
        String username;

        System.out.print("Enter your username: ");
        username = scanner.next();

        ArrayList<Transaction> transactionList = ViewBookingHistoryController.readByUsername(username);
        if(transactionList.isEmpty())
            System.out.println("\nYour booking history is empty. Book a ticket now!");

        else{
            System.out.println("\nBooking history of " + username + ":\n");
            for (Transaction transaction: transactionList){
                TransactionPrinter transactionPrinter = new TransactionPrinter(transaction);
                transactionPrinter.printTransaction();
            }
        }

        ExitUI.displayMenu();
        return;
    }
}
