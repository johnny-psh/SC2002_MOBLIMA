package View;
import java.util.*;

import Controller.AddReviewController;
import Controller.MoviesController;
import Model.Movie;
/**
 * Class of user interface for reviews
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class ReviewUI {
    static Scanner scanner = new Scanner(System.in);
    /**
     * Method to diplay review menu 
     */
    public static void displayMenu(){
        System.out.print("\nEnter movie ID: ");
        String movieID = scanner.next();
        Movie movie = MoviesController.readByID(movieID);
        if(movie == null){
            System.out.println("Movie with this id doesn't exist!\n");
        }
        else{
            System.out.print("Enter your rating: ");
            int rating = scanner.nextInt();
            System.out.print("Enter your review: ");
            scanner.nextLine();
            String review = scanner.nextLine();
            AddReviewController.addReviewToMovie(movieID, rating, review);
        }

        ExitUI.displayMenu();
        return; 
    }
}
