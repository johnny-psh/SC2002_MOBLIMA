package Model;
import java.util.ArrayList;
/**
 * This Movie Class is for:
        1) Cinema Staff to Create(new Movie object) / Update(set) / Remove(set Showing status to ENDOFSHOWING) movies
        2) Movie-goer user class to access(get) movie properties
        3) Ticket class to access(get) movie properties
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class Movie {
    /**
     * Movie ID of this Movie 
     */
    private String movieID; 
    /**
     * Title of this Movie 
     */
    private String title;
    /**
     * Sypnosis of this Movie 
     */
    private String sypnosis;
    /**
     * Director of this Movie 
     */
    private String director;
    /**
     * ENUMS of showing status 
     */
    private Enums.ShowingStatus showingStatus;
    /**
     * ENUMS type of movie 
     */
    private Enums.TypeOfMovie type; // Type of movie (3D, Blockbuster etc.) - This is also called by ticket class 
    /**
     * ENUMS movie rating 
     */
    private Enums.MovieRating movieRating; // Rating of movie - (PG, M18 etc.)
    /**
     * Cast list for this Movie 
     */
    private ArrayList<String> castList;
    /**
     * List of movie review for this Movie 
     */
    private ArrayList<Review> movieReviewList;
    /**
     * Number of ticket sales for this Movie 
     */
    private int ticketSales;
    /**
     * Overall revewer rating for this Movie 
     */
    private double overallReviewerRating;

    // Constructor - Used by <cinema staff> to create a new movie object
    /**
     * Creates a new Movie 
     * @param movieID Movie ID
     * @param title Movie title 
     */
    public Movie(String movieID, String title){
        this.movieID = movieID;
        this.title = title;
        this.castList = new ArrayList<String>();
        this.movieReviewList = new ArrayList<Review>();
        this.ticketSales = 0;
        this.overallReviewerRating = -1;
    }
    /**
     * Get movie ID of this Movie 
     * @return Movie ID
     */
    public String getMovieID()
    {
        return this.movieID;
    }
    /**
     * Get movie title for this Movie 
     * @return Movie title 
     */
    public String getTitle(){
        return this.title;
    }
    /**
     * Set movie title 
     * @param title Movie title 
     */
    public void setTitle(String title){
        this.title = title;
    }
    /**
     * Get director of this Movie 
     * @return Movie director 
     */
    public String getDirector(){
        if(this.director == null)
            return "NA";
        return this.director;
    }
    /**
     * Set director of this Movie 
     * @param director Movie Director 
     */
    public void setDirector(String director){
        this.director = director;
    }
    /**
     * Get sypnosis of this Movie 
     * @return Movie sypnosis 
     */
    public String getSypnosis(){
        if(this.sypnosis == null)
            return "NA";
        return this.sypnosis;
    }
    /**
     * Set sypnosis for this Movie 
     * @param sypnosis Movie Sypnosis 
     */
    public void setSypnosis(String sypnosis){
        this.sypnosis = sypnosis;
    }
    /**
     * Get showing status of this Movie 
     * @return Movie showing status
     */
    public Enums.ShowingStatus getShowingStatus(){
        return this.showingStatus;
    }
    /**
     * Set showing status of this Movie 
     * @param showingStatus Movie showing status
     */
    public void setShowingStatus(Enums.ShowingStatus showingStatus){
        this.showingStatus = showingStatus;
    }
    /**
     * Get type of Movie 
     * @return Movie type 
     */
    public Enums.TypeOfMovie getType(){
        return this.type;
    }
    /**
     * Set type for this Movie 
     * @param type Movie type 
     */
    public void setType(Enums.TypeOfMovie type){
        this.type = type;
    }
    /**
     * Get Movie rating 
     * @return Movie rating 
     */
    public Enums.MovieRating getMovieRating(){
        return this.movieRating;
    }
    /**
     * Set Movie rating 
     * @param movieRating Movie rating 
     */
    public void setMovieRating(Enums.MovieRating movieRating) {
        this.movieRating = movieRating;
    } 
    /**
     * Get list of cast members 
     * @return Movie cast list 
     */
    public ArrayList<String> getCastList(){
        if(this.castList.size() == 0){
            ArrayList<String> nullString = new ArrayList<String>(1);
            nullString.add("NA");
            return nullString;
        }
        return this.castList;
    }
    /**
     * Add cast member into cast list 
     * @param castName Cast name
     */
    public void addCast(String castName){
        this.castList.add(castName);
    }

    // OVERALL Reviewer Rating
    /**
     * Get overall reviewer rating of this Movie 
     * @return Overall reviewer rating of this Movie 
     */ 
    public double getOverallReviewerRating(){
        return this.overallReviewerRating;
    }

    // Private Helper method to calculate overall reviewer rating
    /**
     * Add new overall reviewer rating of this Movie 
     * @param newReviewerRating New reviewer rating 
     */
    private void updateOverallReviewerRating(int newReviewerRating){
        int numOfRatings = movieReviewList.size();
        double totalRatings = (overallReviewerRating * (numOfRatings - 1))  + newReviewerRating;
        this.overallReviewerRating = totalRatings / numOfRatings;
        // 1DP
        int scale = (int) Math.pow(10, 1);
        this.overallReviewerRating =  (double) Math.round(this.overallReviewerRating * scale) / scale;
    }

    // REVIEWS - CALLED BY MOVIE GOER USER CLASS
    // Add review
    /**
     * Add review for this Movie 
     * @param rating Numerical rating 
     * @param review Worded rating 
     */
    public void addReview(int rating, String review){
        Review newReview = new Review(review, rating);
        movieReviewList.add(newReview);
        updateOverallReviewerRating(rating);
    }
    /**
     * Get Movie review list 
     * @return Movie review list 
     */
    public ArrayList<Review> getMovieReviewList(){
        return this.movieReviewList;
    }
    
    // Ticket Sales
    /**
     * Get ticket sales of this Movie 
     * @return Ticket sales
     */
    public int getTicketSales(){
        return this.ticketSales;
    }
    /**
     * Add number of ticket sold for this Movie 
     * @param numOfTickets Number of ticket
     */
    public void addTicketSales(int numOfTickets){
        this.ticketSales += numOfTickets;
    }
}