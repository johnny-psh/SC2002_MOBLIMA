import java.util.ArrayList;

public class Movie {
    /*
        This Movie Class is for:
        1) Cinema Staff to Create(new Movie object) / Update(set) / Remove(set Showing status to ENDOFSHOWING) movies
        2) Movie-goer user class to access(get) movie properties
        3) Ticket class to access(get) movie properties
     */
   
    // Properties
    private String movieID, title, sypnosis, director;
    private Enums.ShowingStatus showingStatus;
    private Enums.TypeOfMovie type; // Type of movie (3D, Blockbuster etc.) - This is also called by ticket class 
    private Enums.MovieRating movieRating; // Rating of movie - (PG, M18 etc.)
    private ArrayList<String> castList;
    private ArrayList<Review> movieReviewList;
    private int overallReviewerRating, ticketSales;

    // Constructor - Used by <cinema staff> to create a new movie object
    public Movie(String movieID, String title){
        this.movieID = movieID;
        this.title = title;
        this.castList = new ArrayList<String>();
        this.movieReviewList = new ArrayList<Review>();
        this.ticketSales = 0;
        this.overallReviewerRating = -1;
    }

    public String getMovieID()
    {
        return this.movieID;
    }

    public void setMovieID(String movieID)
    {
        this.movieID = movieID;
    }

    // Note: get classes are called by movieGoer class , 
    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDirector(){
        if(this.director == null)
            return "NA";
        return this.director;
    }
    
    public void setDirector(String director){
        this.director = director;
    }

    public String getSypnosis(){
        if(this.sypnosis == null)
            return "NA";
        return this.sypnosis;
    }

    public void setSypnosis(String sypnosis){
        this.sypnosis = sypnosis;
    }

    public Enums.ShowingStatus getShowingStatus(){
        return this.showingStatus;
    }

    public void setShowingStatus(Enums.ShowingStatus showingStatus){
        this.showingStatus = showingStatus;
    }

    public Enums.TypeOfMovie getType(){
        return this.type;
    }

    public void setType(Enums.TypeOfMovie type){
        this.type = type;
    }

    public Enums.MovieRating getMovieRating(){
        return this.movieRating;
    }

    public void setMovieRating(Enums.MovieRating movieRating) {
        this.movieRating = movieRating;
    } 

    public ArrayList<String> getCastList(){
        if(this.castList.size() == 0){
            ArrayList<String> nullString = new ArrayList<String>(1);
            nullString.add("NA");
            return nullString;
        }
        return this.castList;
    }

    public void addCast(String castName){
        this.castList.add(castName);
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

    public ArrayList<Review> getMovieReviewList(){
        return this.movieReviewList;
    }
    
    // Ticket Sales
    public int getTicketSales(){
        return this.ticketSales;
    }
    public void addTicketSales(int numOfTickets){
        this.ticketSales += numOfTickets;
    }
}