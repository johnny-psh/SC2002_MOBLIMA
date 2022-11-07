import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CineplexesController {
    public final static String FILENAME = "./src/database/Cineplexes.xlsx";
    public final static int NUMOFCINEPLEXES = 3;

    public static ArrayList<Cineplex> read(){
        // Array list of cineplexes to return
        ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>();

        // Cineplex variables
        Cineplex cineplex;
        String cineplexName;
        //ArrayList<Cinema> cinemaList = new ArrayList<Cinema>();
        ArrayList<ArrayList<Cinema> > cinemaList = new ArrayList<ArrayList<Cinema>>(NUMOFCINEPLEXES);
        for (int i = 0; i < NUMOFCINEPLEXES; i++) {
            cinemaList.add(new ArrayList<Cinema>());
        }
        // Cinema variables 
        Cinema cinema;
        String cinemaID;
        String cinemaName;
        String cinemaTypeString;
        Enums.CinemaType cinemaType;

        try{
            FileInputStream file = new FileInputStream(new File(FILENAME));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Iterate through row
            int rowNum = 1;
            int cineplexNum = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell = cellIterator.next();
                // Iterate through column
                cineplexName = cell.getStringCellValue();
                // Iterate through column
                cinemaID = cellIterator.next().getStringCellValue();
                cinemaName = cellIterator.next().getStringCellValue();
                cinemaTypeString = cellIterator.next().getStringCellValue();
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
                cinema = new Cinema(cinemaID, cinemaName, cinemaType);
                cinemaList.get(cineplexNum).add(cinema);
                
                if(rowNum % NUMOFCINEPLEXES == 0 && rowNum != 0){
                    cineplex = new Cineplex(cineplexName, cinemaList.get(cineplexNum));
                    cineplexList.add(cineplex);
                    cineplexNum++;
                }
                rowNum++;        
            }
            workbook.close(); 
            file.close();
        }
        catch (Exception e) {
  
            // Display the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
        return cineplexList;
    }

    public static void main(String[] args){
        ArrayList<Cineplex> cineplexes = CineplexesController.read();
        System.out.println(cineplexes.size());
        for(int i = 0; i < cineplexes.size(); i++) {
        	System.out.println((i+1) + ". " + cineplexes.get(i).getCineplexeName());            
            for(int j=0; j < cineplexes.get(i).getCinemaList().size(); j++){
        	System.out.println(cineplexes.get(i).getCineplexeName() + " - " + cineplexes.get(i).getCinemaList().get(j).getCinemaName());
                
            }
		}
    }

}
