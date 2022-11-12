package View;
import java.util.Scanner;

import Controller.MoviesController;
import Model.Enums;
import Model.Movie;

import java.util.ArrayList;
/**
 * Class of user interface for movie listing 
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class MovieListUI {

    static Scanner scanner = new Scanner(System.in);
    /**
     * Method to display movie listing menu
     */
    public static void displayMenu(){
        ArrayList<Movie> movieList = MoviesController.read();
        if(movieList.isEmpty()){
            System.out.println("\nNo movies to be listed!");
        }
        else{
            System.out.println("\nMovie List:\n");
            System.out.println("ID:\tTitle:");

            for(Movie movie : movieList){
                if(movie.getShowingStatus() != Enums.ShowingStatus.END_OF_SHOWING){
                    System.out.println(movie.getMovieID() + "\t" + movie.getTitle() + " (" + movie.getShowingStatus().toString() + ")");
                }
            }
        }
        ExitUI.displayMenu();
    }
}
