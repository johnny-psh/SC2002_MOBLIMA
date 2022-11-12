package View;
import Model.Movie;
/**
 * Class that displays movie details
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class MovieDetailsPrinter {
    /**
     * Movie variable 
     */
    private Movie movie;
    /**
     * Class constructor 
     * @param movie Movie 
     */
    public MovieDetailsPrinter(Movie movie){
        this.movie = movie;
    }
    /**
     * Method to display movie detials 
     */
    public void printMovieDetails(){
        System.out.print(
                "ID: " + this.movie.getMovieID() + "\n"
                + "Title: " + this.movie.getTitle() + "\n"
                + "Type: " + this.movieTypeToString() + "\n"
                + "Showing Status: " + this.showingStatusToString() + "\n"
                + "Synopsis: " + this.movie.getSypnosis() + "\n"
                + "Rating: " + this.movieRatingToString() + "\n"
                + "Director: " + this.movie.getDirector() + "\n"
                + "Cast: " + this.castListToString() + "\n"
                + "Overall review rating: " + this.overallReviewerRatingToString() + "\n"
                + "Reviews: "
        );
        this.printPastReviews();
    }
    /**
     * Method to convert movie type to string
     * @return Movie type string 
     */
    public String movieTypeToString(){
        if(this.movie.getType() == null) return "NA";
        return (this.movie.getType().toString());
    }
    /**
     * Method to convert showing status to string
     * @return Movie showing status string 
     */
    public String showingStatusToString(){
        if(this.movie.getShowingStatus() == null) return "NA";
        return (this.movie.getShowingStatus().toString());
    }
    /**
     * Method to convert movie rating to string
     * @return Movie rating string
     */
    public String movieRatingToString(){
        if(this.movie.getMovieRating() == null) return "NA";
        return (this.movie.getMovieRating().toString());
    }
    /**
     * Method to convert overall reviewer rating to string 
     * @return Overakk reviewer rating string 
     */
    public String overallReviewerRatingToString(){
        if(this.movie.getOverallReviewerRating() == -1) return "NA";
        return ("" + this.movie.getOverallReviewerRating());
    }
    /**
     * Method to convert cast list to string
     * @return Cast list string
     */
    public String castListToString(){
        if(this.movie.getCastList().size() == 0) return "NA";
        return (String.join(", ", this.movie.getCastList()));
    }

    // Print Past Reviews
    /**
     * Display past reviews of a movie 
     */
    public void printPastReviews(){
        if(this.movie.getMovieReviewList().size() == 0)
            System.out.println("NA");
        else{
            System.out.println("");
            for(int i=0; i < this.movie.getMovieReviewList().size(); i++){
                System.out.println("\t" + this.movie.getMovieReviewList().get(i).getRating() + " - " + this.movie.getMovieReviewList().get(i).getDescription());
        }
        }
    }
    
}
