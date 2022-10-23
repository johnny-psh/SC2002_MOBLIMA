/* Not sure if needed
This class is for returning the ticket type depending on age/time/day */

public class TicketType {
    private Enums.DayOfWeek dayOfWeek;
    private Enums.TypeOfMovieGoer movieGoerType;
    private boolean timeBeforeSix;

    private Enums.TicketType ticketType;

    public TicketType(Enums.DayOfWeek dayOfWeek, Enums.TypeOfMovieGoer movieGoerType, boolean timeBeforeSix){
        this.dayOfWeek = dayOfWeek;
        this.movieGoerType = movieGoerType;
        this.timeBeforeSix = timeBeforeSix;
        
        this.ticketType = calcTicketType();
    }

    public Enums.TicketType getTicketType(){
        return this.ticketType;
    }

    private Enums.TicketType calcTicketType(){

        boolean isWeekendOrPublicHol = this.dayOfWeek != Enums.DayOfWeek.SAT && this.dayOfWeek != Enums.DayOfWeek.SUN && this.dayOfWeek != Enums.DayOfWeek.PUBLIC_HOL;
        
        // Students & Seniors on weekdays before 6pm
        if(timeBeforeSix && !isWeekendOrPublicHol){
            if(this.movieGoerType == Enums.TypeOfMovieGoer.SENIOR)
                return Enums.TicketType.SENIOR;
            else if(this.movieGoerType == Enums.TypeOfMovieGoer.STUDENT)
                return Enums.TicketType.STUDENT;
        }

        // Non senior/student price Mon-Fri
        switch(this.dayOfWeek){
            case MON:
            case TUES:
            case WED:
                return Enums.TicketType.MON_TO_WED;
            case THURS:
                return Enums.TicketType.THU;
            case FRI:
                return timeBeforeSix ? Enums.TicketType.FRI_BEFORE_SIX : Enums.TicketType.FRI_FROM_SIX;
            
            // Weekends & Public Hol
            case SAT:
            case SUN:
            case PUBLIC_HOL:
            default:
                return Enums.TicketType.WEEKEND_AND_PUBLICHOL;       
        }
    }
    
}
