package Model; 
/**
 * Represents the Seat for each cinema 
 * @author Group 6
 * @since 6/11/2022
 */
public class Seat{
    /**
     * Row of this Seat 
     */
    private char row;
    /**
     * Column of this Seat
     */
    private int col;
    /**
     * SeatID of this Seat 
     */
    private String seatID;
    /**
     * Boolean to indicate if this seat is occupied 
     */
    private boolean isOccupied;
    /**
     * Creates a seat at row and column in cinema 
     * @param row Row of this Seat
     * @param col Column of this Seat
     */
    public Seat(char row, int col){
        this.row = row;
        this.col = col;
        this.seatID = "" + this.row + this.col;
        this.isOccupied = false;
    }
    /**
     * Gets the row of this Seat 
     * @return Row of this Seat
     */
    public char getRow(){
        return this.row;
    }
    /**
     * Gets the column of this Seat 
     * @return Column of this Seat
     */
    public int getCol(){
        return this.col;
    }
    /**
     * Get seatID of this Seat
     * @return SeatID of this Seat
     */
    public String getSeatID(){
        return this.seatID;
    }
    /**
     * Checks if this Seat is occupied
     * @return Occupied boolean of this Seat
     */
    public boolean getIsOccupied() {
        return this.isOccupied;
    }
    /**
     * Set this Seat to be occupied
     * @param isOccupied This seat is occupied
     */
    public void setIsOccupied(boolean isOccupied){
        this.isOccupied = isOccupied;
    }
    
}