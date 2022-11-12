package View;
import java.text.SimpleDateFormat;

import Model.Transaction;  
/**
 * Class to display Transaction summary 
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class TransactionPrinter {

    private Transaction transaction;
    /**
     * Create a new transaction 
     * @param transaction Transaction variable
     */
    public TransactionPrinter(Transaction transaction){
        this.transaction = transaction;
    }
    /**
     * Method to get formatted date 
     * @return Date in correct formate 
     */
    public String getFormattedDateTime(){
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");  
        return(dateTimeFormatter.format(this.transaction.getDateTime()));
    }
    /**
     * Method to display transaction details 
     * @param transaction Transaction variable
     */
    public void printTransaction(){
		System.out.println(
        "Transaction " + this.transaction.getTransactionID()+ "\n"
        + "Datetime: " + getFormattedDateTime() + "\n"
        + "Movie: " + this.transaction.getMovieName() + "\n"
        + "Cinema ID: " + this.transaction.getCinemaID() + "\n"
        + "Quantity : " + this.transaction.getNumOfTickets() + "\n"
        + "Total price paid: " + this.transaction.getTotalPrice() + "\n"); 	
    }

}
