public class Cinema{

    private Seat[][] seats;
    private Movie movie;

    public Cinema(Movie movie){
        this.movie = movie;

        this.seats = new Seat[5][10];
        Ticket newTicket = new Ticket(0, movie.getMovie);

        for(int i = 0; i < 5; i++){
            for(int a = 0; a < 10; a++){
                seats[i][a] = newTicket;
            }
        }
    }
    
}