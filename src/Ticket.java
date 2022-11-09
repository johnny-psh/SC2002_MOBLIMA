import java.util.Date;  
public class Ticket{

    private Seat seat;
    private Showtime showtime;
    private Enums.TypeOfMovieGoer movieGoerType;
    private Enums.TypeOfMovie movieType;
    private Enums.CinemaType cinemaType; 
    private Date date;
    private Date time;
    
    public Ticket(Seat seat, Showtime showtime, Enums.TypeOfMovieGoer movieGoerType){
        this.seat = seat;
        this.showtime = showtime;
        this.movieGoerType = movieGoerType;
        this.movieType = this.showtime.getMovie().getType();
        this.cinemaType = this.showtime.getCinema().getCinemaType();
        this.date = showtime.getDate();
        this.time = showtime.getTime();
    }

    public Seat getSeat(){
        return this.seat;
    }

    public Showtime getShowtime(){
        return this.showtime;
    }
    
    public Enums.TypeOfMovieGoer getMovierGoerType(){
        return this.movieGoerType;
    }

    public Enums.TypeOfMovie getMovieType(){
        return this.movieType;
    }

    public Enums.CinemaType getCinemaType(){
        return this.cinemaType;
    }

    public Date getDate(){
        return this.date;
    }

    public Date getTime(){
        return this.time;
    }
   
}