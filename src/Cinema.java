public class Cinema{

    // ENUMS
    public enum CinemaClass {
        
        REGULAR("Regular"), 
        DOLBY_ATMOS("Dolby Atmos"), 
        PLATINUM_MOVIE_SUITES("Platinum Movie Suites");

        private String cinemaClass;

        CinemaClass(String cinemaClass){
            this.cinemaClass = cinemaClass;
        }

        public String toString(){
            return this.cinemaClass;
        }
    }

    private CinemaClass cinemaClass;
    private Seat[][] seats;

    public Cinema(CinemaClass cinemaClass){
        
        this.cinemaClass = cinemaClass;

        // To be changed
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

    public CinemaClass getCinemaClass() {
        return this.cinemaClass;
    }

    public void setCinemaClass(CinemaClass cinemaClass) {
        this.cinemaClass = cinemaClass;
    }
    
}