package Model;
import java.util.ArrayList;

public class Cineplex{
    private ArrayList<Cinema> cinemaList;
    private String cineplexName;

    public Cineplex(String cineplexName, ArrayList<Cinema> cinemaList){
        this.cineplexName = cineplexName;
        this.cinemaList = cinemaList;
    }

    public String getCineplexeName(){
        return this.cineplexName;
    }

    public void addCinema(Cinema cinema){
        cinemaList.add(cinema);
    }

    public ArrayList<Cinema> getCinemaList(){
        return this.cinemaList;
    }
}
