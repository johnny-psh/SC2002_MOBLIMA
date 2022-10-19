public class Ticket{

    private Movie movie;
    private Seat seat;
    private int ticketID;
    
    public Ticket(int ticketID, String movieName, int seatID){
        movie = new Movie(movieName);
        seat = new Seat(seatID);
        this.ticketID = ticketID;
    }

    public Movie getMovie(){
        return movie;
    }

    public Seat getSeat(){
        return seat;
    }

    public int getTicketID(){
        return ticketID;
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