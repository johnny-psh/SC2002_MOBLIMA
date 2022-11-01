import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Transaction {
    private String transactionID; // TID - XXXYYYYMMDDhhmm
    private String cinemaID;
    private Date date;

    public Transaction(String cinemaID){
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyyMMddHHmm");  
        this.date = new Date();  
        this.transactionID = "" + cinemaID + dateTimeFormatter.format(this.date);
    }

    public String getTransactionID(){
        return this.transactionID;
    }
    
    public String getCinemaID(){
        return this.cinemaID;
    } 
}
