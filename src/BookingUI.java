import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class BookingUI {
	static Scanner scanner = new Scanner(System.in);
    
    public static void displayMenu(){

        Cineplex selectedCinepex;
        Date selectedDate;
        Showtime selectedShowtime;
        int numOfTickets = 0;
        ArrayList<Showtime> showtimeByCineplex = new ArrayList<Showtime>();
        ArrayList<Showtime> showtimeByDate = new ArrayList<Showtime>();
        ArrayList<Showtime> showtimeByMovie = new ArrayList<Showtime>();

        // 1. Select Cineplex

        selectedCinepex = selectCineplex();
        // 2. Select Date
        selectedDate = selectDate(selectedCinepex);
        // 3. Select Showtime
        selectedShowtime = selectShowtime(selectedCinepex, selectedDate);
        // 4. View seats
        viewSeats(selectedShowtime.getCinema());
        // 5. Select number of seats to purchase
        System.out.print("\nNumbers of tickets to purchase: ");
        numOfTickets = scanner.nextInt();
        // 6. Select seats
        selectSeats(numOfTickets, selectedShowtime.getCinema());
        // 7. Transaction
        completeTransaction(numOfTickets, selectedShowtime.getCinema());
    }

    private static Cineplex selectCineplex(){
        ArrayList<Cineplex> cineplexList = CineplexesController.read();
        int userOption = 0;
        int numOfCineplexes = cineplexList.size();

        // Error
        if(numOfCineplexes == 0)
            return null;

		while(userOption != (numOfCineplexes+1)) {
            for(int i = 0; i < numOfCineplexes; i++) {
                System.out.println((i+1) + ". " + cineplexList.get(i).getCineplexeName());
            }
            System.out.println((numOfCineplexes+1) + ". Back");
			System.out.print("Option > ");
			userOption = scanner.nextInt();

			// Back
			if(userOption >= numOfCineplexes){
				System.out.println("Invalid Option! Please re-enter.");
				System.out.println("Please re-enter.");
                break;
            }
        }
        return (cineplexList.get(userOption));
    }

    private static Date selectDate(Cineplex cineplex){
        ArrayList<Showtime> showtimeList = ShowtimeController.readByCineplex(cineplex.getCineplexeName());
        int userOption = 0;
        int numOfShowtimes = showtimeList.size();

        // Error
        if(numOfShowtimes == 0)
            return null;

		while(userOption >= (numOfShowtimes+1)) {
            System.out.println("Select Date: ");
            for(int i = 1; i <= showtimeList.size(); i++){
                System.out.println(i + "." + showtimeList.get(i).getFormattedDate());
            }
            System.out.println((numOfShowtimes+1) + ". Back");
		    System.out.print("Option > ");
			userOption = scanner.nextInt();

            // Back
			if(userOption >= (numOfShowtimes+1)){
				System.out.println("Invalid Option!");
				System.out.println("Please re-enter!");
                break;
            }
        }
        return (showtimeList.get(userOption).getDate());
    }

    private static Showtime selectShowtime(Cineplex cineplex, Date date){
        ArrayList<Showtime> showtimeList = ShowtimeController.readByCineplexAndDate(cineplex.getCineplexeName(), date);
        
        int numOfShowtimes = showtimeList.size();
        int userOption = 0;

        if(numOfShowtimes == 0)
            return null;
        while(userOption >= (numOfShowtimes+1)) {
            System.out.println("Select Date: ");
            for(int i = 1; i <= showtimeList.size(); i++){
                showtimeList.get(i).printShowtime();
            }
            System.out.println((numOfShowtimes+1) + ". Back");
            System.out.print("Option > ");
            userOption = scanner.nextInt();
    
            // Back
            if(userOption >= (numOfShowtimes+1)){
                System.out.println("Invalid Option!");
                System.out.println("Please re-enter!");
                break;
            }
        }                       
        return (showtimeList.get(userOption));
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
