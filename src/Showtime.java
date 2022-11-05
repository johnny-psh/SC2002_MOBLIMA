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

    public String getMovieName(){
        return this.movie.getTitle();
    }

    public Cineplex getCineplex(){
        return this.cineplex;
    }

    public Cinema getCinema(){
        return this.cinema;
    }

    public String getCinemaName(){
        return this.cinema.getCinemaName();
    }

    public Enums.CinemaType getCinemaType(){
        return this.cinema.getCinemaType();
    }

    public Date getDate(){
        return this.date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getTime(){
        return this.time;
    }

    public void setTime(Date time){
        this.time = time;
    }

    public String getFormattedDate(){
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("dd/MM/yyyy");
        return (dateTimeFormatter.format(this.date));  
    }


    public void printShowtime(){
        // Example - 15:00 - Hall5 - CinemaType - Avengers
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("HH:mm");
        System.out.print(" " + dateTimeFormatter.format(this.time)); 
        System.out.print(" - " + this.getCinemaName() + " - " + this.getCinemaType().toString() + " - " + this.getMovieName()); 
    }

}
