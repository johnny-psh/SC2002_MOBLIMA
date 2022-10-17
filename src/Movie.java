import java.util.*;
import java.util.ArrayList;

public class Movie {

    /*
        This Movie Class is for:
        1) Cinema Staff to Create(new Movie object) / Update(set) / Remove(set Showing status to ENDOFSHOWING) movies
        2) Movie-goer user class to access(get) movie properties
        3) Ticket class to access(get) movie properties
     */


    // ENUMS - should these be in their own class?
    public enum ShowingStatus {
        COMING_SOON("Coming Soon"),
        PREVIEW("Preview"),
        NOW_SHOWING("Now Showing"), 
        END_OF_SHOWING("End of Showing");

        private String status;

        ShowingStatus(String status) {
            this.status = status;
        }
     
        @overwrite
        public String toString(){
            return this.status;
        }
    };

    public enum TypeOfMovie {
        2D("2D"), 
        3D("3D"), 
        BLOCKBUSTER("Blockbuster");

        private String type;

        TypeOfMovie(String type){
            this.type = type;
        }

        @overwrite
        public String toString(){
            return this.type;
        }
    }

    public enum MovieRating { 
        G("G"),
        PG("PG"),
        PG13("PG13"),
        NC16("NC16"),
        M18("M18"),
        R21("R21");

        private String rating;

        ContentRating(String rating) {
        this.rating = rating;
        }

        @overwrite
        public String toString() {
             return this.rating;
        }
    }

    // Properties
    private String title, sypnosis, director;
    private ShowingStatus showingStatus;
    private TypeOfMovie type; // Type of movie (3D, Blockbuster etc.) - This is also called by ticket class 
    private MovieRating movieRating; // Rating of movie - (PG, M18 etc.)
    private ArrayList<String> castList;

    // STILL UNSURE - should rating & reviews be in a new class??
    private int overallReviewerRating; // Viewed by moviegoer
    private ArrayList<String> pastReviews; // Viewed by moviegoer
    private ArrayList<int> pastRatings; // Viewed by moviegoer

    // Constructor - Used by <cinema staff> to create a new movie object
    public Movie(String title){
        this.title = title;
    }

    // Note: get classes are called by movieGoer class , 
    public String getTitle(){
        return this.title
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDirector(){
        return this.director;
    }
    
    public void setDirector(String director){
        this.director = director;
    }

    public String getSypnosis(){
        return this.sypnosis;
    }

    public void setSypnosis(String sypnosis){
        this.sypnosis = sypnosis;
    }

    public ShowingStatus getShowingStatus(){
        return this.showingStatus;
    }

    public void setShowingStatus(ShowingStatus showingStatus){
        this.showingStatus = showingStatus;
    }

    public TypeOfMovie getType(){
        return this.type;
    }

    public void setType(TypeOfMovie type){
        this.type = type;
    }

    // This is also called by ticket class
    public void printType(){
        System.out.println(this.type);
    }

    public MovieRating getMovieRating(){
        return this.movieRating;
    }

    public void setMovieRating(MovieRating movieRating) {
        this.movieRating = movieRating;
    } 

    public String[] getCast(){
        return this.cast;
    }

    public void addCast(String castName){
        this.cast.add(castName);
    }

    public void printCast(){
        if(this.cast.size() > 0)
            System.out.println(Arrays.toString(this.cast));
        else
            System.out.println(this.title + " has no cast list.");
    }

    // Reviewer Rating

    // Past Reviews

    // Past Ratings
}