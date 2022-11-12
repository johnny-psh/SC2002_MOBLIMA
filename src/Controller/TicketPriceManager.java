package Controller;
import java.util.ArrayList;

import Model.Enums;
/**
 * Class to manage ticket price 
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class TicketPriceManager {
    /**
     * Multiplier for regular cinema 
     */
    private final double REGULAR_MULTIPLIER = 1;
    /**
     * Multiplier for dolby cinema 
     */
    private final double DOLBY_MULTIPLIER = 1.5;
    /**
     * Multiplier for platinum cinema 
     */
    private final double PLATINUM_MULTIPLIER = 2;
    /**
     * Amount of student discount, applicable only weekdays before 6pm
     */
    private final double STUDENT_DISCOUNT = 0.2; // 20% discount for students - applicable only weekday before 6pm
    /**
     * Amount of senior discount, applicable only weekdays before 6pm
     */
    private final double SENIOR_DISCOUNT = 0.5; // 50% discount for seniors - applicable only weekday before 6pm
    /**
     * Multiplier for weekday tickets
     */
    private final double WEEKDAY_MULTIPLIER = 1;
    /**
     * Multiplier for weekend tickets
     */
    private final double WEEKEND_MULTIPLIER = 1.2;
    /**
     * Multiplier for holiday ticket 
     */
    private final double HOL_MULTIPLIER = 1.5;
    /**
     * Ticket manager variable
     */
    private TicketManager ticketManager;
    /**
     * Ticket type 
     */
    private Enums.TicketType ticketType;
    /**
     * Ticket price 
     */
    private double ticketPrice;

    // Constructor
    /**
     * Creates new ticket manager
     * @param ticketManager Ticket manager class
     */
    public TicketPriceManager(TicketManager ticketManager){
        this.ticketManager = ticketManager;
        this.ticketType = ticketManager.getTicketType();
        this.ticketPrice = this.calcTicketPrice();
    }
    /**
     * Get the ticket price
     * @return Ticket price
     */
    public double getTicketPrice(){
        return this.ticketPrice;
    }


    /**
     * Calculating movie tickets based on: 
     * 1) Movie type (2D, 3D, Blockbuster)
     * 2) Cinema type (Regular, Dolby Atmos, Platinum Movie Suites)
     * 3) Ticket type - depends on:
            a) Type of movie-goer (Student, Adult, Senior) - Applicable for weekdays < 6pm
            b) Day of week (Weekday or Weekend or Public Hol)
     * @return Price of ticket 
     */
    private double calcTicketPrice(){

        double price = 0.0;

        ArrayList<Double> pricesList = TicketPriceController.readTicketPrices();

        // Price based on movie type
        switch(this.ticketManager.getTicket().getMovieType()){
            case TWO_D:
                price += pricesList.get(0);
                break;
            case THREE_D:
                price += pricesList.get(1);
                break;
            case TWO_D_BLOCKBUSTER:
                price += pricesList.get(2);
                break;
            case THREE_D_BLOCKBUSTER:
                price += pricesList.get(3);
                break;
        }

        // Price multiplier based on cinema type
        switch(this.ticketManager.getTicket().getCinemaType()){
            case REGULAR:
                price *= REGULAR_MULTIPLIER;
                break;
            case DOLBY_ATMOS:
                price *= DOLBY_MULTIPLIER;
                break;
            case PLATINUM_MOVIE_SUITES:
                price *= PLATINUM_MULTIPLIER;
                break;
        }

        // Price multiplier based on ticket type - Student/senior/weekend/weekday/Hol
        switch(this.ticketType){
            case HOL:
                price *= HOL_MULTIPLIER;
                break;
            case WEEKEND:
                price *= WEEKEND_MULTIPLIER;
                break;
            case SENIOR:
                price *= SENIOR_DISCOUNT;
                break;
            case STUDENT:
                price *= STUDENT_DISCOUNT;
                break;
            default:
                price *= WEEKDAY_MULTIPLIER;
                break;
        }

        return price;
    }

}
