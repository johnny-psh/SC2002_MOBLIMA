import java.util.*;
import java.util.ArrayList;
import java.io.*;

//Test Read Txt File


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
     
        public String toString(){
            return this.status;
        }
    };

    public enum TypeOfMovie {
        
        twoD("2D"), 
        threeD("3D"), 
        BLOCKBUSTER("Blockbuster");

        private String type;

        TypeOfMovie(String type){
            this.type = type;
        }

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

        MovieRating(String rating) {
        this.rating = rating;
        }

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

    private int overallReviewerRating; // Viewed by moviegoer
    private ArrayList<Review> movieReviewList;

    // Constructor - Used by <cinema staff> to create a new movie object
    public Movie(String title){
        this.title = title;
        this.castList = new ArrayList<String>();
        this.movieReviewList = new ArrayList<Review>();
    }

    // Note: get classes are called by movieGoer class , 
    public String getTitle(){
        return this.title;
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

    public ArrayList<String> getCast(){
        return this.castList;
    }

    public void addCast(String castName){
        this.castList.add(castName);
    }

    public void printCast(){

        for(String str : castList)
        {
            System.out.println(str);
        }
    }

    // OVERALL Reviewer Rating
    public int getOverallReviewerRating(){
        
        return this.overallReviewerRating;
    }

    // Private Helper method to calculate overall reviewer rating
    private void updateOverallReviewerRating(int newReviewerRating){
        int numOfRatings = movieReviewList.size();
        int totalRatings = (overallReviewerRating * (numOfRatings - 1))  + newReviewerRating;
        
        this.overallReviewerRating = totalRatings / numOfRatings;
    }

    // REVIEWS - CALLED BY MOVIE GOER USER CLASS
    // Add review
    public void addReview(int rating, String review){
        Review newReview = new Review(review, rating);
        movieReviewList.add(newReview);
        updateOverallReviewerRating(rating);
    }

    // Print Past Reviews
    public void printPastReviews(){
        for(int i=0; i < this.movieReviewList.size(); i++){
            System.out.println("Rating: " + this.movieReviewList.get(i).getRating());
            System.out.println("Review: " + this.movieReviewList.get(i).getDescription());
        }
    }

    
//Temporary Txt File Reader 
    public static void main(String[] args) throws IOException {        
       


 BufferedReader br = null;
    String[] characters = new String[1024];//just an example - you have to initialize it to be big enough to hold all the lines!

    try {

        String sCurrentLine;
        br = new BufferedReader(new FileReader("C:/Users/User/Desktop/SC2002_Assignment/src/database/testData.txt"));

        int i=0;
        while ((sCurrentLine = br.readLine()) != null) {
            String[] arr = sCurrentLine.split(" ");
            //for the first line it'll print
            System.out.println("arr[0] = " + arr[0]); // h
            System.out.println("arr[1] = " + arr[1]); // Vito
            System.out.println("arr[2] = " + arr[2]); // 123
            if(arr.length == 4){
                System.out.println("arr[3] = " + arr[3]);
            }

            //Now if you want to enter them into separate arrays
            characters[i] = arr[0];
            // and you can do the same with
            // names[1] = arr[1]
            //etc
            i++;
        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (br != null)br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 
    }
}