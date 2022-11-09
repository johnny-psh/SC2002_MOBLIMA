package View;
import java.util.ArrayList;
import java.util.Scanner;

import Controller.ViewBookingHistoryController;
import Model.Transaction;

public class BookingHistoryUI {
    static Scanner scanner = new Scanner(System.in);

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
