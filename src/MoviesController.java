import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MoviesController {
    private final static String FILENAME = "./src/database/Movies.xlsx";

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

            // Iterate through column
            int curCellNum = 0;
            while(curCellNum+1 < sheet.getRow(0).getLastCellNum()){
                curCellNum++;
                Cell cell = sheet.getRow(0).getCell(curCellNum);
                if(cell.getCellType() != CellType.BLANK && cell.getCellType() == CellType.NUMERIC) movieID = ((int)cell.getNumericCellValue() + "");
                else movieID = (cell.getStringCellValue());
                cell = sheet.getRow(1).getCell(curCellNum);
                if(cell.getCellType() != CellType.BLANK && cell.getCellType() == CellType.NUMERIC) movieTitle = ((int)cell.getNumericCellValue() + "");
                else movieTitle = (cell.getStringCellValue());
                
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
