import java.util.Date;  

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

    public String getMovieName(){
        return this.movie.getTitle();
    }

    public String getCineplexName(){
        return this.cineplex.getCineplexeName();
    }

    public String getCinemaName(){
        return this.cinema.getCinemaName();
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

}
