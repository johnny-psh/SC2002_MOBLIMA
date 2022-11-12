package Model;
import java.text.SimpleDateFormat;  
import java.util.Date;  
/**
 * Transaction class 
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class Transaction {
    /**
     * Transaction ID
     */
    private String transactionID; // TID - XXXYYYYMMDDhhmm
    /**
     * Transaction date
     */
    private Date date;
    /**
     * Username of moviegoer
     */
    private String username;
    /**
     * Mobile number of moviegoer 
     */
    private String mobileNum;
    /**
     * Email of moviegoer
     */
    private String email;
    /**
     * Cinema ID of ticket bought 
     */
    private String cinemaID;
    /**
     * Name of movie purchased
     */
    private String movieName;
    /**
     * Number of tickets bought 
     */
    private int numOfTickets;
    /**
     * Total price of transaction 
     */
    private double totalPrice;
    /**
     * Creates new transaction records
     * @param username Username
     * @param mobileNum Mobile number 
     * @param email Email 
     * @param cinemaID Cinema ID
     * @param movieName Movie name 
     * @param numOfTickets Number of tickets
     * @param totalPrice Total price
     */
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
    /**
     * Get ID of this Transaction 
     * @return Transaction ID
     */
    public String getTransactionID(){
        return this.transactionID;
    }
    /**
     * Get date and time of this Transaction 
     * @return Date and time 
     */
    public Date getDateTime(){
        return this.date;
    }
    /**
     * Get username of this Transaction 
     * @return Username 
     */
    public String getUsername(){
        return this.username;
    }
    /**
     * Get mobile number of this Transaction 
     * @return Mobile number 
     */
    public String getMobileNum(){
        return this.mobileNum;
    }
    /**
     * Get email of this Transaction 
     * @return Email 
     */
    public String getEmail(){
        return this.email;
    }
    /**
     * Get cinema ID of this Transaction 
     * @return Cinema ID
     */
    public String getCinemaID(){
        return this.cinemaID;
    }
    /**
     * Get movie name of this Transaction 
     * @return Movie name 
     */
    public String getMovieName(){
        return this.movieName;
    }
    /**
     * Get number of tickets this Transaction 
     * @return Number of tickets 
     */
    public int getNumOfTickets(){
        return this.numOfTickets;
    }
    /**
     * Get total price of this Transaction 
     * @return Total price 
     */
    public double getTotalPrice(){
        return this.totalPrice;
    }
}
