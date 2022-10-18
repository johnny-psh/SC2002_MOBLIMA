public class Cinema{

    private Seat[][] seats;
    private Movie movie;

    public Cinema(){
        this.movie = new Movie();

        this.seats = new Seat[5][10];
        Ticket newTicket = new Ticket();

        for(int i = 0; i < 5; i++){
            for(int a = 0; a < 10; a++){
                seats[i] = newTicket;
            }
        }
    }
    
}