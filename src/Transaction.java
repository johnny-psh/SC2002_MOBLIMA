import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Transaction {
    private String transactionID; // TID - XXXYYYYMMDDhhmm
    private String cinemaID;
    private Date date;
    private String username;
    private Showtime showtime;

    public Transaction(Showtime showtime, String username){
        this.showtime = showtime;
        this.username = username;

        this.cinemaID = showtime.getCinema().getCinemaID();
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyyMMddHHmm");  
        this.date = new Date();  
        this.transactionID = "" + cinemaID + dateTimeFormatter.format(this.date);
    }

    public String getTransactionID(){
        return this.transactionID;
    }

    public String getUsername(){
        return this.username;
    }

    public String toString(){
        String toReturn = "";
		toReturn 	+= "Transaction ID: " + this.getTransactionID() + "\n"
					+ "Movie: " + this.showtime.getMovie().getTitle() + "\n"
					+ "Movie Date: " + this.showtime.getFormattedDate() + "\n"
					+ "Movie Time: " + this.showtime.getFormattedTime() + "\n\n";
		return toReturn; 
    }
}
