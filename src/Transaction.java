import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Transaction {
    private String transactionID; // TID - XXXYYYYMMDDhhmm
    private Date date;
    private String username;
    private String mobileNum;
    private String email;
    private String cinemaID;
    private String movieName;
    private int numOfTickets;
    private double totalPrice;

    public Transaction(String username, String mobileNum, String email, String cinemaID, String movieName, int numOfTickets, Double totalPrice){
        this.username = username;
        this.mobileNum = mobileNum;
        this.email = email;
        this.cinemaID = cinemaID;
        this.movieName = movieName;
        this.numOfTickets = numOfTickets;
        this.totalPrice = totalPrice;
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyyMMddHHmm");  
        this.date = new Date();  
        this.transactionID = "" + this.cinemaID + dateTimeFormatter.format(this.date);
    }

    public String getTransactionID(){
        return this.transactionID;
    }

    public Date getDateTime(){
        return this.date;
    }

    public String getUsername(){
        return this.username;
    }

    public String getMobileNum(){
        return this.mobileNum;
    }

    public String getEmail(){
        return this.email;
    }

    public String getCinemaID(){
        return this.cinemaID;
    }

    public String getMovieName(){
        return this.movieName;
    }

    public int getNumOfTickets(){
        return this.numOfTickets;
    }

    public double getTotalPrice(){
        return this.totalPrice;
    }
}
