package Controller;
import java.util.Date;

import Model.Enums;
import Model.Ticket;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.Format;  

/**
 * Class to manage tickets of movie 
 * @author Group 6 
 * @version 1.0
 * @since 12/11/2022
 */
public class TicketManager {
    /**
     * Ticket variable 
     */
    private Ticket ticket;
    /**
     * Day of the week 
     */
    private Enums.DayOfWeek dayOfWeek;
    /**
     * Boolean to check time of the day is before 6pm
     */
    private boolean timeBeforeSix;
    /**
     * Type of ticket 
     */
    private Enums.TicketType ticketType;
    /**
     * Creates new ticket 
     * @param ticket Ticket of movie 
     */
    public TicketManager(Ticket ticket){
        this.ticket = ticket;
        
        // Check what day it is
        this.dayOfWeek = this.calcDayOfWeek();

        // Check if movie showing before 6pm
        this.timeBeforeSix = this.isTimeBeforeSix();

        // Get TicketType
        this.ticketType = calcTicketType();

    }
    /**
     * Get the ticket of movie
     * @return Ticket of movie 
     */
    public Ticket getTicket(){
        return this.ticket;
    }
    /**
     * Checks if the time is before 6pm
     * @return Boolean to determine time
     */
    public boolean getIsTimeBeforeSix(){
        return this.timeBeforeSix;
    }
    /**
     * Get the day of the week
     * @return Day of the week
     */
    public Enums.DayOfWeek getDayOfWeek(){
        return this.dayOfWeek;
    }
    /**
     * Get ticket type 
     * @return Ticket type 
     */
    public Enums.TicketType getTicketType(){
        return this.ticketType;
    }
    /**
     * Determines the type of ticket base on day and moviegoer
     * @return Ticket type 
     */
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
    /**
     * Method to check if date chosen is a holiday
     * @return Boolean true or false
     */
    private boolean isHoliday(){        
        ArrayList<Date> holidayList = HolidaysController.read();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("ddMMyyyy");
        for(Date holiday : holidayList){
            if ((dateFormatter.format(this.ticket.getDate())).equals(dateFormatter.format(holiday)))
                return true;
        }
        return false;
    }
    /**
     * Method to determin the day of the week 
     * @return Day of the week 
     */
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
    /**
     * Method to check if time chosen is before 6pm 
     * @return Boolean true or false
     */
    private boolean isTimeBeforeSix(){
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh");
        String timeString = timeFormatter.format(this.ticket.getTime());
        int timeInt =  Integer.parseInt(timeString);
        if(timeInt < 18)
             return true;
        return false;
    }

}
