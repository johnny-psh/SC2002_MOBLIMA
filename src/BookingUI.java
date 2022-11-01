import java.util.Scanner;
import java.util.ArrayList;

public class BookingUI {
	static Scanner scanner = new Scanner(System.in);
    private Cineplex selectedCinepex;
    private Cinema selectedCinema;
    private int numOfTickets;
    private Transaction transaction;
    
    public void displayMenu(){
        this.selectedCinepex = this.selectCineplex();
        this.selectedCinema = this.selectCinema();
        this.viewSeats();

        System.out.print("\nNumbers of tickets to purchase: ");
        this.numOfTickets = scanner.nextInt();

        this.selectSeats();
        this.completeTransaction();
    }

    private Cineplex selectCineplex(){
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

    private Cinema selectCinema(){
        ArrayList<Cinema> cinemaList = this.selectedCinepex.getCinemaList();
        int userOption = 0;
        int numOfOptions = cinemaList.size() + 1;
		while(userOption != 4) {
           for(int i = 1; i<=cinemaList.size(); i++){
                System.out.println(i + ". " + cinemaList.get(i).getCinemaID());
           }
           System.out.println(numOfOptions + ". Back");
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

    private void viewSeats(){
        this.selectedCinema.printCinemaLayout();
    }

    private void selectSeats(){
        char row;
        int col;
        boolean isOccupiedSeat = false;
        for(int i = 0; i < numOfTickets; i++){
            do{
                System.out.println("Ticket (" + (i+1) + ")");
                System.out.print("Row: ");
                // Check if row selected is alphabet

                row = scanner.next();
                System.out.print("Column: ");
                col = scanner.nextInt();
                if(!this.selectedCinema.getSeatOccupied(row, col)){
                   isOccupiedSeat = false;
                   break;
                }
                System.out.println("Seat selected is occupied. Please select another seat");
                isOccupiedSeat = true;
            }while(isOccupiedSeat);
        }
    }

    private void completeTransaction(){
        // Make Payment

        // Transaction
        this.transaction = new Transaction(this.selectedCinema.getCinemaID());
        System.out.println("You have successfully purchased " + this.numOfTickets + " ticket(s)");
        System.out.println("Transaction ID: " + this.transaction.getTransactionID());
    }
}
