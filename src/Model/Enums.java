package Model;
/* Class for all ENUMS used in this project */
/**
 * Class for all ENUMS used in this project 
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class Enums {
    /**
     * ENUM of movie showing status
     */
    public enum ShowingStatus {
        COMING_SOON("Coming Soon"),
        PREVIEW("Preview"),
        NOW_SHOWING("Now Showing"), 
        END_OF_SHOWING("End of Showing");

        private String status;

        ShowingStatus(String status) {
            this.status = status;
        }
     
        public String toString(){
            return this.status;
        }
    };
    /**
     * ENUM of type of movie 
     */
    public enum TypeOfMovie {
        
        TWO_D("2D"), 
        THREE_D("3D"), 
        TWO_D_BLOCKBUSTER("2D Blockbuster"),
        THREE_D_BLOCKBUSTER("3D Blockbuster");

        private String type;

        TypeOfMovie(String type){
            this.type = type;
        }

        public String toString(){
            return this.type;
        }
    }
    /**
     * ENUM of movie rating 
     */
    public enum MovieRating { 
        G("G"),
        PG("PG"),
        PG13("PG13"),
        NC16("NC16"),
        M18("M18"),
        R21("R21");

        private String rating;

        MovieRating(String rating) {
        this.rating = rating;
        }

        public String toString() {
             return this.rating;
        }
    }
    /**
     * ENUM of cinema type 
     */
    public enum CinemaType {
        
        REGULAR("Regular"), 
        DOLBY_ATMOS("Dolby Atmos"), 
        PLATINUM_MOVIE_SUITES("Platinum Movie Suites");

        private String CinemaType;

        CinemaType(String CinemaType){
            this.CinemaType = CinemaType;
        }

        public String toString(){
            return this.CinemaType;
        }
    }
    /**
     * ENUM of day of the week 
     */
    public enum DayOfWeek {
        MON("Monday"),
        TUES("Tuesday"),
        WED("Wednesday"),
        THURS("Thursday"),
        FRI("Friday"),
        SAT("Saturday"),
        SUN("Sunday"),
        PUBLIC_HOL("Public Holiday");

        private String day;

        DayOfWeek(String day){
            this.day = day;
        }

        public String toString(){
            return this.day;
        }
    }
    /**
     * ENUM of type of movie goer
     */
    public enum TypeOfMovieGoer {
        STUDENT("Student"),
        ADULT("Adult"),
        SENIOR("Senior Citizen");
    
        private String movieGoer;

        TypeOfMovieGoer(String movieGoer) {
            this.movieGoer = movieGoer;
        }

        public String toString(){
            return this.movieGoer;
        }
    }
    /**
     * ENUM of ticket type 
     */
    public enum TicketType {
        SENIOR("Senior Citizen"),
        STUDENT("Student"),
        WEEKDAY("Weekday"),
        WEEKEND("Weekend"),
        HOL("Public Holiday");

        private String ticType;

        TicketType(String ticType) {
            this.ticType = ticType;
        }

        public String toString(){
            return this.ticType;
        }
    }
}
