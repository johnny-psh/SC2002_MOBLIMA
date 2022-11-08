import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.text.SimpleDateFormat;  
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BookingHistoryController {
    public final static String FILENAME = "./src/database/BookingHistory.xlsx";

    public static ArrayList<Transaction> readByUsername(String username){
        ArrayList<Transaction> bookingList = new ArrayList<Transaction>();
        return bookingList;
    }

    public static void addBookingHistory(String username, Transaction transaction){
        
    }
}
