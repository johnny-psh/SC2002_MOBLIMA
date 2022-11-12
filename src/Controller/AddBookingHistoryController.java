package Controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream; 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import Model.Transaction;

/**
 * Class to edit booking history data base 
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class AddBookingHistoryController {
    public final static String FILENAME = "./database/BookingHistory.xlsx";
    public final static int NUMOFCOLS = 7;

    public static void addBookingHistory(String username, Transaction transaction){
        // Transaction Variables
        try{
            FileInputStream inputStream = new FileInputStream(new File(FILENAME));
            Workbook workbook = WorkbookFactory.create(inputStream);
 
            Sheet sheet = workbook.getSheetAt(0);

            int newRow = sheet.getLastRowNum() + 1;
            Row row = sheet.createRow(newRow);
            Cell cell;

            String[] colArr = {transaction.getUsername(), transaction.getMobileNum(), transaction.getEmail(), transaction.getCinemaID(), transaction.getMovieName()};

            // Iterate through column
            for(int i = 0; i < NUMOFCOLS; i++){
                    // Numeric cells
                    if(i >= 5){
                        cell = row.createCell(i, CellType.NUMERIC);
                        if(i == 5) cell.setCellValue(transaction.getNumOfTickets());
                        else cell.setCellValue(transaction.getTotalPrice());
                    }
                    // String cells
                    else{
                        cell = row.createCell(i, CellType.STRING);
                        cell.setCellValue(colArr[i]);
                    }
            
            }
            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(FILENAME);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
