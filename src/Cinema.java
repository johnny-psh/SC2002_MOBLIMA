public class Cinema{

    private Seat[][] seats;
    private Movie movie;

    public Cinema(){
        

        this.seats = new Seat[5][10];
        int counter = 0;

        for(int i = 0; i < 5; i++){
            for(int a = 0; a < 10; a++){
                Seat newSeat = new Seat(counter);
                seats[i][a] = newSeat;
                counter++;
            }
        }
    }
    
}