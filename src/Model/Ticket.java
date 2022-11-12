package Model;
import java.util.Date;  
/**
 * Represents a ticket for a movie entry 
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class Ticket{
    /**
     * Seat of this Ticket
     */
    private Seat seat;
    /**
     * Showtime of this Ticket
     */
    private Showtime showtime;
    /**
     * Description of moviegoer for this Ticket 
     */
    private Enums.TypeOfMovieGoer movieGoerType;    
    /**
     * Type of movie for this Ticket
     */
    private Enums.TypeOfMovie movieType;
    /**
     * Type of Cinema for this Ticket
     */
    private Enums.CinemaType cinemaType; 
    /**
     * Date of this Ticket
     */
    private Date date;
    /**
     * Time of showing of this Ticket
     */
    private Date time;
    /**
     * Creates a new Ticket 
     * @param seat Seat of this Ticket
     * @param showtime Showtime of this Ticket 
     * @param movieGoerType Type of moviegoer of this Ticket
     */
    public Ticket(Seat seat, Showtime showtime, Enums.TypeOfMovieGoer movieGoerType){
        this.seat = seat;
        this.showtime = showtime;
        this.movieGoerType = movieGoerType;
        this.movieType = this.showtime.getMovie().getType();
        this.cinemaType = this.showtime.getCinema().getCinemaType();
        this.date = showtime.getDate();
        this.time = showtime.getTime();
    }
    /**
     * Gets the seat of this Ticket
     * @return Seat of this Ticket
     */
    public Seat getSeat(){
        return this.seat;
    }
    /**
     * Gets the showtime of this Ticket
     * @return Showtime of this Ticket 
     */
    public Showtime getShowtime(){
        return this.showtime;
    }
    /**
     * Gets the type of moviegoer for this Ticket
     * @return Type of moviegoer for this Ticket
     */
    public Enums.TypeOfMovieGoer getMovierGoerType(){
        return this.movieGoerType;
    }
    /**
     * Gets the type of movie for this Ticket 
     * @return Type of movie for this Ticket
     */
    public Enums.TypeOfMovie getMovieType(){
        return this.movieType;
    }
    /**
     * Gets the type of cinema for this Ticket
     * @return Type of cinema for this Ticket
     */
    public Enums.CinemaType getCinemaType(){
        return this.cinemaType;
    }
    /**
     * Gets the date for this Ticket
     * @return Date for this Ticket
     */
    public Date getDate(){
        return this.date;
    }
    /**
     * Gets the time for this Ticket
     * @return Time for this Ticket
     */
    public Date getTime(){
        return this.time;
    }
   
}