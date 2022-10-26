import java.util.*;
import java.io.*;

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


public class AdminModule {

    static Scanner sc = new Scanner(System.in);
    static String path = "./src/database/Movies.csv";
    
   // ./src/database/TestMoviesReader.xlsx


   public static void insertNewColumnBeforeWithData(Workbook workbook, int colIndex,String [] arr) {
    // Getting the first sheet from workbook
    Sheet sheet = workbook.getSheetAt(0);
    //int startColumn = colIndex;
    int endColumn = sheet.getRow(0).getLastCellNum();

    // to insert only one column
    //int newColCount = 1;

    //Get Last row
    int newCol = endColumn++; 

    // Add the data to new column , just to know what data needed here to progress
    for (int i = 0; i <= sheet.getLastRowNum(); i++) {
        Row row = sheet.getRow(i);
            row.createCell(newCol).setCellValue(arr[i]);
        
    }

}

    public static void MenuPage(Administrator a) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        FileWriter fw = new FileWriter(path, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        while(a.getValid())
        {
            int choice;

            System.out.println("Welcome " + a.name);
            System.out.println("Select an option: ");
            System.out.println("1. Movie Listings");
            System.out.println("2. Showtimes");
            System.out.println("3. System Settings");
            System.out.println("4. Logout");
            System.out.print("Option > ");

            choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                System.out.println("MOVIE LISTING");
                System.out.println("1. Create New Movie Listing");
                System.out.println("2. Update Current Movie Listing");
                System.out.println("3. Remove Movie Listing");
                System.out.println("4. Exit");
                System.out.print("Option > ");
                int listing = sc.nextInt();
                if(listing == 1)
                {
                    //Delete if deprecated function
                    // Movie m = MovieListings.createMovie();

                    // pw.println(m.getMovieID() + "," + m.getTitle() + "," + m.getSypnosis() + "," + m.getDirector() + "," + m.getCast() + "," + 
                    //            m.getShowingStatus() + "," + m.getType() + "," + m.getMovieRating() + "," 
                    //            + m.getOverallReviewerRating());
                    // pw.flush();         
                    

                    //Add into excel function below
                    File xlsxFile = new File("./src/database/TestMoviesReader.xlsx");

                    try {
                        // Creating input stream
                        FileInputStream inputStream = new FileInputStream(xlsxFile);

                        String[] dummydata = {"1", "t2", "3"}; 

                        // Creating workbook from input stream
                        Workbook workbook = WorkbookFactory.create(inputStream);
                        insertNewColumnBeforeWithData(workbook, 1,dummydata);
                        
                        // Write the updated workbook to the file
                        FileOutputStream fos = new FileOutputStream(xlsxFile);
                        workbook.write(fos);
                        // close the output stream
                        fos.close();
                        System.out.println("Success: added new column with data to an existing excel file.");
                    } catch (EncryptedDocumentException | IOException e) {

                        System.err.println("Failed: adding new column to an existing excel file.");
                        e.printStackTrace();
                    }
                }
                else if(listing == 2)
                {
                    System.out.println("Which Movie would you like to update?");
                    System.out.println("Movie ID\t" + "Movie Title");
                    String line = "";
                    while((line = br.readLine())!=null)
                    {
                        String values[] = line.split(",");
                        System.out.println(values[0] + "\t\t" + values[1]);
                    }

                }
                else if(listing == 3)
                {

                }
                else if(listing == 4)
                {
                    break;
                }
                break;

                case 2:
                break;
                case 3:
                break;
                case 4:
                a.isValid(false, a.name);
            }
        }
        pw.close();
        br.close();
    }

    
    
}
