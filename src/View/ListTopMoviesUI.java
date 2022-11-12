package View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import Controller.MoviesController;
import Model.Movie;
/**
 * Class of user interface for listing top movies
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class ListTopMoviesUI {
	static Scanner scanner = new Scanner(System.in);
    /**
     * Number of movies to print 
     */
    private static final int NUMBTOPRINT = 5;
    /**
     * Method to display top movies menu
     */
    public static void displayMenu(){
		int userOption = 0;
        while(userOption != 3){
            System.out.println("\nSelect Option: ");
            System.out.println("1. List top 5 movies according to Overall Reviewers Rating");
            System.out.println("2. List top 5 movies according to Ticket Sales");
            System.out.println("3. Back");
            System.out.print("Option > ");
            userOption = scanner.nextInt();
            switch (userOption) {
            case 1:
                listByOverallReview();
                break;
            case 2:
                listByTicketSales();
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid input! Please try again.");
            }
        }
        ExitUI.displayMenu();
        return;
    }
    /**
     * Method to display top movies by overall reviewer rating 
     */
    private static void listByOverallReview(){
        ArrayList<Movie> movieList = MoviesController.read();
        Collections.sort(movieList, Comparator.comparing(Movie::getOverallReviewerRating));
        Collections.reverse(movieList);
        int moviesToPrint = movieList.size() > NUMBTOPRINT ? NUMBTOPRINT : movieList.size();

        System.out.println("\nTop 5 movies according to Overall Reviewers Rating: ");
        for(int i = 0; i < moviesToPrint; i++){
            Movie movie = movieList.get(i);
            if(movie.getOverallReviewerRating() == -1){
                if(i == 0) System.out.println("Sorry, no movies have been rated by reviewers yet.");
                return;
            }           
            MovieDetailsPrinter movieDetailsPrinter = new MovieDetailsPrinter(movie);
            System.out.println((i+1) + ". " + movieDetailsPrinter.overallReviewerRatingToString() + " - " + movie.getTitle());
        }
    }

    /**
     * Method to display top movies by ticket sales
     */
    private static void listByTicketSales(){
        ArrayList<Movie> movieList = MoviesController.read();
        Collections.sort(movieList, Comparator.comparing(Movie::getTicketSales));
        Collections.reverse(movieList);
        int moviesToPrint = movieList.size() > NUMBTOPRINT ? NUMBTOPRINT : movieList.size();

        System.out.println("\nTop 5 movies according to Ticket Sales: ");
        for(int i = 0; i < moviesToPrint; i++){
            Movie movie = movieList.get(i);
            System.out.println((i+1) + ". " + movie.getTicketSales() + " - " + movie.getTitle());
        }
    }
}
