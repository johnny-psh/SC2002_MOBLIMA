public class Seat{

    private int seatID;
    private boolean isOccupied;

    public Seat(int seatID){
        this.seatID = seatID;
        isOccupied = false;
    }

    public int getSeatID(){
        return seatID;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public void setSeatID(int seatID){
        this.seatID = seatID;
    }

    public void setIsOccupied(boolean isOccupied){
        this.isOccupied = isOccupied;
    }
    
}