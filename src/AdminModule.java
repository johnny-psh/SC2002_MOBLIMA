import java.util.*;

public class AdminModule {

    static Scanner sc = new Scanner(System.in);

    public static void MenuPage(Administrator a)
    {
        while(a.getValid())
        {
            int choice;

            System.out.println("Welcome " + a.name);
            System.out.println("Select an option: ");
            System.out.println("1. Movie Listings");
            System.out.println("2. Showtimes");
            System.out.println("3. System Setting");
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
                    String title, synopsis, director;
                    System.out.print("Enter Movie Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Movie Director: ");
                    director = sc.nextLine();
                    System.out.print("Enter Movie Synopsis: ");
                    synopsis = sc.nextLine();
                    Movie m = new Movie(title);
                    m.setDirector(director);
                    m.setSypnosis(synopsis);
                       
                }
                else if(listing == 2)
                {
                    
                }
                else if(listing == 3)
                {

                }
                else if(listing == 4)
                {
                    break;
                }

                case 2:
                System.out.println("SHOWTIMES");
                System.out.println("1. Create New Cinema Showtime");
                System.out.println("2. Update Current Cinema Showtime");
                System.out.println("3. Remove Cinema Showtime");
                System.out.println("4. Exit");
                System.out.print("Option > ");
                int showtime = sc.nextInt();
                if(showtime == 1)
                {
                    
                }
                else if(showtime == 2)
                {
                    
                }
                else if(showtime == 3)
                {

                }
                else if(showtime == 4)
                {
                    break;
                }

                case 3:

                case 4:
                a.isValid(false, a.name);
            }
        }

    }
    
}
