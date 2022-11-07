public class Ticket{

    private Seat seat;
    private Showtime showtime;
    private Enums.TypeOfMovieGoer movieGoerType;

    private Enums.TypeOfMovie movieType; // Charged $1 extra for blockbuster
    private Enums.CinemaType cinemaType; 
    private Enums.TicketType ticketType;
    private Enums.DayOfWeek dayOfWeek;
    private boolean timeBeforeSix;

    private double ticketPrice;
    
    public Ticket(Seat seat, Showtime showtime, Enums.TypeOfMovieGoer movieGoerType){
        this.seat = seat;
        this.showtime = showtime;
        this.movieGoerType = movieGoerType;
        this.movieType = this.showtime.getMovie().getType();
        this.cinemaType = this.showtime.getCinema().getCinemaType();
        this.dayOfWeek = showtime.getDayOfWeek();
        this.timeBeforeSix = this.showtime.isTimeBeforeSize();
        this.ticketType = this.calcTicketType();
        this.ticketPrice = calcTicketPrice();
    }

    public Seat getSeat(){
        return this.seat;
    }

    public Enums.TypeOfMovie getMovieType(){
        return this.movieType;
    }

    public Enums.CinemaType getCinemaType(){
        return this.cinemaType;
    }

    public Enums.TicketType getTicketType(){
        return this.ticketType;
    }

    public double getTicketPrice(){
        return this.ticketPrice;
    }

    /* Helper class for calculating ticket price based on:
        1) Movie type (2D, 3D, Blockbuster)
        2) Cinema type (Regular, Dolby Atmos, Platinum Movie Suites)
        3) Ticket type - depends on:
            a) Age/Type of movie-goer (Student, Adult, Senior)
            b) Day of week (Mon-Sun or Public Hol)
            c) Time (Before 6pm / After 6pm)
    */
    private double calcTicketPrice(){

        double price = 0.0;

        // If movie type is "BLOCKBUSTER", extra $1 is charged regardless of cinemaType
        if(this.movieType == Enums.TypeOfMovie.TWO_D_BLOCKBUSTER || this.movieType == Enums.TypeOfMovie.THREE_D_BLOCKBUSTER)
            price += 1.00;

        if(this.cinemaType == Enums.CinemaType.REGULAR){           
            // Regular 2D
            if(this.movieType == Enums.TypeOfMovie.TWO_D || this.movieType == Enums.TypeOfMovie.TWO_D_BLOCKBUSTER){
                switch(this.ticketType){
                    case SENIOR:
                        return (price += 4.00);
                    case STUDENT:
                        return (price += 7.00);
                    case MON_TO_WED:
                        return (price += 8.50);
                    case THU:
                    case FRI_BEFORE_SIX:
                        return (price += 9.50);
                    case FRI_FROM_SIX:
                    case WEEKEND_AND_PUBLICHOL:
                    default:
                        return (price += 11.00);
                }
            }
            // Regular 3D
            else{
                switch(this.ticketType){
                    case SENIOR:
                    case STUDENT:
                        return (price += 9.00);
                    case MON_TO_WED:
                    case THU:
                        return (price += 11.0);
                    case FRI_BEFORE_SIX:
                    case FRI_FROM_SIX:
                    case WEEKEND_AND_PUBLICHOL:
                    default:
                        return (price += 15.00);
                }
            }           
        }

        else if(this.cinemaType == Enums.CinemaType.DOLBY_ATMOS){   
            // Dolby 2D       
            if(this.movieType == Enums.TypeOfMovie.TWO_D || this.movieType == Enums.TypeOfMovie.TWO_D_BLOCKBUSTER){
                return (price += 14.00);
            }
            // Dolby 3D
            else if(this.movieType == Enums.TypeOfMovie.THREE_D  || this.movieType == Enums.TypeOfMovie.THREE_D_BLOCKBUSTER){
                return (price += 16.00);          
            }
        }

        // PLATINUM MOVIE SUITES - 2D/3D
        else if(this.cinemaType == Enums.CinemaType.PLATINUM_MOVIE_SUITES){
            switch(this.ticketType){
                case SENIOR:
                case STUDENT:
                case MON_TO_WED:
                case THU:
                    return (price += 28.00);
                case FRI_BEFORE_SIX:
                case FRI_FROM_SIX:
                case WEEKEND_AND_PUBLICHOL:
                default:
                    return (price += 38.00);
            }
        }
        
        
        return 0;        
        
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