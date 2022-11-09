package Controller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.text.SimpleDateFormat;  
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Model.Cinema;
import Model.Cineplex;
import Model.Movie;
import Model.Showtime;


public class ShowtimeController {
    public final static String FILENAME = "./src/database/Showtime.xlsx";

    public static ArrayList<Showtime> read(){
        // Array list of showtimes to return
        ArrayList<Showtime> showtimeList = new ArrayList<Showtime>();
        Showtime showtime;

        // Showtime variables
        Movie movie;
        Cineplex cineplex;
        Cinema cinema;
        Date date, time;

        String movieID, cineplexName, cinemaID, dateString, timeString;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HHmm");

        try{
            FileInputStream file = new FileInputStream(new File(FILENAME));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Iterate through row
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                // Iterate through column
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) 
                {
                    case NUMERIC:
                        movieID = ((int)cell.getNumericCellValue() + "");            
                        break;
                    case STRING:
                    default:
                        movieID = (cell.getStringCellValue());
                        break;
                }
                cineplexName = cellIterator.next().getStringCellValue();
                cinemaID = cellIterator.next().getStringCellValue();
                cell = cellIterator.next();
                switch (cell.getCellType()) 
                {
                    case NUMERIC:
                        dateString = ((int)cell.getNumericCellValue() + "");            
                        break;
                    case STRING:
                    default:
                        dateString = (cell.getStringCellValue());
                        break;
                }
                cell = cellIterator.next();
                switch (cell.getCellType()) 
                {
                    case NUMERIC:
                        timeString = ((int)cell.getNumericCellValue() + "");            
                        break;
                    case STRING:
                    default:
                        timeString = (cell.getStringCellValue());
                        break;
                }
                //Convert string type to their respective types needed for creating Showtime object
                date = dateFormatter.parse(dateString);  
                time = timeFormatter.parse(timeString); 
                cineplex = CineplexesController.readByName(cineplexName);
                cinema = CinemasController.readByID(cinemaID);
                movie = MoviesController.readByID(movieID);
                
                showtime = new Showtime(movie, cineplex, cinema, date, time);
                showtimeList.add(showtime);
                
            }
            workbook.close(); 
            file.close();
        }
        catch (Exception e) {
  
            // Display the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
        return showtimeList;
    }

    public static ArrayList<Showtime> readByCineplex(String cineplexName){
        ArrayList<Showtime> showtimeListByCineplex = new ArrayList<Showtime>();
        ArrayList<Showtime> showtimeList = read();

        for(int i=0; i < showtimeList.size(); i++){
            Showtime curShowtime = showtimeList.get(i);
            if(curShowtime.getCineplex().getCineplexeName().equals(cineplexName)){
                showtimeListByCineplex.add(curShowtime);
            }
        }
        return showtimeListByCineplex;
    }

    public static ArrayList<Showtime> readByCineplexAndDate(String cineplexName, Date date){
        ArrayList<Showtime> showtimeListByCineplexDate = new ArrayList<Showtime>();
        ArrayList<Showtime> showtimeList = read();

        for(int i=0; i < showtimeList.size(); i++){
            Showtime curShowtime = showtimeList.get(i);
            if(curShowtime.getCineplex().getCineplexeName().equals(cineplexName)){
                if(curShowtime.getDate().equals(date))
                showtimeListByCineplexDate.add(curShowtime);
            }
        }
        return showtimeListByCineplexDate;
    }

}
