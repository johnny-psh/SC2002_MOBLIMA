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
 * Class to edit review data base
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class AddReviewController {
    /**
     * File path
     */
    private final static String FILENAME = "./database/Movies.xlsx";
    /**
     * Method to add a new review 
     * @param movieID Movie ID for review 
     * @param rating Rating of movie by moviegoer
     * @param description Description of movie by moviegoer
     */
    public static void addReviewToMovie(String movieID, int rating, String description){
        int REVIEWROW = 9;
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
                // When movieID found
                if(cellMovieID.equals(movieID)){
                    cell = sheet.getRow(REVIEWROW).getCell(col);
                    String reviews = "";
                    if(cell != null) reviews = cell.getStringCellValue();
                    reviews += "rating:" + rating + "review:" + description;
                    if(cell == null)
                        cell = sheet.getRow(REVIEWROW).createCell(col);
                    cell.setCellValue(reviews);
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
