package Model;
import java.util.Date;  
import java.text.SimpleDateFormat;
/**
 * Represents the movie Showtime with details including cineplex, cinema, date and time
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class Showtime {
    /**
     * Movie of this Showtime
     */
    private Movie movie;
    /**
     * Cineplex of this Showtime
     */
    private Cineplex cineplex;
    /**
     * Cinema number of this showtime
     */
    private Cinema cinema;
    /**
     * Date of this Showtime
     */
    private Date date;
    /**
     * Time of this Showtime
     */
    private Date time;
    /**
     * Creates movie new Showtime
     * @param movie Movie of this Showtime
     * @param cineplex Cineplex of this Showtime
     * @param cinema Cinema number of this Showtime
     * @param date Date of this Showtime 
     * @param time Time of this Showtime
     */
    public Showtime(Movie movie, Cineplex cineplex, Cinema cinema, Date date, Date time){
        this.movie = movie;
        this.cineplex = cineplex;
        this.cinema = cinema;
        this.date = date;
        this.time = time;
    }
    /**
     * Gets movie of this Showtime 
     * @return Movie of this Showtime
     */
    public Movie getMovie(){
        return this.movie;
    }
    /**
     * Gets cineplex of this Showtime
     * @return Cineplex of this Showtime
     */
    public Cineplex getCineplex(){
        return this.cineplex;
    }
    /**
     * Gets cinema of this Showtime
     * @return Cinema of this Showtime
     */
    public Cinema getCinema(){
        return this.cinema;
    }
    /**
     * Gets the date of this Showtime
     * @return Date of this Showtime
     */
    public Date getDate(){
        return this.date;
    }
    /**
     * Gets the time of this Showtime
     * @return Time of this Showtime
     */
    public Date getTime(){
        return this.time;
    }
    /**
     * Gets the formatted date of this Showtime
     * @return Formatted date of this Showtime
     */
    public String getFormattedDate(){
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("dd/MM/yyyy");
        return (dateTimeFormatter.format(this.date));  
    }
    /**
     * Gets the formatted time of this Showtime 
     * @return Formatted time of this Showtime
     */
    public String getFormattedTime(){
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("HH:mm");
        return (dateTimeFormatter.format(this.time));
    }
    /**
     * Display this Showtime 
     */
    public void printShowtime(){
        System.out.println(
        this.getFormattedDate() 
        + " - " +  this.getFormattedTime()
        + " - " + this.getCinema().getCinemaID() 
        + " - " + this.getCinema().getCinemaType().toString() 
        + " - " + this.getMovie().getTitle()); 
    }

}
