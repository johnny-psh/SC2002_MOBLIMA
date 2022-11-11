package View;
import java.util.Scanner;

import Controller.AddBookingHistoryController;
import Controller.CinemasController;
import Controller.CineplexesController;
import Controller.ShowtimeController;
import Controller.TicketManager;
import Controller.TicketPriceManager;
import Controller.UpdateTicketSaleController;
import Model.Cinema;
import Model.Cineplex;
import Model.Enums;
import Model.Seat;
import Model.Showtime;
import Model.Ticket;
import Model.Transaction;

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
        if(selectedCinepex == null) {
            System.out.println("\nReturning to main menu...\n");
            return;
        }

        // 2. Select Date
        selectedDate = selectDate(selectedCinepex);
        if(selectedDate == null) {
            System.out.println("\nReturning to main menu...\n");
            return;
        }

        // 3. Select Showtime
        selectedShowtime = selectShowtime(selectedCinepex, selectedDate);
        if(selectedShowtime == null) {
            System.out.println("\nReturning to main menu...\n");
            return;
        }

        // 4. View seats
        viewSeats(CinemasController.readByID(selectedShowtime.getCinema().getCinemaID()));

        // 5. Select number of seats to purchase
        System.out.print("\nNumbers of tickets to purchase: ");
        numOfTickets = scanner.nextInt();

        // 6. Select seats & transaction
        selectSeats(numOfTickets, selectedShowtime);
        return;
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
            System.out.println((numOfCineplexes+1) + ". Exit");
			System.out.print("Option > ");
			userOption = scanner.nextInt();

			// Back
            if(userOption == (numOfCineplexes + 1))
                return null;
			if(userOption < 1 || userOption > (numOfCineplexes+1)){
				System.out.println("\nInvalid Option! Please re-enter.");
				System.out.println("Please re-enter.");
            }
        } while(userOption < 1 || userOption > (numOfCineplexes+1));
        
        return (cineplexList.get(userOption-1));
    }

    private static Date selectDate(Cineplex cineplex){
        ArrayList<Showtime> showtimeList = ShowtimeController.readByCineplex(cineplex.getCineplexeName());
        // Remove all end of showing showtimes
        for(Showtime showtime : showtimeList){
            if(showtime.getMovie().getShowingStatus() == Enums.ShowingStatus.END_OF_SHOWING)
                showtimeList.remove(showtime);
        }

        int userOption = 0;
        int numOfShowtimes = showtimeList.size();

        // Error
        if(numOfShowtimes == 0){
            System.out.println("There are currently no showtimes available at " + cineplex.getCineplexeName());
            return null;
        }

		do {
            System.out.println("\nSelect Date: ");
            for(int i = 0; i < showtimeList.size(); i++){
                System.out.println((i+1) + ". " + showtimeList.get(i).getFormattedDate());
            }
            System.out.println((numOfShowtimes+1) + ". Exit");
		    System.out.print("Option > ");
			userOption = scanner.nextInt();

            // Back
            if(userOption == (numOfShowtimes + 1))
                return null;
			if(userOption < 1 || userOption > (numOfShowtimes+1)){
				System.out.println("\nInvalid Option!");
				System.out.println("Please re-enter!");
            }
        } while(userOption < 1 || userOption >= (numOfShowtimes+1));
        return (showtimeList.get(userOption-1).getDate());
    }

    private static Showtime selectShowtime(Cineplex cineplex, Date date){
        ArrayList<Showtime> showtimeList = ShowtimeController.readByCineplexAndDate(cineplex.getCineplexeName(), date);
        // Remove all end of showing showtimes
        for(Showtime showtime : showtimeList){
            if(showtime.getMovie().getShowingStatus() == Enums.ShowingStatus.END_OF_SHOWING)
                showtimeList.remove(showtime);
        }

        int numOfShowtimes = showtimeList.size();
        int userOption = 0;

        if(numOfShowtimes == 0){
            System.out.println("There are currently no showtimes available at your selected date");
            return null;
        }
        do {
            System.out.println("\nSelect Movie and Showtime: ");
            for(int i = 0; i < showtimeList.size(); i++){
                System.out.print((i+1) + ". ");
                showtimeList.get(i).printShowtime();
            }
            System.out.println((numOfShowtimes+1) + ". Exit");
            System.out.print("Option > ");
            userOption = scanner.nextInt();
    
            // Back
            if(userOption == (numOfShowtimes + 1))
                return null;
            if(userOption < 1 || userOption > (numOfShowtimes+1)){
                System.out.println("Invalid Option!");
                System.out.println("Please re-enter!");
            }
        } while(userOption > (numOfShowtimes+1));            
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
                    // Create ticket
                    Ticket ticket = new Ticket(seat,  showtime, movieGoerType);
                    // Use ticketmanager to determine ticket type
                    TicketManager ticketManager = new TicketManager(ticket);
                    // Use ticketpricemanager to calculate ticket price
                    TicketPriceManager ticketPriceManager = new TicketPriceManager(ticketManager);
                    double ticketPrice = ticketPriceManager.getTicketPrice();
                    System.out.println("Price: " + ticketPrice);
                    totalPrice += ticketPriceManager.getTicketPrice();
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
            System.out.println("\nYou have successfully purchased " + numOfTickets + " ticket(s)\n");
            completeTransaction(numOfTickets, showtime, totalPrice);
		}
    	else{
    		System.out.println("\nReturning to main menu...\n");
    		return;
		}
    }

    private static void completeTransaction(int numOfTickets, Showtime showtime, Double totalPrice){
        // Capture movie-goer's name, mobile number, email address
        String username, mobileNum, email;

        System.out.print("Enter username: ");
        username = scanner.next();
        System.out.print("Enter mobile number: ");
        mobileNum = scanner.next();
        System.out.print("Enter email: ");
        email = scanner.next();

        // Transaction
        String cinemaID = showtime.getCinema().getCinemaID();
        String movieName = showtime.getMovie().getTitle();
        Transaction transaction = new Transaction(username, mobileNum, email, cinemaID, movieName, numOfTickets, totalPrice);
        TransactionPrinter transactionPrinter = new TransactionPrinter(transaction);
        System.out.println("");
        transactionPrinter.printTransaction();

        // Save booking, booked seats, tickets purchased to respective databases
        saveToDB(showtime, username, transaction, numOfTickets);
        ExitUI.displayMenu();
        return;
    }

    private static void saveToDB(Showtime showtime, String username, Transaction transaction, int numOfTickets){
        CinemasController.updateSeats(showtime.getCinema());
        AddBookingHistoryController.addBookingHistory(username, transaction);
        UpdateTicketSaleController.updateTicketSale(numOfTickets, showtime.getMovie().getMovieID());
    }

    // Allow user to select the type of movie goer - student/adult/senior citizen
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

}
