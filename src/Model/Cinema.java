package Model;
/**
 * Represents the cinema class
 * @author Group 6
 * @version 1.0
 * @since 12/112022
 */
public class Cinema{
    /**
     * Cinema ID
     */
    private String cinemaID; // 3 digit code
    /**
     * Cinema name 
     */
    private String cinemaName;
    /**
     * Cinema type 
     */
    private Enums.CinemaType cinemaType;
    /**
     * Seats in the cinema 
     */
    private Seat[][] seats;
    /**
     * Number of rows 
     */
    private int numOfRows;
    /**
     * Number of columns 
     */
    private int numOfCols;
    /**
     * Creates a new cinema 
     * @param cinemaID Cinema ID
     * @param cinemaName Cinema name
     * @param cinemaType Cinema type 
     */
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
    /**
     * Display layout of cinema 
     */
    public void printCinemaLayout(){
        int mid = this.numOfCols / 2;

        System.out.println("\n" + this.cinemaType.toString() + " Cinema " + this.cinemaID + " seating Layout: \n");
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
    /**
     * Get ID of this Cinema 
     * @return ID of this Cinema
     */
    public String getCinemaID(){
        return this.cinemaID;
    }
    /**
     * Get name of this Cinema 
     * @return Name of this Cinema 
     */
    public String getCinemaName(){
        return this.cinemaName;
    }
    /**
     * Get type of this Cinema 
     * @return Type of this Cinema 
     */
    public Enums.CinemaType getCinemaType(){
        return this.cinemaType;
    }
    /**
     * Get number of rows of this Cinema 
     * @return Number of rows 
     */
    public int getNumOfRows(){
        return this.numOfRows;
    }
    /**
     * Get number of colums of this Cinema 
     * @return Number of colums 
     */
    public int getNumOfCols(){
        return this.numOfCols;
    }
    /**
     * Get seat using character row  
     * @param row Row in character
     * @param col Column 
     * @return Seat 
     */
    public Seat getSeat(char row, int col){
        int rowNum = row - 'A';
        int colNum = col-1;
        if(rowNum < this.numOfRows && colNum < this.numOfCols)
            return this.seats[rowNum][colNum];
        return null;
    }
    /**
     * Get seat integer row
     * @param row Row in integer
     * @param col Column
     * @return Seat
     */
    public Seat getSeat(int row, int col){
        if(row < this.numOfRows && col < this.numOfCols)
            return this.seats[row][col];
        return null;
    }
    /**
     * Get seat method
     * @return Seat 
     */
    public Seat[][] getSeats(){
        return this.seats;
    }
    /**
     * Method to set seats 
     * @param seats Seats 
     */
    public void setSeats(Seat[][] seats){
        this.seats = seats;
    }
    
    // Method to set a certain seat as occupied in Cinema
    /**
     * Set seat to be occupied 
     * @param row Row of seat
     * @param col Column of seat 
     */
    public void setSeatOccupied(char row, int col){
        this.getSeat(row, col).setIsOccupied(true);
    } 
    /**
     * Get occupied seat 
     * @param row Row of seat 
     * @param col Column of seat
     * @return Occupied seat
     */
    public boolean getSeatOccupied(char row, int col){
        return this.getSeat(row, col).getIsOccupied();
    }

}