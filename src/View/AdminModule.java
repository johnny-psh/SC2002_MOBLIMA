package View;
import java.util.*;
import java.io.*;
import Model.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Admin module class 
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class AdminModule {

    static Scanner sc = new Scanner(System.in);
    /**
     * Method to update column with daata
     * @param workbook Workbook 
     * @param colIndex Index of column 
     * @param arr string array 
     */
   public static void updateColumnWithData(Workbook workbook, int colIndex,String [] arr) {
    Sheet sheet = workbook.getSheetAt(0);

    int smaller = sheet.getLastRowNum();

    if (arr.length <= sheet.getLastRowNum()){
        smaller = arr.length;
    }

    for(int i = 0; i < smaller; i++){
        Row row = sheet.getRow(i);
        if(sheet.getLastRowNum() < arr.length)
        row.createCell(colIndex).setCellValue(arr[i]);
    }

   }

   /**
    * Method to insert a new column before data input 
    * @param workbook Workbook
    * @param arr string array
    */
   public static void insertNewColumnBeforeWithData(Workbook workbook,String [] arr) {
    // Getting the first sheet from workbook
    Sheet sheet = workbook.getSheetAt(0);
    //int startColumn = colIndex;


    // to insert only one column
    //int newColCount = 1;

    //Get Last row
    int endColumn = sheet.getRow(0).getLastCellNum();

    // Add the data to new column , just to know what data needed here to progress
    int rowTotal = sheet.getLastRowNum();
    rowTotal--;

        for (int i = 0; i <= rowTotal; i++) {
        Row row = sheet.getRow(i);
            if(i==0 || i==7)
            {
                int tempID = Integer.parseInt(arr[i]);
                row.createCell(endColumn).setCellValue(tempID);
            }
            else
            {
                row.createCell(endColumn).setCellValue(arr[i]);
            }
            
        
        }
    }
    /**
     * Update workbook with new values
     * @param workbook Workbook 
     * @param colIndex Index of column
     * @param arr String array
     */
    public static void updateValue(Workbook workbook, int colIndex,String [] arr)
    {
        Sheet sheet = workbook.getSheetAt(0);
        colIndex--;

        int rowTotal = sheet.getLastRowNum();
        rowTotal--;
        for (int i = 0; i <= rowTotal; i++) {
            Row row = sheet.getRow(i);
            if(i==0 || i==7)
            {
                int tempID = Integer.parseInt(arr[i]);
                row.createCell(colIndex).setCellValue(tempID);
            }
            else
            {
                row.createCell(colIndex).setCellValue(arr[i]);
            }
            }
    }
    /**
     * Delete movie from workbook
     * @param workbook Workbook
     * @param colIndex Index of column  
     */
    public static void deleteMovie(Workbook workbook, int colIndex)
    {
        //Future note : colIndex cannot be 0 if there is header in xlxs file
        // Like testMovie xlxs, apply to above few
        Sheet sheet = workbook.getSheetAt(0);
        colIndex--;
        //tempColDelete temp col = change to colIndex
        int tempColDelete = colIndex;
        int maxColumn = 0;
        for ( int r=0; r < sheet.getLastRowNum()+1; r++ ){
            Row row = sheet.getRow( r );

            // if no row exists here; then nothing to do; next!
            if ( row == null )
                continue;

            // if the row doesn't have this many columns then we are good; next!
            int lastColumn = row.getLastCellNum();
            if ( lastColumn > maxColumn )
                maxColumn = lastColumn;

            //Temporary placeholder =tempColDelete
            if ( lastColumn < tempColDelete )
                continue;
            //Temporary placeholder =tempColDelete
            for ( int x=tempColDelete+1; x < lastColumn + 1; x++ ){
                Cell oldCell    = row.getCell(x-1);
                if ( oldCell != null )
                    row.removeCell( oldCell );

                Cell nextCell   = row.getCell( x );
                if ( nextCell != null ){
                    Cell newCell    = row.createCell( x-1, nextCell.getCellType() );
                    cloneCell(newCell, nextCell);
                }
            }
        }


        // Adjust the column widths
        for ( int c=0; c < maxColumn; c++ ){
            sheet.setColumnWidth( c, sheet.getColumnWidth(c+1) );
        }
    }
    /**
     * Method to get last column in workbook
     * @param workbook Workbook 
     * @return End of column 
     */
    public static int getLastColumn(Workbook workbook)
    {
        Sheet sheet = workbook.getSheetAt(0);
        int endColumn = sheet.getRow(0).getLastCellNum();
        System.out.println(endColumn);
        return endColumn;
    }
    /**
     * Get position of ID in workbook
     * @param workbook Workbook
     * @return Position in workbook 
     */
    public static int getIDPosition(Workbook workbook)
    {
        Sheet sheet = workbook.getSheetAt(0);
        int endColumn = sheet.getRow(0).getLastCellNum();
        System.out.println(endColumn);
        return endColumn;
    }
    /**
     * Get ID from workbook 
     * @param workbook Workbook 
     * @return ID
     */
    public static String getID(Workbook workbook)
    {
        Sheet sheet = workbook.getSheetAt(0);
        int endColumn = sheet.getRow(0).getLastCellNum();
        //System.out.println(endColumn);
        endColumn--;

        Cell i = workbook.getSheetAt(0).getRow(0).getCell(endColumn); 
        int cellString = (int)(i.getNumericCellValue());
        cellString++;
        String conv = String.valueOf(cellString);
        //System.out.println("ID = " +cellString);
        return conv;
    }
    /**
     * Check movie ID from data base
     * @param givenID Movie ID
     * @return File found or not
     */
    public static int checkID(int givenID)
    {
        File xlsxFile = new File("./database/Movies.xlsx");
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
                    //System.out.println("Found : " + count);
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
        
    /**
     * Method to clone cell
     * @param cNew New cell created
     * @param cOld Old cell to clone
     */
    private static void cloneCell( Cell cNew, Cell cOld ){
        cNew.setCellComment( cOld.getCellComment() );
        cNew.setCellStyle( cOld.getCellStyle() );

        switch ( cNew.getCellType() ){
            case BOOLEAN:{
                cNew.setCellValue( cOld.getBooleanCellValue() );
                break;
            }
            case NUMERIC:{
                cNew.setCellValue( cOld.getNumericCellValue() );
                break;
            }
            case STRING:{
                cNew.setCellValue( cOld.getStringCellValue() );
                break;
            }
            case ERROR:{
                cNew.setCellValue( cOld.getErrorCellValue() );
                break;
            }
            case FORMULA:{
                cNew.setCellFormula( cOld.getCellFormula() );
                break;
            }
            default:
                break;
        }

    }
    /**
     * Method to read showtime from data base
     * @param workbook Workbook 
     */
    public static void readshowTimeCSV(Workbook workbook){
 
            //Get first/desired sheet from the workbook
            //XSSFSheet sheet = workbook.getSheetAt(0);
            Sheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();

            
            int r = 0;
            
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                System.out.print(r+". ");
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    
                    switch (cell.getCellType()) 
                    {
                        case NUMERIC:
                            System.out.print((int)cell.getNumericCellValue() + " ");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + " ");
                            break;
                        default:
                            break;
                    }                  
                }
                System.out.println("");
                r++;
            }
    }
    /**
     * User interface for admin module
     * @param a Admin account
     * @throws IOException
     */
    public static void MenuPage(Administrator a) throws IOException
    {
       

        File xlsxFile = new File("./database/Movies.xlsx");
        File systemSettings = new File("./database/SystemSettings.xlsx");
        File showtime = new File("./database/Showtime.xlsx");

        while(a.getValid())
        {
            int choice;

            System.out.println("Welcome " + a.getUserName());
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
                    

                    
                    //Simple Data insertion
                    sc.nextLine();
                    System.out.println("Enter Movie Title: ");
                    String movieName  = sc.nextLine();

                    System.out.println("Enter Sypnosis: ");
                    String sypnosis  = sc.nextLine();

                    System.out.println("Choose a Status:  1)Coming Soon 2)Preview 3)Now Showing 4)End of Showing ");
                    String[] status = {"Coming Soon","Preview","Now Showing","End of Showing"};
                    int no=0;
                    no = sc.nextInt();
                    while (!(no>=1 && no<=(status.length))) {
                        System.out.println("Please select in its range of 1-"+status.length);
                        no = sc.nextInt();  
                    }
                    no--;

                    System.out.println("Choose a Age Rating:  1)G 2)PG 3)PG13 4)NC16 5)M18 6)R21");
                    String[] AR = {"G","PG","PG13","NC16","M18","R21"};
                    int ARno=0;
                    ARno = sc.nextInt();
                    while (!(ARno>=1 && ARno<=(AR.length))) {
                        System.out.println("Please select in its range of 1-"+AR.length);
                        ARno = sc.nextInt();  
                    }
                    ARno--;
                    sc.nextLine();


                    System.out.println("Choose Type of Movie: 1)2D 2)3D 3)2D Blockbuster 4)3D Blockbuster");
                    String[] MT = {"2D","3D","2D Blockbuster","3D Blockbuster"};
                    int MTno = 0;
                    MTno = sc.nextInt();
                    while (!(MTno>=1 && MTno<=(MT.length))) {
                        System.out.println("Please select in its range of 1-"+MT.length);
                        MTno = sc.nextInt();  
                    }
                    MTno--;

                    sc.nextLine();
                    System.out.println("Enter Director Name:");
                    String Dname = sc.nextLine();

                    System.out.println("Enter Cast List:");
                    String castList = sc.nextLine();


                    
                    try {
                        // Creating input stream
                        FileInputStream inputStream = new FileInputStream(xlsxFile);
                        //Add your input scanner thing for whatever value supposed be here

                        

                        // Creating workbook from input stream
                        Workbook workbook = WorkbookFactory.create(inputStream);
                        //int col = getLastColumn(workbook);
                        //String sCol = Integer.toString(col);

                        String LastID = getID(workbook);


                        String[] inputData = {LastID,movieName,sypnosis, status[no], AR[ARno],MT[MTno],Dname,"0",castList};
                        insertNewColumnBeforeWithData(workbook,inputData);
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
                    //Update section
                    System.out.println("Which Movie would you like to update?");
                    System.out.println("Enter Movie ID: ");
                    
                    int kID  = sc.nextInt();
                    while(checkID(kID)==0)
                    {
                        System.out.println("Enter Existing ID: ");
                        kID  = sc.nextInt();
                    }
                    String mID = String.valueOf(kID);
                    int actualPosition = checkID(kID);

                    //Don delete this
                    sc.nextLine();

                    //Simple Update value
                    System.out.println("Enter Movie Title: ");
                    String movieName  = sc.nextLine();

                    System.out.println("Enter Sypnosis: ");
                    String sypnosis  = sc.nextLine();

                    System.out.println("Choose a Status:  1)Coming Soon 2)Preview 3)Now Showing 4)End of Showing ");
                    String[] status = {"Coming Soon","Preview","Now Showing","End of Showing"};
                    int no=0;
                    no = sc.nextInt();
                    while (!(no>=1 && no<=(status.length))) {
                        System.out.println("Please select in its range of 1-"+status.length);
                        no = sc.nextInt();  
                    }
                    no--;

                    System.out.println("Choose a Age Rating:  1)G 2)PG 3)PG13 4)NC16 5)M18 6)R21");
                    String[] AR = {"G","PG","PG13","NC16","M18","R21"};
                    int ARno=0;
                    ARno = sc.nextInt();
                    while (!(ARno>=1 && ARno<=(AR.length))) {
                        System.out.println("Please select in its range of 1-"+AR.length);
                        ARno = sc.nextInt();  
                    }
                    ARno--;
                    sc.nextLine();


                    System.out.println("Choose Type of Movie: 1)2D 2)3D 3)2D Blockbuster 4)3D Blockbuster");
                    String[] MT = {"2D","3D","2D Blockbuster","3D Blockbuster"};
                    int MTno = 0;
                    MTno = sc.nextInt();
                    while (!(MTno>=1 && MTno<=(MT.length))) {
                        System.out.println("Please select in its range of 1-"+MT.length);
                        MTno = sc.nextInt();  
                    }
                    MTno--;

                     sc.nextLine();
                    System.out.println("Enter Director Name:");
                    String Dname = sc.nextLine();

                    System.out.println("Enter Cast List:");
                    String castList = sc.nextLine();



                    try {
                        FileInputStream inputStream = new FileInputStream(xlsxFile);
                      
                        String[] inputData = {mID,movieName,sypnosis, status[no], AR[ARno],MT[MTno],Dname,"0",castList};

                        Workbook workbook = WorkbookFactory.create(inputStream);
                        updateValue(workbook, actualPosition,inputData);

                        FileOutputStream fos = new FileOutputStream(xlsxFile);
                        workbook.write(fos);
                        fos.close();
                        System.out.println("Success: updated new column with data to an existing excel file.");
                    } catch (EncryptedDocumentException | IOException e) {

                        System.err.println("Failed: updated new column to an existing excel file.");
                        e.printStackTrace();
                    }

                }
                else if(listing == 3)
                {
                    //3. Remove Movie 

                    System.out.println("Enter Movie ID to delete: ");
                    
                    int toDelete  = sc.nextInt();
                    while(checkID(toDelete)==0)
                    {
                        System.out.println("Enter Existing ID: ");
                        toDelete  = sc.nextInt();
                    }
                    int actualPosition = checkID(toDelete);

                    try {
                        FileInputStream inputStream = new FileInputStream(xlsxFile);

                        Workbook workbook = WorkbookFactory.create(inputStream);
                        deleteMovie(workbook, actualPosition);

                        FileOutputStream fos = new FileOutputStream(xlsxFile);
                        workbook.write(fos);
                        fos.close();
                        System.out.println("Success: deleted column in existing excel file.");
                    } catch (EncryptedDocumentException | IOException e) {

                        System.err.println("Failed: deleting column in  an existing excel file.");
                        e.printStackTrace();
                    }

                }
                else if(listing == 4)
                {
                    break;
                }
                break;

                case 2:
                // Create/Update/Remove Cienema Showtime and movies to be shown
                System.out.println("Edit Cienema Showtimes and Movies to be shown");
                System.out.println("1. Create Cienema Showtimes and Movies");
                System.out.println("2. Update Cienema Showtimes and Movies");
                System.out.println("3. Remove Cienema Showtimes and Movies");
                System.out.println("4. Exit");
                System.out.print("Option > ");
                int showtimes = sc.nextInt();

                // Store all the information into an 2D array
                List<List<String>> cienemaShowtimesMovies = new ArrayList<List<String>>();  

                try {
                    // Creating input stream
                    FileInputStream inputStream = new FileInputStream(showtime);
                    //Add your input scanner thing for whatever value supposed be here

                    // Creating workbook from input stream
                    Workbook workbook = WorkbookFactory.create(inputStream);
                    readshowTimeCSV(workbook);

                    // Write the updated workbook to the file

                    // FileOutputStream fos = new FileOutputStream(xlsxFile);
                    // workbook.write(fos);
                    // close the output stream
                    // fos.close();
                    // System.out.println("Success: added new column with data to an existing excel file.");
                } catch (EncryptedDocumentException | IOException e) {

                    System.err.println("Failed: adding new column to an existing excel file.");
                    e.printStackTrace();
                }

                if(showtimes == 1)
                {

                    System.out.println("==========Create new showtime==========");
                    String tempMovie, tempCineplex, tempCinema, tempDate, tempTime = "";
                    System.out.print("Enter Movie ID >");
                    tempMovie = sc.next();
                    System.out.print("Enter Cineplex (Downtown, Causeway, Tampines) > ");
                    tempCineplex = sc.next();
                    System.out.print("Enter Cinema (D01, D02, etc)> ");
                    tempCinema = sc.next();
                    System.out.print("Enter Date > ");
                    tempDate = sc.next();
                    System.out.print("Enter Time > ");
                    tempTime = sc.next();

                    try {
                        // Creating input stream
                        FileInputStream inputStream = new FileInputStream(showtime);
                        //Add your input scanner thing for whatever value supposed be here


                        // Creating workbook from input stream
                        Workbook workbook = WorkbookFactory.create(inputStream);

                        Sheet sheet = workbook.getSheetAt(0);

                        int lastRow = sheet.getLastRowNum(); 
                        Row row = sheet.createRow(lastRow+1);

                        Cell cell = row.createCell(0);
                        cell.setCellValue(tempMovie);

                        cell = row.createCell(1);
                        cell.setCellValue(tempCineplex);

                        cell = row.createCell(2);
                        cell.setCellValue(tempCinema);

                        cell = row.createCell(3);
                        cell.setCellValue(tempDate);

                        cell = row.createCell(4);
                        cell.setCellValue(tempTime);


                        
                        // Write the updated workbook to the file
                        FileOutputStream fos = new FileOutputStream(showtime);
                        workbook.write(fos);
                        // close the output stream
                        fos.close();
                        System.out.println("Successfully created new row!");
                    } catch (EncryptedDocumentException | IOException e) {

                        System.err.println("Failed to create a new row!");
                        e.printStackTrace();
                    }
                }
                else if(showtimes == 2)
                {
                    System.out.println("========== Update Cienema Showtime ==========");
                    System.out.print("Enter the row of the cienema to edit > ");
                    int rowCienema = 0;

                    rowCienema = sc.nextInt();


                    String tempMovie, tempCineplex, tempCinema, tempDate, tempTime = "";
                    System.out.print("Enter Movie ID >");
                    tempMovie = sc.next();
                    System.out.print("Enter Cineplex (Downtown, Causeway, Tampines) > ");
                    tempCineplex = sc.next();
                    System.out.print("Enter Cinema (D01, D02, etc)> ");
                    tempCinema = sc.next();
                    System.out.print("Enter Date > ");
                    tempDate = sc.next();
                    System.out.print("Enter Time > ");
                    tempTime = sc.next();



                    try {
                        FileInputStream inputStream = new FileInputStream(showtime);
                      
                        //Placeholder update function data
                        

                        Workbook workbook = WorkbookFactory.create(inputStream);

                        Sheet sheet = workbook.getSheetAt(0);
                        
                        if(sheet.getLastRowNum() < rowCienema || rowCienema < 0){
                            System.out.println("Row number entered is out of range!");
                            break;
                        }

                        
                        Row row = sheet.getRow(rowCienema);

                        Cell cell = row.getCell(0);
                        cell.setCellValue(tempMovie);

                        cell = row.getCell(1);
                        cell.setCellValue(tempCineplex);

                        cell = row.getCell(2);
                        cell.setCellValue(tempCinema);

                        cell = row.getCell(3);
                        cell.setCellValue(tempDate);

                        cell = row.getCell(4);
                        cell.setCellValue(tempTime);
                        

                        FileOutputStream fos = new FileOutputStream(showtime);
                        workbook.write(fos);
                        fos.close();
                        System.out.println("Successfully edited!");
                    } catch (EncryptedDocumentException | IOException e) {

                        System.err.println("Failed to edit!");
                        e.printStackTrace();
                    }

                }
                else if(showtimes == 3)
                {
                    System.out.println("========== Delete Cienema Showtime ==========");
                    System.out.print("Enter the row of the cienema to delete > ");
                    int rowCienema = 0;

                    rowCienema = sc.nextInt();
            
                    try {
                        FileInputStream inputStream = new FileInputStream(showtime);

                        Workbook workbook = WorkbookFactory.create(inputStream);
                        
                        Sheet sheet = workbook.getSheetAt(0);
                        
                        if(sheet.getLastRowNum() < rowCienema || rowCienema < 0){
                            System.out.println("Row number entered is out of range!");
                            break;
                        }

                        sheet.removeRow(sheet.getRow(rowCienema));

                        FileOutputStream fos = new FileOutputStream(showtime);
                        workbook.write(fos);
                        fos.close();
                        System.out.println("Successfully deleted!");
                    } catch (EncryptedDocumentException | IOException e) {

                        System.err.println("Unable to delete!");
                        e.printStackTrace();
                    }

                }
                else if(showtimes == 4)
                {
                    break;
                }
                break;
                case 3:
                // Configure system settings
                System.out.println("Edit System Settings");
                System.out.println("1. Edit ticket price");
                System.out.println("2. Edit Holiday");
                System.out.println("4. Exit");
                System.out.print("Option > ");
                int systemSettingsOption = sc.nextInt();
                if(systemSettingsOption == 1)
                {

                    try {
                        System.out.println("=============== Edit Ticket Price ===============");
                        System.out.print("Enter Ticket Price for 2D > ");
                        int twoDTicket = sc.nextInt();
                        System.out.print("Enter Ticket Price for 3D > ");
                        int threeDTicket = sc.nextInt();
                        System.out.print("Enter Ticket Price for 2D Blockbuster > ");
                        int twoDTicketBlock = sc.nextInt();
                        System.out.print("Enter Ticket Price for 3D Blockbuster > ");
                        int threeDTicketBlock = sc.nextInt();
                        

                        // Creating input stream
                        FileInputStream inputStream = new FileInputStream(systemSettings);
                        //Add your input scanner thing for whatever value supposed be here

                        // New data
                        String[] updatedTicketPrice = {"price",Integer.toString(twoDTicket), Integer.toString(threeDTicket), Integer.toString(twoDTicketBlock), Integer.toString(threeDTicketBlock)};
                        
                        //Placeholder insert function data
                        //String[] dummydata = {"InsertFunction", "T1", "T3"}; 

                        // Creating workbook from input stream
                        Workbook workbook = WorkbookFactory.create(inputStream);

                        Sheet sheet = workbook.getSheetAt(0);

                        
                        for(int i = 0; i < 5; i++){
                            Row row = sheet.getRow(i);
                            Cell cell = row.createCell(0);
                            cell.setCellValue(updatedTicketPrice[i]);
                        }
                        


                        
                        //updateColumnWithData(workbook, 0,updatedTicketPrice);
                        // Write the updated workbook to the file
                        FileOutputStream fos = new FileOutputStream(systemSettings);
                        workbook.write(fos);
                        // close the output stream
                        fos.close();
                        System.out.println("Updated the movie price successfully!");
                    } catch (EncryptedDocumentException | IOException e) {

                        System.err.println("Failed to update movie price!");
                        e.printStackTrace();
                    }
                }
                else if(systemSettingsOption == 2)
                {
                    System.out.println("=============== Edit Holiday Date ===============");
                    //System.out.println("Movie ID\t" + "Movie Title");

                    
                    List<String> holidayDate = new ArrayList<String>();
                    holidayDate.add("holidays");
                    int inputDate = 0;
                    System.out.println("Enter 0 to stop adding the date");
                    while(true){
                        System.out.print("Enter the holiday date in ddMMyyyy (E.g. 25122022) > ");
                        inputDate = sc.nextInt();
                        if(inputDate == 0){
                            break;
                        }
                        holidayDate.add(Integer.toString(inputDate));
                    }

                    String[] holidayArray = new String[ holidayDate.size() ];
                    holidayDate.toArray( holidayArray );
                    

                    try {
                        FileInputStream inputStream = new FileInputStream(systemSettings);
                      


                        Workbook workbook = WorkbookFactory.create(inputStream);

                        Sheet sheet = workbook.getSheetAt(0);

                        
                        for(int i = 0; i < holidayArray.length; i++){
                            
                            Row row = sheet.getRow(i);
                            
                            if(row == null)
                            {
                                row = sheet.createRow(i);
                            }
                            Cell cell = row.createCell(1);
                            cell.setCellValue(holidayArray[i]);
                        }
                        //updateColumnWithData(workbook, 1, holidayArray);

                        FileOutputStream fos = new FileOutputStream(systemSettings);
                        workbook.write(fos);
                        fos.close();
                        System.out.println("Successly updated holiday date!");
                    } catch (EncryptedDocumentException | IOException e) {

                        System.err.println("Failed to update holiday date!");
                        e.printStackTrace();
                    }

                }
                else if(systemSettingsOption == 3)
                {
                    break;
                }
                break;
                case 4:
                a.isValid(false, a.getUserName());
            }
        }
    }

    
    
}
