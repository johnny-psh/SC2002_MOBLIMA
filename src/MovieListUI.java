import java.util.Scanner;
import java.util.ArrayList;

public class MovieListUI {
    static Scanner scanner = new Scanner(System.in);

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
