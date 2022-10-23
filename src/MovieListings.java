import java.io.*;
import java.util.*;

public class MovieListings {
    
    static Scanner sc = new Scanner(System.in);
    static String path = "./database/Movies.csv";


    public static Movie createMovie()
    {
        String title, synopsis, director;

        int i, num, option;


        System.out.print("Enter Movie Title: ");
        title = sc.nextLine();
        Movie m  = new Movie(title);

        System.out.print("Enter Synopsis: ");
        synopsis =sc.nextLine();
        m.setSypnosis(synopsis);

        System.out.print("Enter Name of Director: ");
        director = sc.nextLine();
        m.setDirector(director);

        System.out.print("Enter number of Cast Members: ");
        num = sc.nextInt();
        sc.nextLine();
    
        for(i=0;i<num;i++)
        {
            System.out.print("Enter name: ");
            m.addCast(sc.nextLine());
        }

        System.out.println("Enter Showing Status:");
        System.out.println("1. Coming Soon");
        System.out.println("2. Preview");
        System.out.println("3. Now Showing");
        System.out.println("4. End of Showing");
        System.out.print("Option> ");

        option = sc.nextInt();

        switch(option)
        {
            case 1:
            m.setShowingStatus(Enums.ShowingStatus.COMING_SOON);
            break;
            case 2:
            m.setShowingStatus(Enums.ShowingStatus.PREVIEW);
            break;
            case 3:
            m.setShowingStatus(Enums.ShowingStatus.NOW_SHOWING);
            break;
            case 4:
            m.setShowingStatus(Enums.ShowingStatus.END_OF_SHOWING);
            break;
        }

        System.out.println("Enter Type of Movie:");
        System.out.println("1. 2D");
        System.out.println("2. 3D");
        System.out.println("3. 2D Blockbuster");
        System.out.println("3. 3D Blockbuster");
        System.out.print("Option> ");

        option = sc.nextInt();

        switch(option)
        {
            case 1:
                m.setType(Enums.TypeOfMovie.TWO_D);
                break;
            case 2:
                m.setType(Enums.TypeOfMovie.THREE_D);
                break;
            case 3:
                m.setType(Enums.TypeOfMovie.TWO_D_BLOCKBUSTER);
                break;
            case 4:
                m.setType(Enums.TypeOfMovie.THREE_D_BLOCKBUSTER);
                break;
        }

        System.out.println("Enter Rating of Movie:");
        System.out.println("1. G");
        System.out.println("2. PG");
        System.out.println("3. PG13");
        System.out.println("4. NC16");
        System.out.println("5. M18");
        System.out.println("6. R21");
        System.out.print("Option> ");

        option = sc.nextInt();

        switch(option)
        {
            case 1:
                m.setMovieRating(Enums.MovieRating.G);
                break;
            case 2:
                m.setMovieRating(Enums.MovieRating.PG);
                break;
            case 3:
                m.setMovieRating(Enums.MovieRating.PG13);
                break;
            case 4:
                m.setMovieRating(Enums.MovieRating.NC16);
                break;
            case 5:
                m.setMovieRating(Enums.MovieRating.M18);
                break;
            case 6:
                m.setMovieRating(Enums.MovieRating.R21);
                break;
        }

        return m;


    }

    public static void updateMovie()
    {
        
    }

    public static void removeMovie()
    {

    }

    public static void main(String[] args) throws IOException
    {
        FileWriter fw = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        Movie m = MovieListings.createMovie();

        pw.println(m.getTitle() + "," + m.getSypnosis() + "," + m.getDirector() + "," + m.getCast() + "," + 
                    m.getShowingStatus() + "," + m.getType() + "," + m.getMovieRating() + "," + m.getOverallReviewerRating());

        pw.flush();
        pw.close();
        

    } 
    
} 
