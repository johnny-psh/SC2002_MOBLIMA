import java.util.Date;

public class Transaction {
    private String transactionID; // TID - XXXYYYYMMDDhhmm
    private String cinemaID;
    private Date date;
    private int numOfTickets;

    public Transaction(int numOfTickets, String cinemaID){
        this.date = 
        this.transactionID = "" + cinemaID + this.date.toString();
    }

    public String getTransactionID(){
        return this.transactionID;
    }
}
