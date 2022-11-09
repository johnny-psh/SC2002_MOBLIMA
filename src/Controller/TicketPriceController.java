package Controller;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TicketPriceController {
    private final static String FILENAME = "./src/database/SystemSettings.xlsx";
    private final static int COLNUM = 0;

    public static ArrayList<Double> readTicketPrices(){
        ArrayList<Double> pricesList = new ArrayList<Double>();
        Double price = 0.0;

        try{
            FileInputStream file = new FileInputStream(new File(FILENAME));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row = rowIterator.next();
            Cell cell = row.getCell(COLNUM);
            
            while (rowIterator.hasNext() && cell != null){
                row = rowIterator.next();
                cell = row.getCell(COLNUM);
                if(cell != null){
                    if(cell.getCellType() == CellType.NUMERIC)
                        price = cell.getNumericCellValue();
                    else if(cell.getCellType() == CellType.STRING)
                        price = Double.parseDouble(cell.getStringCellValue());
                    pricesList.add(price);
                }   
            }
           
            workbook.close(); 
            file.close();
        }
        catch (Exception e) {
  
            // Display the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }

        return pricesList;
    }
}
