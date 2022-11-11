package Controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Model.Enums;
import Model.Movie;
import Model.Review;

public class MoviesController {
    private final static String FILENAME = "./database/Movies.xlsx";

    public static ArrayList<Movie> read(){
        // Array list of movies to return
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        Movie movie;

        // Movie variables
        String movieID, movieTitle, sypnosis, director;
        Enums.ShowingStatus showingStatus;
        Enums.TypeOfMovie type; 
        Enums.MovieRating movieRating; 
        ArrayList<String> castList;
        int ticketSales;
        String statusString, typeString, movieRatingString, castListString;

        try{
            FileInputStream file = new FileInputStream(new File(FILENAME));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through column
            int curCellNum = 0;
            while(curCellNum+1 < sheet.getRow(0).getLastCellNum()){
                curCellNum++;
                Cell cell = sheet.getRow(0).getCell(curCellNum);
                if(cell != null && cell.getCellType() == CellType.NUMERIC) movieID = ((int)cell.getNumericCellValue() + "");
                else movieID = (cell.getStringCellValue());
                cell = sheet.getRow(1).getCell(curCellNum);
                if(cell != null && cell.getCellType() == CellType.NUMERIC) movieTitle = ((int)cell.getNumericCellValue() + "");
                else movieTitle = (cell.getStringCellValue());
                
                // Create movie object
                movie = new Movie(movieID, movieTitle);
                
                // Sypnosis
                cell = sheet.getRow(2).getCell(curCellNum);
                if(cell != null && cell.getCellType() == CellType.STRING){
                    sypnosis = (cell.getStringCellValue());
                    movie.setSypnosis(sypnosis);
                }

                // Status (ENUM)
                cell = sheet.getRow(3).getCell(curCellNum);
                if(cell != null && cell.getCellType() == CellType.STRING) {
                    statusString = (cell.getStringCellValue());
                    switch(statusString){
                        case "Coming Soon":
                            showingStatus = Enums.ShowingStatus.COMING_SOON;
                            break;
                        case "Preview":
                            showingStatus = Enums.ShowingStatus.PREVIEW;
                            break;
                        case "Now Showing":
                            showingStatus = Enums.ShowingStatus.NOW_SHOWING;
                            break;
                        case "End of Showing":
                            showingStatus = Enums.ShowingStatus.END_OF_SHOWING;
                            break;
                        default:
                            showingStatus = null;
                            break;
                    }
                    movie.setShowingStatus(showingStatus);
                }

                // Age Rating (ENUM)
                cell = sheet.getRow(4).getCell(curCellNum);
                if(cell != null && cell.getCellType() == CellType.STRING) {
                    movieRatingString = (cell.getStringCellValue());
                    switch(movieRatingString){
                        case "G":
                            movieRating = Enums.MovieRating.G;
                            break;
                        case "PG":
                            movieRating = Enums.MovieRating.PG;
                            break;
                        case "PG13":
                            movieRating = Enums.MovieRating.PG13;
                            break;
                        case "NC16":
                            movieRating = Enums.MovieRating.NC16;
                            break;
                        case "M18":
                            movieRating = Enums.MovieRating.M18;
                            break;
                        case "R21":
                            movieRating = Enums.MovieRating.R21;
                            break;
                        default:
                            movieRating = null;
                            break;
                    }
                    movie.setMovieRating(movieRating);
                }

                // Type (ENUM)
                cell = sheet.getRow(5).getCell(curCellNum);
                if(cell != null && cell.getCellType() == CellType.STRING) {
                    typeString = (cell.getStringCellValue());
                    switch(typeString){
                        case "2D":
                        type = Enums.TypeOfMovie.TWO_D;
                            break;
                        case "3D":
                        type = Enums.TypeOfMovie.THREE_D;
                            break;
                        case "2D Blockbuster":
                        type = Enums.TypeOfMovie.TWO_D_BLOCKBUSTER;
                            break;
                        case "3D Blockbuster":
                            type = Enums.TypeOfMovie.THREE_D_BLOCKBUSTER;
                            break;
                        default:
                            type = null;
                            break;
                    }
                    movie.setType(type);
                }

                // Director
                cell = sheet.getRow(6).getCell(curCellNum);
                if(cell != null && cell.getCellType() == CellType.NUMERIC){
                    director = ((int)cell.getNumericCellValue() + "");
                    movie.setDirector(director);
                } 
                else if(cell != null && cell.getCellType() == CellType.STRING) {
                    director = (cell.getStringCellValue());
                    movie.setDirector(director);
                }

                // Ticket Sales (int)
                cell = sheet.getRow(7).getCell(curCellNum);
                if(cell != null && cell.getCellType() == CellType.NUMERIC) {
                    ticketSales = (int) cell.getNumericCellValue();
                    movie.addTicketSales(ticketSales);
                }

                // Cast List
                cell = sheet.getRow(8).getCell(curCellNum);
                if(cell != null && cell.getCellType() == CellType.STRING) {
                    castListString = (cell.getStringCellValue());
                    castList = new ArrayList<String>(Arrays.asList(castListString.split(",")));
                    for(String cast : castList){
                        movie.addCast(cast);
                    }
                }
                // Movie Review List
                cell = sheet.getRow(9).getCell(curCellNum);
                if(cell != null){
                    String reviews = cell.getStringCellValue();
                    ArrayList<String> reviewStringList = new ArrayList<String>(Arrays.asList(reviews.split("rating:")));
                    for(String reviewString : reviewStringList){
                        if(reviewString.equals("")) continue;
                        else {
                            String ratingDescString[] = reviewString.split("review:");
                            movie.addReview(Integer.parseInt(ratingDescString[0]), ratingDescString[1]);
                        }
                    }
                }

                // Add movie to movieList
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
