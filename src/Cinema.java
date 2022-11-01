public class Cinema{

    private String cinemaID; // 3 digit code
    private Enums.CinemaType cinemaType;
    private Seat[][] seats;
    private int numOfRows;
    private int numOfCols;

    public Cinema(String cinemaID, Enums.CinemaType cinemaType, int numOfRows, int numOfCols){
        this.cinemaID = cinemaID;
        this.cinemaType = cinemaType;
        this.numOfRows = numOfRows;
        this.numOfCols = numOfCols;
        seats = new Seat[this.numOfRows][this.numOfCols];
        for(int i = 1; i <= this.numOfRows; i++){
            for(int j = 1; j <= this.numOfCols; j++){
                this.seats[i-1][j-1] = new Seat((char)(i+64), j);
            }
        }
    }

    public void printCinemaLayout(){
        int mid = this.numOfCols / 2;

        System.out.println("\nCinema " + this.cinemaID + "'s Seating Layout: \n");
        System.out.print(" \t");

        // Column numbering headers
        for(int i = 1; i <= this.numOfRows; i++){
            System.out.print("  " + i + "  ");
            if(i == mid)
                System.out.print("    "); // Isle
        }
        System.out.print("\n");
        // Print each row of seats and it's respective row alphabet. Mark X if seat occupied.
        for(int i = this.numOfRows; i >= 1; i--){
            System.out.print((char) (i+64) + "\t"); //Row alphabet
            for(int j = 1; j <= this.numOfCols; j++){
                System.out.print(this.seats[i-1][j-1].getIsOccupied() ? " [X] " : " [ ] ");
                if(j == mid)
                    System.out.print("    "); // Isle
            }
            System.out.println("\t" + (char) (i+64)); //Row alphabet
        }
    }

    public String getCinemaID(){
        return this.cinemaID;
    }

    public Enums.CinemaType getCinemaType(){
        return this.cinemaType;
    }

    public int getNumOfRows(){
        return this.numOfRows;
    }

    public int getNumOfCols(){
        return this.numOfCols;
    }

    private Seat getSeat(char row, int col){
        int rowNum = row - 'A';
        int colNum = col-1;
        if(rowNum < this.numOfRows && colNum < this.numOfCols)
            return this.seats[rowNum][colNum];
        return null;
    }
    
    // Method to set a certain seat as occupied in Cinema
    public void setSeatOccupied(char row, int col){
        this.getSeat(row, col).setIsOccupied(true);
    }

    public boolean getSeatOccupied(char row, int col){
        return this.getSeat(row, col).getIsOccupied();
    }

    // For testing purposes - Delete afterwards
    // This is how booking seat will be implemented in booking class
    // public static void main (String[] args){
    //     Cinema cin = new Cinema("HallA", Enums.CinemaType.REGULAR, 10, 10);
        
    //     if(!cin.getSeatOccupied('A', 1)) // Check if seat already assigned first
    //         cin.setSeatOccupied('A', 1); 

    //     if(!cin.getSeatOccupied('B', 10)) 
    //         cin.setSeatOccupied('B', 10);

    //     cin.printCinemaLayout();
    // }
}