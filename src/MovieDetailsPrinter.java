public class MovieDetailsPrinter {
    private Movie movie;

    public MovieDetailsPrinter(Movie movie){
        this.movie = movie;
    }

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

    private String movieTypeToString(){
        if(this.movie.getType() == null) return "NA";
        return (this.movie.getType().toString());
    }

    private String showingStatusToString(){
        if(this.movie.getShowingStatus() == null) return "NA";
        return (this.movie.getShowingStatus().toString());
    }
    private String movieRatingToString(){
        if(this.movie.getMovieRating() == null) return "NA";
        return (this.movie.getMovieRating().toString());
    }

    private String overallReviewerRatingToString(){
        if(this.movie.getOverallReviewerRating() == -1) return "NA";
        return ("" + this.movie.getOverallReviewerRating());
    }

    private String castListToString(){
        if(this.movie.getCastList().size() == 0) return "NA";
        return (String.join(", ", this.movie.getCastList()));
    }

    // Print Past Reviews
    private void printPastReviews(){
        if(this.movie.getMovieReviewList().size() == 0)
            System.out.println("NA");
        else{
            System.out.println("");
            for(int i=0; i < this.movie.getMovieReviewList().size(); i++){
                System.out.println("Rating: " + this.movie.getMovieReviewList().get(i).getRating());
                System.out.println("Review: " + this.movie.getMovieReviewList().get(i).getDescription() + "\n");
            }
        }
    }

    
}
