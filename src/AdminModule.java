import java.util.*;
import java.io.*;

public class AdminModule {

    static Scanner sc = new Scanner(System.in);
    static String path = "./database/Movies.csv";

    public static void MenuPage(Administrator a) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        FileWriter fw = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        while(a.getValid())
        {
            int choice;

            System.out.println("Welcome " + a.name);
            System.out.println("Select an option: ");
            System.out.println("1. Movie Listings");
            System.out.println("2. Showtimes");
            System.out.println("3. System Settings");
            System.out.println("4. Logout");
            System.out.print("Option > ");

            choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                System.out.println("MOVIE LISTING");
                System.out.println("1. Create New Movie Listing");
                System.out.println("2. Update Current Movie Listing");
                System.out.println("3. Remove Movie Listing");
                System.out.println("4. Exit");
                System.out.print("Option > ");
                int listing = sc.nextInt();
                if(listing == 1)
                {

                    Movie m = MovieListings.createMovie();

                    pw.println(m.getMovieID() + "," + m.getTitle() + "," + m.getSypnosis() + "," + m.getDirector() + "," + m.getCast() + "," + 
                               m.getShowingStatus() + "," + m.getType() + "," + m.getMovieRating() + "," 
                               + m.getOverallReviewerRating());
                    pw.flush();            
                }
                else if(listing == 2)
                {
                    System.out.println("Which Movie would you like to update?");
                    System.out.println("Movie ID\t" + "Movie Title");
                    String line = "";
                    while((line = br.readLine())!=null)
                    {
                        String values[] = line.split(",");
                        System.out.println(values[0] + "\t\t" + values[1]);
                    }

                }
                else if(listing == 3)
                {

                }
                else if(listing == 4)
                {
                    break;
                }
                break;

                case 2:
                break;
                case 3:
                break;
                case 4:
                a.isValid(false, a.name);
            }
        }
        pw.close();
        br.close();
    }
    
}
