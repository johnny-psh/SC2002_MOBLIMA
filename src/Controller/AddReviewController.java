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

public class AddReviewController {
    private final static String FILENAME = "./database/Movies.xlsx";

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
                    reviews += "|rating:" + rating + "review:" + description;
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
