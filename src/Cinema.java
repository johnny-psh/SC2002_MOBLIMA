public class Cinema{

    private String cinemaID; // 3 digit code
    private String cinemaName;
    private Enums.CinemaType cinemaType;
    private Seat[][] seats;
    private int numOfRows;
    private int numOfCols;

    public Cinema(String cinemaID, String cinemaName, Enums.CinemaType cinemaType){
        this.cinemaID = cinemaID;
        this.cinemaName = cinemaName;
        this.cinemaType = cinemaType;
        this.numOfRows = 10;
        this.numOfCols = 10;
        this.seats = new Seat[this.numOfRows][this.numOfCols];
        for(int i = 1; i <= this.numOfRows; i++){
            for(int j = 1; j <= this.numOfCols; j++){
                this.seats[i-1][j-1] = new Seat((char)(i+64), j);
            }
        }
    }

    public void printCinemaLayout(){
        int mid = this.numOfCols / 2;

        System.out.println("\nCinema " + this.cinemaID + "'s Seating Layout: \n");
        System.out.println("\t\t\t\t" + "Screen \n");
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
            System.out.println(" \t" + (char) (i+64)); //Row alphabet
        }
    }

    public String getCinemaID(){
        return this.cinemaID;
    }

    public String getCinemaName(){
        return this.cinemaName;
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

    public Seat getSeat(char row, int col){
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

}