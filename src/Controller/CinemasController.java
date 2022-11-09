package Controller;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream; 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Model.Cinema;
import Model.Enums;
import Model.Seat;

public class CinemasController {
    public final static String FILENAME = "./src/database/Cinemas.xlsx";
    public final static int SEATCOL = 4;

    public static void updateSeats(Cinema cinema){
        String seatString = "";
        for(int i = 0; i < 10; i++){ //rows
            for (int j = 0; j < 10; j++){ //cols
                if(cinema.getSeat(i,j).getIsOccupied()){
                    seatString += 'X';
                }
                else{
                    seatString += 'O';
                }
            }
        }
        try{
            FileInputStream inputStream = new FileInputStream(new File(FILENAME));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            Cell cell;

            // Iterate through row
            rowIterator.next();
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                cell = cellIterator.next();
                if(cell != null && cell.getCellType() == CellType.STRING){
                    if(cell.getStringCellValue().equals(cinema.getCinemaID())){
                        cell = row.createCell(SEATCOL-1, CellType.STRING);
                        cell.setCellValue(seatString);
                    }
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
    
    public static Cinema readByID(String cinemaID){
        ArrayList<Cinema> cinemaList = read();
        for(Cinema cin : cinemaList){
            if(cin.getCinemaID().equals(cinemaID)){
                return cin;
            }
        }
        return null;
    }

    public static ArrayList<Cinema> read(){
        ArrayList<Cinema> cinemaList = new ArrayList<Cinema>();
    
        // Cinema variables 
        Cinema cinema;
        String cinemaID, cinemaName, cinemaTypeString, seatString;
        Enums.CinemaType cinemaType;
        Seat[][] seats;

        try{
            FileInputStream file = new FileInputStream(new File(FILENAME));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            // Skip heading
            rowIterator.next();

            // Iterate through row

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                // Iterate through column
                Cell cell = cellIterator.next();
                if(cell != null && cell.getCellType() == CellType.NUMERIC){
                    cinemaID = ((int)cell.getNumericCellValue() + "");
                } 
                else if(cell != null && cell.getCellType() == CellType.STRING) {
                    cinemaID = (cell.getStringCellValue());
                }
                else cinemaID = "NA";                
                
                cell = cellIterator.next();
                if(cell != null && cell.getCellType() == CellType.NUMERIC){
                    cinemaName = ((int)cell.getNumericCellValue() + "");
                } 
                else if(cell != null && cell.getCellType() == CellType.STRING) {
                    cinemaName = (cell.getStringCellValue());
                }
                else cinemaName = "NA"; 

                cell = cellIterator.next();
                if(cell != null && cell.getCellType() == CellType.STRING) {
                    cinemaTypeString = (cell.getStringCellValue());
                    switch(cinemaTypeString){
                        case "Dolby Atmos":
                            cinemaType = Enums.CinemaType.DOLBY_ATMOS;
                            break;
                        case "Platinum Movie Suites":
                            cinemaType = Enums.CinemaType.PLATINUM_MOVIE_SUITES;
                            break;
                        case "Regular":
                        default:
                            cinemaType = Enums.CinemaType.REGULAR;
                            break;
                    }
                }
                else cinemaType = null;
                
                // Seats
                cell = cellIterator.next();
                if(cell != null && cell.getCellType() == CellType.STRING){
                    seatString = (cell.getStringCellValue());
                    int count = 0;
                    // Initialise seats array
                    seats = new Seat[10][10];
                    for(int i = 1; i <= 10; i++){
                        for(int j = 1; j <= 10; j++){
                            seats[i-1][j-1] = new Seat((char)(i+64), j);
                        }
                    }
                    
                    for(int i = 0; i < 10; i++){ //rows
                        for (int j = 0; j < 10; j++){ //cols
                            char occupancyChar = seatString.charAt(count++);
                            switch(occupancyChar){
                                case 'X':
                                case 'x':
                                    seats[i][j].setIsOccupied(true);
                                    break;
                                default:
                                    seats[i][j].setIsOccupied(false);
                                    break;
                            }
                        }
                    }
                }
                else seats = null;
                

                // cinema obj
                cinema = new Cinema(cinemaID, cinemaName, cinemaType);
                if(seats != null) cinema.setSeats(seats);
                cinemaList.add(cinema);
            }
            workbook.close(); 
            file.close();
        }
        catch (Exception e) {
  
            // Display the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
        return cinemaList;
    }
}
