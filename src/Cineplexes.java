public class Cineplexes{
    private Cinema cinemaList[];
    private String CineplexeName;
    private String location;

    public Cineplexes(int numOfCinema, String CineplexeName, String location){
        this.cinemaList = new Cinema[numOfCinema];
        this.CineplexeName = CineplexeName;
        this.location = location;

        Cinema newCinema = new Cinema();

        for(int i = 0; i < numOfCinema; i++){
            cinemaList[i] = newCinema;
        }
        
    }

    public String getCineplexeName(){
        return CineplexeName;
    }

    public String getLocation(){
        return location;
    }

    public void setCineplexeName(String CineplexeName){
        this.CineplexeName = CineplexeName;
    }

    public void setLocation(String location){
        this.location = location;
    }


    
}