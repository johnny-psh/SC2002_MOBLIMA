package Controller;
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import java.io.FileOutputStream; 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * Class to edit ticket sale data base
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class UpdateTicketSaleController {
    /**
     * File path
     */
    private final static String FILENAME = "./database/Movies.xlsx";
    /**
     * Update ticket sale data base 
     * @param numOfTickets Number of ticket bought 
     * @param movieID Movie ID of ticket bought 
     */
    public static void updateTicketSale(int numOfTickets, String movieID){
        int TICSALEROW = 7;
        try{
            FileInputStream inputStream = new FileInputStream(new File(FILENAME));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell;
            int col = 0;
            // Iterate through column to find movie based on ID
            cell = cellIterator.next();
            while(cellIterator.hasNext()){
                String cellMovieID;
                if(cell != null && cell.getCellType() == CellType.NUMERIC){
                    cellMovieID = (int)cell.getNumericCellValue() + "";
                }
                else if(cell != null && cell.getCellType() == CellType.STRING){
                    cellMovieID = cell.getStringCellValue();
                }
                else cellMovieID = null;
                if(cellMovieID.equals(movieID)){
                    cell = sheet.getRow(TICSALEROW).getCell(col);
                    cell.setCellValue(numOfTickets);
                    break;
                }
                cell = cellIterator.next();
                col++;
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
