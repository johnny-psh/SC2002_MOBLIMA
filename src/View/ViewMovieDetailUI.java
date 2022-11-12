package View;
import java.io.*;
import java.util.*;

import Controller.MoviesController;
import Model.Movie;

public class ViewMovieDetailUI {
    static Scanner scanner = new Scanner(System.in);
   
    public static void displayMenu() throws IOException{
        boolean valid = false;
        do{
            System.out.print("\nEnter movie ID to view movie detail: ");
            String movieID = scanner.next();
        
            Movie movie = MoviesController.readByID(movieID);
            if(movie == null){
                System.out.println("\nMovie with this id does not exist! Please try keying in another movie ID.");
            }
            else{
                System.out.println("");
                MovieDetailsPrinter movieDetailsPrinter = new MovieDetailsPrinter(movie);
                movieDetailsPrinter.printMovieDetails();
                valid = true;
            }
        } while(!valid);
        ExitUI.displayMenu();
        return; 
    }
}


