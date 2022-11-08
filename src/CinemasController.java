import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CinemasController {
    public static void update(Cinema cinema){
        //Cinema cin = readByID(cinema.getCinemaID());
        //cin.setSeats(cinema.getSeats());
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
        
        Cinema cinema;
        String cinemaID;
        Seat[][] seats;

        return cinemaList;
    }

}
