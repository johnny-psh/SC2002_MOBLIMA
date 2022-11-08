import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.text.ParseException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.CellValue;

public class ViewMovieDetailUI {
    static Scanner sc = new Scanner(System.in);
    static String path = "./src/database/Movies.csv";
    
    public static int checkID(int givenID)
    {
        File xlsxFile = new File("./src/database/Movies.xlsx");
        try
        {
                FileInputStream inputStream = new FileInputStream(xlsxFile);
                Workbook workbook = WorkbookFactory.create(inputStream);
                Sheet sheet = workbook.getSheetAt(0);
                int endColumn = sheet.getRow(0).getLastCellNum();
                int count = 2;
                for(int i=1;i<endColumn;i++,count++)
                {
                Cell CellID = workbook.getSheetAt(0).getRow(0).getCell(i); 
                
                int cellString = (int)(CellID.getNumericCellValue());
                
                if(cellString==givenID)
                {  
                    System.out.println("Found : " + count);
                    return count;
                }
                }
        }
        catch (EncryptedDocumentException | IOException e) {

            System.err.println("File not found");
            e.printStackTrace();
        }
        System.out.println("Not Found");
        return 0;
    }

    public static String[] getDetails(Workbook workbook,int givenID)
    {
        String[] p= new String[7];
        Sheet sheet = workbook.getSheetAt(0);
    
        Row row = sheet.getRow(givenID);
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {

            Cell cell = sheet.getRow(i).getCell(givenID);
            switch (cell.getCellType()) {
                case NUMERIC:
                String convert = String.valueOf(cell.getNumericCellValue());
                if(convert!= null && !convert.equals(""))
                {
                   p[i] = String.valueOf(cell.getNumericCellValue());
                }
                   break;
                
                case STRING:
                if(cell.getStringCellValue() != null && !cell.getStringCellValue().equals(""))
                {
                p[i] = cell.getStringCellValue();
                }
                   break;
             }
        }



        return p;
    }
   
    public static void displayMenu() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(path));
        FileWriter fw = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        File xlsxFile = new File("./src/database/Movies.xlsx");


        System.out.print("Enter movie ID to view movie detail: ");
        int kID  = sc.nextInt();
            while(checkID(kID)==0)
                {
                    System.out.println("Enter Existing ID: ");
                    kID  = sc.nextInt();
                }
        String mID = String.valueOf(kID);
        int actualPosition = checkID(kID);
       
        try {
            FileInputStream inputStream = new FileInputStream(xlsxFile);

            Workbook workbook = WorkbookFactory.create(inputStream);
            //deleteMovie(workbook, actualPosition);
            String[] thisDetails = getDetails(workbook, actualPosition);
            String[] fields = {"ID","Title","Synposis","Status","Age Rating","Type","Director"};

            for(int i=0;i<fields.length;i++)
            {
                System.out.printf("%s : %s \n",fields[i],thisDetails[i]);
            }

            //System.out.println(Arrays.toString(thisDetails));



            FileOutputStream fos = new FileOutputStream(xlsxFile);
            workbook.write(fos);
            fos.close();
            System.out.println("Success: updated new column with data to an existing excel file.");
        } catch (EncryptedDocumentException | IOException e) {

            System.err.println("Failed: adding new column to an existing excel file.");
            e.printStackTrace();
        }

        ExitUI.displayMenu();
        return; 
    }
}


