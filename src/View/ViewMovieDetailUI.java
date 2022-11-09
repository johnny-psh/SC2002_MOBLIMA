package View;
import java.io.*;
import java.util.*;

import Controller.MoviesController;
import Model.Movie;

public class ViewMovieDetailUI {
    static Scanner scanner = new Scanner(System.in);
   
    public static void displayMenu() throws IOException{

        System.out.print("\nEnter movie ID to view movie detail: ");
        String movieID = scanner.next();
       
        Movie movie = MoviesController.readByID(movieID);
        if(movie == null){
            System.out.println("Movie with this id doesn't exist!\n");
        }
        else{
            System.out.println("");
            MovieDetailsPrinter movieDetailsPrinter = new MovieDetailsPrinter(movie);
            movieDetailsPrinter.printMovieDetails();
        }

        ExitUI.displayMenu();
        return; 
    }
}


