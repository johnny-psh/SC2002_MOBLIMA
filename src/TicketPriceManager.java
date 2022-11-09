import java.util.ArrayList;
 
public class TicketPriceManager {
    
    private final double REGULAR_MULTIPLIER = 1;
    private final double DOLBY_MULTIPLIER = 1.5;
    private final double PLATINUM_MULTIPLIER = 2;

    private final double STUDENT_DISCOUNT = 0.2; // 20% discount for students - applicable only weekday before 6pm
    private final double SENIOR_DISCOUNT = 0.5; // 50% discount for seniors - applicable only weekday before 6pm

    private final double WEEKDAY_MULTIPLIER = 1;
    private final double WEEKEND_MULTIPLIER = 1.2;
    private final double HOL_MULTIPLIER = 1.5;

    private TicketManager ticketManager;
    private Enums.TicketType ticketType;
    private double ticketPrice;

    // Constructor
    public TicketPriceManager(TicketManager ticketManager){
        this.ticketManager = ticketManager;
        this.ticketType = ticketManager.getTicketType();
        this.ticketPrice = this.calcTicketPrice();
    }

    public double getTicketPrice(){
        return this.ticketPrice;
    }


    /* Helper class for calculating ticket price based on:
        1) Movie type (2D, 3D, Blockbuster)
        2) Cinema type (Regular, Dolby Atmos, Platinum Movie Suites)
        3) Ticket type - depends on:
            a) Type of movie-goer (Student, Adult, Senior) - Applicable for weekdays < 6pm
            b) Day of week (Weekday or Weekend or Public Hol)
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
