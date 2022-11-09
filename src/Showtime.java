import java.util.Date;  
import java.text.SimpleDateFormat;

public class Showtime {
    private Movie movie;
    private Cineplex cineplex;
    private Cinema cinema;
    private Date date, time;
    
    public Showtime(Movie movie, Cineplex cineplex, Cinema cinema, Date date, Date time){
        this.movie = movie;
        this.cineplex = cineplex;
        this.cinema = cinema;
        this.date = date;
        this.time = time;
    }

    public Movie getMovie(){
        return this.movie;
    }

    public Cineplex getCineplex(){
        return this.cineplex;
    }

    public Cinema getCinema(){
        return this.cinema;
    }

    public Date getDate(){
        return this.date;
    }

    public Date getTime(){
        return this.time;
    }

    public String getFormattedDate(){
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("dd/MM/yyyy");
        return (dateTimeFormatter.format(this.date));  
    }

    public String getFormattedTime(){
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("HH:mm");
        return (dateTimeFormatter.format(this.time));
    }

    public void printShowtime(){
        System.out.println(
        this.getFormattedDate() 
        + " - " +  this.getFormattedTime()
        + " - " + this.getCinema().getCinemaID() 
        + " - " + this.getCinema().getCinemaType().toString() 
        + " - " + this.getMovie().getTitle()); 
    }

}
