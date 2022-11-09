package Controller;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HolidaysController {
    private final static String FILENAME = "./src/database/SystemSettings.xlsx";
    private final static int COLNUM = 1;

    public static ArrayList<Date> read(){
        ArrayList<Date> holidayList = new ArrayList<Date>();
        String dateString = "";
        SimpleDateFormat dateFormatter = new SimpleDateFormat("ddMMyyyy");

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
                        dateString = ((int) cell.getNumericCellValue() + "");
                    else if(cell.getCellType() == CellType.STRING)
                        dateString = cell.getStringCellValue();
                    // Add 0 infront of date string if it is missing for DB
                    if(dateString.length() == 7)
                        dateString = '0' + dateString;
                    Date date = dateFormatter.parse(dateString);
                    holidayList.add(date);
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
        return holidayList;
    }
}
