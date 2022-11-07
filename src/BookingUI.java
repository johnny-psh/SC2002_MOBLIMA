import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;  

public class BookingUI {
	static Scanner scanner = new Scanner(System.in);
    
    public static void displayMenu(){

        Cineplex selectedCinepex;
        Date selectedDate;
        Showtime selectedShowtime;
        int numOfTickets = 0;

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
        selectSeats(numOfTickets, selectedShowtime);
        // 7. Transaction
        completeTransaction(numOfTickets, selectedShowtime);
    }

    private static Cineplex selectCineplex(){
        ArrayList<Cineplex> cineplexList = CineplexesController.read();
        int userOption = 0;
        int numOfCineplexes = cineplexList.size();

        // Error
        if(numOfCineplexes == 0)
            return null;

		do {
            System.out.println("\nSelect Cineplex: ");
            for(int i = 0; i < numOfCineplexes; i++) {
                System.out.println((i+1) + ". " + cineplexList.get(i).getCineplexeName());
            }
            System.out.println((numOfCineplexes+1) + ". Back");
			System.out.print("Option > ");
			userOption = scanner.nextInt();

			// Back
			if(userOption < 1 || userOption >= (numOfCineplexes+1)){
				System.out.println("Invalid Option! Please re-enter.");
				System.out.println("Please re-enter.");
                break;
            }
        } while(userOption < 1 || userOption >= (numOfCineplexes+1));
        return (cineplexList.get(userOption-1));
    }

    private static Date selectDate(Cineplex cineplex){
        ArrayList<Showtime> showtimeList = ShowtimeController.readByCineplex(cineplex.getCineplexeName());
        int userOption = 0;
        int numOfShowtimes = showtimeList.size();

        // Error
        if(numOfShowtimes == 0)
            return null;

		do {
            System.out.println("\nSelect Date: ");
            for(int i = 0; i < showtimeList.size(); i++){
                System.out.println((i+1) + ". " + showtimeList.get(i).getFormattedDate());
            }
            System.out.println((numOfShowtimes+1) + ". Back");
		    System.out.print("Option > ");
			userOption = scanner.nextInt();

            // Back
			if(userOption < 1 || userOption >= (numOfShowtimes+1)){
				System.out.println("Invalid Option!");
				System.out.println("Please re-enter!");
                break;
            }
        } while(userOption < 1 || userOption >= (numOfShowtimes+1));
        return (showtimeList.get(userOption-1).getDate());
    }

    private static Showtime selectShowtime(Cineplex cineplex, Date date){
        ArrayList<Showtime> showtimeList = ShowtimeController.readByCineplexAndDate(cineplex.getCineplexeName(), date);
        
        int numOfShowtimes = showtimeList.size();
        int userOption = 0;

        if(numOfShowtimes == 0)
            return null;
        do {
            System.out.println("\nSelect Movie and Showtime: ");
            for(int i = 0; i < showtimeList.size(); i++){
                System.out.print((i+1) + ". ");
                showtimeList.get(i).printShowtime();
            }
            System.out.println((numOfShowtimes+1) + ". Back");
            System.out.print("Option > ");
            userOption = scanner.nextInt();
    
            // Back
            if(userOption < 1 || userOption >= (numOfShowtimes+1)){
                System.out.println("Invalid Option!");
                System.out.println("Please re-enter!");
                break;
            }
        } while(userOption >= (numOfShowtimes+1));            
        return (showtimeList.get(userOption-1));
    }
    
    private static void viewSeats(Cinema cinema){
        cinema.printCinemaLayout();
    }

    private static void selectSeats(int numOfTickets, Showtime showtime){
        Cinema cinema = showtime.getCinema();
        ArrayList<Ticket> ticketList = new ArrayList<Ticket>(numOfTickets);
        char row;
        int col;
        boolean isOccupiedSeat = false;
        double totalPrice = 0;
        for(int i = 0; i < numOfTickets; i++){
            do{
                System.out.println("\nSelect Ticket (" + (i+1) + "):");
                System.out.print("Row: ");
                row = scanner.next().charAt(0);
                row = Character.toUpperCase(row);
                System.out.print("Column: ");
                col = scanner.nextInt();
                if(!cinema.getSeatOccupied(row, col)){
                    cinema.setSeatOccupied(row, col);
                    Enums.TypeOfMovieGoer movieGoerType = selectTypeOfMovieGoer();
                    Seat seat = cinema.getSeat(row,col);
                    Ticket ticket = new Ticket(seat,  showtime, movieGoerType);
                    System.out.println("Price: " + ticket.getTicketPrice());
                    totalPrice += ticket.getTicketPrice();
                    isOccupiedSeat = false;
                    ticketList.add(ticket);
                    break;
                }
                System.out.println("Seat selected is occupied. Please select another seat");
                isOccupiedSeat = true;
            } while(isOccupiedSeat);
        }
        System.out.println("\nTotal price is: " + totalPrice + " SGD");
    	System.out.print("Do you want to confirm payment? Yes (1) / No (2): ");
    	int userOption = scanner.nextInt();
    	if(userOption == 1){
    		saveSeatToDB(cinema);
            saveBookingToDB();
		}
    	else{
    		System.out.println("\nReturning to main menu...\n");
    		return;
		}
    }

    // Function to save reserved seats to database from CinemaController.java
    private static void saveSeatToDB(Cinema cinema){
        return;
    }

    // Function to save booking to user database from userBookings.java
    private static void saveBookingToDB(){
        return;
    }

    private static Enums.TypeOfMovieGoer selectTypeOfMovieGoer(){
        int userOption = 0;

		do {
            System.out.println("\nSelect ticket type: ");
            System.out.println("1. Student");
            System.out.println("2. Adult");            
            System.out.println("3. Senior Citizen");
		    System.out.print("Option > ");
			userOption = scanner.nextInt();

            // Back
			switch (userOption) {
                case 1:
                    return Enums.TypeOfMovieGoer.STUDENT;
                case 2:
                    return Enums.TypeOfMovieGoer.ADULT;
                case 3:
                    return Enums.TypeOfMovieGoer.SENIOR;
                default:
                    System.out.println("Invalid Option!");
				    System.out.println("Please re-enter!");
                    break;
            }
        } while(userOption < 1 || userOption > 3);
        return null;
    }

    private static void completeTransaction(int numOfTickets, Showtime showtime){
        // TODO: Capture movie-goer's name, mobile number, email address
        
        // Transaction
        Transaction transaction = new Transaction(showtime, "Testusername");
        System.out.println("\nYou have successfully purchased " + numOfTickets + " ticket(s)");
        System.out.println(transaction.toString());
        System.out.println("Returning to main menu...\n");
    }
}
