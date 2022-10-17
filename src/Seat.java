public class Seat{

    private Ticket[][] seats;

    public Seat(){
        // Every Cinema's Seat will have 5 Rows and 10 Columns
        this.seats = new Ticket[5][10];
        Ticket newTicket = new Ticket();
        
        for(int i = 0; i < 5; i++){
            for(int a = 0; a < 10; a++){
                seats[i] = newTicket;
            }
        }
    }



    
}