public class Seat{

    private char row;
    private int col;
    private String seatID;
    private boolean isOccupied;

    public Seat(char row, int col){
        this.row = row;
        this.col = col;
        this.seatID = "" + this.row + this.col;
        this.isOccupied = false;
    }

    public char getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }

    public String getSeatID(){
        return this.seatID;
    }

    public boolean getIsOccupied() {
        return this.isOccupied;
    }

    public void setIsOccupied(boolean isOccupied){
        this.isOccupied = isOccupied;
    }
    
}