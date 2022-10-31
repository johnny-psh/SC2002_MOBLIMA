import java.util.ArrayList;

public class Cineplex{
    private ArrayList<Cinema> cinemaList;
    private String cineplexName;

    public Cineplex(String cineplexName){
        this.cineplexName = cineplexName;
        this.cinemaList = new ArrayList<Cinema>();
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
}