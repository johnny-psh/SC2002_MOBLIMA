import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class BookingUI {

    private ShowtimeList tempShowtimeList = new ShowtimeList();

	static Scanner scanner = new Scanner(System.in);
    private Cineplex selectedCinepex;
    private Cinema selectedCinema;
    private Date selectedDate;
    private Showtime selectedShowtime;
    private int numOfTickets;
    private Transaction transaction;
    private ArrayList<Showtime> showtimeList = new ArrayList<Showtime>();
    
    public static void displayMenu(){

        ShowtimeList tempShowtimeList = new ShowtimeList();
        Cineplex selectedCinepex;
        Date selectedDate;
        Movie selectedMovie;
        Showtime selectedShowtime;
        int numOfTickets = 0;
        ArrayList<Showtime> showtimeByCineplex = new ArrayList<Showtime>();
        ArrayList<Showtime> showtimeByDate = new ArrayList<Showtime>();
        ArrayList<Showtime> showtimeByMovie = new ArrayList<Showtime>();

        // 1. Select Cineplex
        selectedCinepex = selectCineplex();
        showtimeByCineplex = tempShowtimeList.getShowtimeListByCineplex(selectedCinepex);
        // 2. Select Date
        selectedDate = selectDate(showtimeByCineplex);
        showtimeByDate = ShowtimeList.getShowtimeListByDate(showtimeByCineplex, selectedDate);
        // 3. Select Movie
        selectedMovie = selectMovie(showtimeByDate);
        showtimeByMovie = ShowtimeList.getShowtimeListByDate(showtimeByDate, selectedDate);
        // 4. Select Showtime
        selectedShowtime = selectShowtime(showtimeByMovie);
        // 5. View seats
        viewSeats(selectedShowtime.getCinema());
        // 6. Select number of seats to purchase
        System.out.print("\nNumbers of tickets to purchase: ");
        numOfTickets = scanner.nextInt();
        // 7. Select seats
        selectSeats(numOfTickets, selectedShowtime.getCinema());
        // 8. Transaction
        completeTransaction(numOfTickets, selectedShowtime.getCinema());
    }

    private static Cineplex selectCineplex(){
        int userOption = 0;
		while(userOption != 4) {
            System.out.println("Select Cineplex: ");
            System.out.println("1. Downtown Cineplex");
            System.out.println("2. Causeway Cineplex");
            System.out.println("3. West Mall Cineplex");
            System.out.println("4. Back");
			System.out.print("Option > ");
			userOption = scanner.nextInt();

			switch(userOption) {
                case 1:
                    return;
				case 2:
                    return;
				case 3:
                    return;
				case 4:
                    return;
                default:
					System.out.println("Invalid Option!");
					System.out.println("Please re-enter!");
					break;    
            }
        }
    }

    private static Date selectDate(ArrayList<Showtime> showtimeList){
        
        int userOption = 0;
        int numOfOptions = showtimeList.size() + 1;
		while(userOption >= numOfOptions) {
            System.out.println("Select Date: ");
            for(int i = 1; i <= showtimeList.size(); i++){
                System.out.println(i + "." + showtimeList.get(i).getFormattedDate());
            }
            System.out.println(numOfOptions + ". Back");
		    System.out.print("Option > ");
			userOption = scanner.nextInt();

            // Back
			if(userOption >= numOfOptions){
				System.out.println("Invalid Option!");
				System.out.println("Please re-enter!");
                break;
            }

            return (showtimeList.get(userOption).getDate());
        }
        return null;
    }

    private static Movie selectMovie(ArrayList<Showtime> showtimeList){
        int userOption = 0;
        int numOfOptions = showtimeList.size() + 1;
		while(userOption >= numOfOptions) {
            System.out.println("Select Date: ");
            for(int i = 1; i<=showtimeList.size(); i++){
                showtimeList.get(i).printShowtime();
            }
            System.out.println(numOfOptions + ". Back");
		    System.out.print("Option > ");
			userOption = scanner.nextInt();

            // Back
			if(userOption >= numOfOptions){
				System.out.println("Invalid Option!");
				System.out.println("Please re-enter!");
                break;
            }

            return (showtimeList.get(userOption).getMovie());
        }
        return null;
    }

    private static Showtime selectShowtime(ArrayList<Showtime> showtimeList){
        int userOption = 0;
        int numOfOptions = showtimeList.size() + 1;
		while(userOption >= numOfOptions) {
            System.out.println("Select Date: ");
            for(int i = 1; i<=showtimeList.size(); i++){
                showtimeList.get(i).printShowtime();
            }
            System.out.println(numOfOptions + ". Back");
		    System.out.print("Option > ");
			userOption = scanner.nextInt();

            // Back
			if(userOption >= numOfOptions){
				System.out.println("Invalid Option!");
				System.out.println("Please re-enter!");
                break;
            }

            return (showtimeList.get(userOption));
        }
        return null;
    }
    
    private static void viewSeats(Cinema cinema){
        cinema.printCinemaLayout();
    }

    private static void selectSeats(int numOfTickets, Cinema cinema){
        char row;
        int col;
        boolean isOccupiedSeat = false;
        for(int i = 0; i < numOfTickets; i++){
            do{
                System.out.println("Ticket (" + (i+1) + ")");
                System.out.print("Row: ");
                row = scanner.next().charAt(0);
                System.out.print("Column: ");
                col = scanner.nextInt();
                if(!cinema.getSeatOccupied(row, col)){
                   isOccupiedSeat = false;
                   break;
                }
                System.out.println("Seat selected is occupied. Please select another seat");
                isOccupiedSeat = true;
            }while(isOccupiedSeat);
        }
    }

    private static void completeTransaction(int numOfTickets, Cinema cinema){
        // Make Payment

        // Transaction
        Transaction transaction = new Transaction(cinema.getCinemaID());
        System.out.println("You have successfully purchased " + numOfTickets + " ticket(s)");
        System.out.println("Transaction ID: " + transaction.getTransactionID());
    }
}
