import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ViewBookingHistoryController {
    public final static String FILENAME = "./src/database/BookingHistory.xlsx";

    public static ArrayList<Transaction> read(){
        ArrayList<Transaction> bookingList = new ArrayList<Transaction>();
        Transaction transaction;

        // Transaction Variables
        String username, mobileNum, email, cinemaID, movieName;
        int numOfTickets;
        Double totalPrice;

        try{
            FileInputStream file = new FileInputStream(new File(FILENAME));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Iterate through row
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                // Iterate through column

                // Username
                Cell cell = cellIterator.next();
                if(cell != null && cell.getCellType() == CellType.NUMERIC){
                    username = ((int)cell.getNumericCellValue() + "");
                } 
                else if(cell != null && cell.getCellType() == CellType.STRING) {
                    username = (cell.getStringCellValue());
                }
                else username = "NA";

                // Mobile Num
                cell = cellIterator.next();
                if(cell != null && cell.getCellType() == CellType.NUMERIC){
                    mobileNum = ((int)cell.getNumericCellValue() + "");
                } 
                else if(cell != null && cell.getCellType() == CellType.STRING) {
                    mobileNum = (cell.getStringCellValue());
                }
                else mobileNum = "NA";

                // Email
                cell = cellIterator.next();
                if(cell != null && cell.getCellType() == CellType.NUMERIC){
                    email = ((int)cell.getNumericCellValue() + "");
                } 
                else if(cell != null && cell.getCellType() == CellType.STRING) {
                    email = (cell.getStringCellValue());
                }
                else email = "NA";

                // CinemaID
                cell = cellIterator.next();
                if(cell != null && cell.getCellType() == CellType.NUMERIC){
                    cinemaID = ((int)cell.getNumericCellValue() + "");
                } 
                else if(cell != null && cell.getCellType() == CellType.STRING) {
                    cinemaID = (cell.getStringCellValue());
                }
                else cinemaID = "NA";

                // movieName
                cell = cellIterator.next();
                if(cell != null && cell.getCellType() == CellType.NUMERIC){
                    movieName = ((int)cell.getNumericCellValue() + "");
                } 
                else if(cell != null && cell.getCellType() == CellType.STRING) {
                    movieName = (cell.getStringCellValue());
                }
                else movieName = "NA";

                // num of tickets
                cell = cellIterator.next();
                if(cell != null && cell.getCellType() == CellType.NUMERIC){
                    numOfTickets = (int) cell.getNumericCellValue();
                } 
                else numOfTickets = 0;

                // totalPrice
                cell = cellIterator.next();
                if(cell != null && cell.getCellType() == CellType.NUMERIC){
                    totalPrice = cell.getNumericCellValue();
                } 
                else totalPrice = 0.0;

                transaction = new Transaction(username, mobileNum, email, cinemaID, movieName, numOfTickets, totalPrice);
                bookingList.add(transaction);
                
            }
            workbook.close(); 
            file.close();
        }
        catch (Exception e) {
  
            // Display the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }

        return bookingList;
    }

    public static ArrayList<Transaction> readByUsername(String username){
        ArrayList<Transaction> bookingList = read();
        ArrayList<Transaction> userBookingList = new ArrayList<Transaction>();
        for (Transaction booking : bookingList){
            if(booking.getUsername().equals(username)){
                userBookingList.add(booking);
            }
        }
        
        return userBookingList;
    }
}
