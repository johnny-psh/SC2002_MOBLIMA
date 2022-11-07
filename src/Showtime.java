import java.util.Date;  
import java.text.SimpleDateFormat;
import java.text.Format;  

public class Showtime {
    private Movie movie;
    private Cineplex cineplex;
    private Cinema cinema;
    private Date date, time;
    private Enums.DayOfWeek dayOfWeek;
    private boolean timeBeforeSix;

    
    public Showtime(Movie movie, Cineplex cineplex, Cinema cinema, Date date, Date time){
        this.movie = movie;
        this.cineplex = cineplex;
        this.cinema = cinema;
        this.date = date;
        this.time = time;
        Format dayFormatter = new SimpleDateFormat("EEEE");  
        String dayOfWeekString = dayFormatter.format(this.date);  
        switch(dayOfWeekString){
            case "Monday":
                this.dayOfWeek = Enums.DayOfWeek.MON;
                break;
            case "Tuesday":
                this.dayOfWeek = Enums.DayOfWeek.TUES;
                break;
            case "Wednesday":
                this.dayOfWeek = Enums.DayOfWeek.WED;
                break;
            case "Thursday":
                this.dayOfWeek = Enums.DayOfWeek.THURS;
                break;
            case "Friday":
                this.dayOfWeek = Enums.DayOfWeek.FRI;
                break;
            case "Saturday":
                this.dayOfWeek = Enums.DayOfWeek.SAT;
                break;
            case "Sunday":
            default:
                this.dayOfWeek = Enums.DayOfWeek.SUN;
                break;
        }
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh");
        String timeString = timeFormatter.format(this.time);
        int timeInt =  Integer.parseInt(timeString);
        if(timeInt < 18)
            this.timeBeforeSix = true;

    }

    public Movie getMovie(){
        return this.movie;
    }

    public Cineplex getCineplex(){
        return this.cineplex;
    }

    public Cinema getCinema(){
        return this.cinema;
    }

    public Date getDate(){
        return this.date;
    }

    public Date getTime(){
        return this.time;
    }

    public Enums.DayOfWeek getDayOfWeek(){
        return this.dayOfWeek;
    }

    public void setHoliday(){
        this.dayOfWeek = Enums.DayOfWeek.PUBLIC_HOL;
    }

    public boolean isTimeBeforeSize(){
        return this.timeBeforeSix;
    }

    public String getFormattedDate(){
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("dd/MM/yyyy");
        return (dateTimeFormatter.format(this.date));  
    }

    public String getFormattedTime(){
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("HH:mm");
        return (dateTimeFormatter.format(this.time));
    }

    public void printShowtime(){
        System.out.println(
        this.getFormattedDate() 
        + " - " +  this.getFormattedTime()
        + " - " + this.getCinema().getCinemaID() 
        + " - " + this.getCinema().getCinemaType().toString() 
        + " - " + this.getMovie().getTitle()); 
    }

}
