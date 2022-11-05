import java.util.ArrayList;
import java.util.Date;  

public class ShowtimeList {
    
    private ArrayList<Showtime> showtimeList;

    public ShowtimeList(){
        showtimeList = new ArrayList<Showtime>();
    }

    public void addShowtime(Showtime showtime){
        this.showtimeList.add(showtime);
    }

    public void removeShowtime(int index){
        this.showtimeList.remove(index);
    }

    public Showtime findShowtime(int index){
        return this.showtimeList.get(index);
    };

    public ArrayList<Showtime> getShowtimeListByCineplex(Cineplex cineplex){
        ArrayList<Showtime> showtimeListByCineplex = new ArrayList<Showtime>();
        for(int i=0; i < this.showtimeList.size(); i++){
            Showtime curShowtime = this.showtimeList.get(i);
            if(curShowtime.getCineplex() == cineplex)
                showtimeListByCineplex.add(curShowtime);
        }
        return showtimeListByCineplex;
    };

    public static ArrayList<Showtime> getShowtimeListByDate(ArrayList<Showtime> showtimeListByCineplex, Date date){
        ArrayList<Showtime> showtimeListByDate = new ArrayList<Showtime>();
        for(int i=0; i < showtimeListByCineplex.size(); i++){
            Showtime curShowtime = showtimeListByCineplex.get(i);
            if(curShowtime.getDate() == date)
                showtimeListByDate.add(curShowtime);
        }
        return showtimeListByDate;
    };

}
