import java.text.SimpleDateFormat;  

public class TransactionPrinter {

    private Transaction transaction;

    public TransactionPrinter(Transaction transaction){
        this.transaction = transaction;
    }

    public String getFormattedDateTime(){
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");  
        return(dateTimeFormatter.format(this.transaction.getDateTime()));
    }

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
