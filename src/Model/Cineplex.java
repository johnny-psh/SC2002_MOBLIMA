package Model;
import java.util.ArrayList;
/**
 * Represents a Cineplex at a certain location containing multiple cinemas 
 * @author Group 6
 * @version 1.0
 * @since 6/11/2022
 */
public class Cineplex{
    /**
     * List of cinema in this Cineplex
     */
    private ArrayList<Cinema> cinemaList;
    /**
     * Name of this Cineplex
     */
    private String cineplexName;
    /**
     * Creates a new Cineplex with given name and list of cinema 
     * @param cineplexName Cineplex name
     */
    public Cineplex(String cineplexName, ArrayList<Cinema> cinemaList){
        this.cineplexName = cineplexName;
        this.cinemaList = cinemaList;
    }
    /**
     * Get name of this Cineplex
     * @return Cineplex name
     */
    public String getCineplexeName(){
        return this.cineplexName;
    }
    /**
     * Add a new cinema into this Cineplex
     * @param cinema New cinema 
     */
    public void addCinema(Cinema cinema){
        cinemaList.add(cinema);
    }
    /**
     * Display all cinema in this Cineplex
     */
    public ArrayList<Cinema> getCinemaList(){
        return this.cinemaList;
    }
}
