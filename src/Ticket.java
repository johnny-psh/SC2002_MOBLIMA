public class Ticket{

    private Movie movie;
    private Seat seat;
    private int ticketID;
    
    public Ticket(int ticketID){
        movie = new Movie();
        seat = new Seat();
        this.ticketID = ticketID;
    }

    public Movie getMovie(){
        return movie;
    }

    public Seat getSeat(){
        return getSeat;
    }

    public int getTicketID(){
        return getTicketID;
    }

    public void setMovie(Movie movie){
        this.movie = movie;
    }

    public void setSeat(Seat seat){
        this.seat = seat;
    }

    public void setTicketID(int ticketID){
        this.ticketID = ticketID;
    }


    
}