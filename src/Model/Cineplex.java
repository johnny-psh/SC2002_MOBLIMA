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

    public void printCinemaList(){
        for(Cinema cin : this.cinemaList)
            System.out.println(cin.getCinemaID());
    }

    public Cinema getCinemaByID(String cinemaID){
        for (int i=0; i < this.cinemaList.size(); i++){
            Cinema cinema = this.cinemaList.get(i);
            if (cinema.getCinemaID().equals(cinemaID))
                return cinema;
        }
        return null;
    }
}
