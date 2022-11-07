import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MoviesController {
    public final static String FILENAME = "./src/database/Movie.xlsx";

    public static ArrayList<Movie> read(){
        // Array list of movies to return
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        Movie movie;

        // Movie variables
        String movieID, movieTitle;
        try{
            FileInputStream file = new FileInputStream(new File(FILENAME));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Iterate through row

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
                movieTitle = cellIterator.next().getStringCellValue();
                
                // Create movie object and add to movieList
                movie = new Movie(movieID, movieTitle);
                movieList.add(movie);
            }
            workbook.close(); 
            file.close();
        }
        catch (Exception e) {
  
            // Display the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
        return movieList;
    }

    public static Movie readByID(String movieID){
        ArrayList<Movie> movieList = read();
        for (int i=0; i < movieList.size(); i++){
            Movie movie = movieList.get(i);
            if (movie.getMovieID().equals(movieID))
                return movie;
        }
        return null;
    }

}
