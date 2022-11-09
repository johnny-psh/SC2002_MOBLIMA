import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.Format;  

public class TicketManager {
    private Ticket ticket;
    private Enums.DayOfWeek dayOfWeek;
    private boolean timeBeforeSix;
    private Enums.TicketType ticketType;
    
    public TicketManager(Ticket ticket){
        this.ticket = ticket;
        
        // Check what day it is
        this.dayOfWeek = this.calcDayOfWeek();

        // Check if movie showing before 6pm
        this.timeBeforeSix = this.isTimeBeforeSix();

        // Get TicketType
        this.ticketType = calcTicketType();

    }

    public Ticket getTicket(){
        return this.ticket;
    }

    public boolean getIsTimeBeforeSix(){
        return this.timeBeforeSix;
    }

    public Enums.DayOfWeek getDayOfWeek(){
        return this.dayOfWeek;
    }

    public Enums.TicketType getTicketType(){
        return this.ticketType;
    }

    private Enums.TicketType calcTicketType(){
        if(this.dayOfWeek == Enums.DayOfWeek.SAT || this.dayOfWeek == Enums.DayOfWeek.SUN)
            return Enums.TicketType.WEEKEND;

        // Students & Seniors on weekdays before 6pm
        else if(this.timeBeforeSix){
            if(this.ticket.getMovierGoerType() == Enums.TypeOfMovieGoer.SENIOR)
                return Enums.TicketType.SENIOR;
            else if(this.ticket.getMovierGoerType()  == Enums.TypeOfMovieGoer.STUDENT)
                return Enums.TicketType.STUDENT;
        }
        
        // Adults or all movie goer types after 6pm on weekday
        return Enums.TicketType.WEEKDAY;
    }

    private boolean isHoliday(){        
        ArrayList<Date> holidayList = HolidaysController.readHolidays();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("ddMMyyyy");
        for(Date holiday : holidayList){
            if ((dateFormatter.format(this.ticket.getDate())).equals(dateFormatter.format(holiday)))
                return true;
        }
        return false;
    }

    private Enums.DayOfWeek calcDayOfWeek(){
        // If holiday
        if(this.isHoliday()) this.dayOfWeek = Enums.DayOfWeek.PUBLIC_HOL;

        Format dayFormatter = new SimpleDateFormat("EEEE");  
        String dayOfWeekString = dayFormatter.format(this.ticket.getDate());  
        switch(dayOfWeekString){
            case "Monday":
                return Enums.DayOfWeek.MON;
            case "Tuesday":
                return Enums.DayOfWeek.TUES;
            case "Wednesday":
                return Enums.DayOfWeek.WED;
            case "Thursday":
                return Enums.DayOfWeek.THURS;
            case "Friday":
                return Enums.DayOfWeek.FRI;
            case "Saturday":
                return Enums.DayOfWeek.SAT;
            case "Sunday":
                return Enums.DayOfWeek.SUN;
            default:
                return null;
        }
    }

    private boolean isTimeBeforeSix(){
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh");
        String timeString = timeFormatter.format(this.ticket.getTime());
        int timeInt =  Integer.parseInt(timeString);
        if(timeInt < 18)
             return true;
        return false;
    }

}
