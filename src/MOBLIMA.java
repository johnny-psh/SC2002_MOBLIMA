// Login plus display  menu in our main function
import java.util.Scanner;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MOBLIMA {

	// Open CSV

	// Initialize Cineplexe object, Movie Object
	static XSSFRow row;
	
	static Scanner scanner = new Scanner(System.in);
	
	public static String[][] getMovies() throws IOException {        
        FileInputStream fis = new FileInputStream(new File("./src/database/TestMoviesReader.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        Iterator < Row >  rowIterator = spreadsheet.iterator();
        int tRow=0;
        int tCol=0;
		//if add row/col , just change here [row][col]
        String[][] TitleTest = new String[10][10];

        while (rowIterator.hasNext()) {
           row = (XSSFRow) rowIterator.next();
           Iterator < Cell >  cellIterator = row.cellIterator();

           while ( cellIterator.hasNext()) {
              Cell cell = cellIterator.next();
              
              switch (cell.getCellType()) {
                 case NUMERIC:
                 String convert = String.valueOf(cell.getNumericCellValue());
                 if(convert!= null && !convert.equals(""))
                 {
                    TitleTest[tRow][tCol] = String.valueOf(cell.getNumericCellValue());
                    tCol++;
                 }
                    break;
                 
                 case STRING:
                 if(cell.getStringCellValue() != null && !cell.getStringCellValue().equals(""))
                 {
                    TitleTest[tRow][tCol] = cell.getStringCellValue();
                    tCol++;
                 }
                    break;
              }
           }
           tRow++;
           tCol=0;
           System.out.println();
        }
        fis.close();  
		String[][] cleanedData = removeNull(TitleTest);

		 return cleanedData;
    }

	public static String[][] removeNull( String[][] arr2d) {
        //
        ArrayList<ArrayList<String>> list2d = new ArrayList<ArrayList<String>>();
        //
        for(String[] arr1d: arr2d){
            ArrayList<String> list1d = new ArrayList<String>();
            for(String s: arr1d){
                if(s != null && s.length() > 0) {
                    list1d.add(s);
                }
            }
            // you will possibly not want empty arrays in your 2d array
            // so I removed them
            if(list1d.size()>0){
                list2d.add(list1d);
            }
        }
        String[][] cleanArr = new String[list2d.size()][];
        int next = 0;
        for(ArrayList<String> list1d: list2d){
            cleanArr[next++] = list1d.toArray(new String[list1d.size()]);
        }
        return cleanArr;
    }

	

	
	public static void main (String[] args) throws IOException {
		System.out.println("   ______      __  __                   _______                  __                       ");
		System.out.println("  / ____/___ _/ /_/ /_  ____ ___  __   / ____(_)___  ___  ____  / /__  _  _____  _____    ");
		System.out.println(" / /   / __ `/ __/ __ \\/ __ `/ / / /  / /   / / __ \\/ _ \\/ __ \\/ / _ \\| |/_/ _ \\/ ___/   ");
		System.out.println("/ /___/ /_/ / /_/ / / / /_/ / /_/ /  / /___/ / / / /  __/ /_/ / /  __/>  </  __(__  )     ");
		System.out.println("\\____/\\__,_/\\__/_/ /_/\\__,_/\\__, /   \\____/_/_/ /_/\\___/ .___/_/\\___/_/|_|\\___/____/      ");
		System.out.println("                           /____/                     /_/                                 ");
		
		int userOption = 0;
		while(userOption != 8) {
			System.out.println("1. Search/List movie");
			System.out.println("2. View movie details");
			System.out.println("3. Check seat availability and selection of seat/s.");
			System.out.println("4. Book and purchase ticket");
			System.out.println("5. View booking history");
			System.out.println("6. List the Top 5 ranking by ticket sales OR by overall reviewers’ ratings");
			System.out.println("7. Admin Login");
			System.out.println("8. Exit");
			System.out.print("Option > ");
			userOption = scanner.nextInt();
			
			switch(userOption) {
				case 1:
					break;
				case 2:
				String[][] movielist = getMovies();
				for(int row =0;row<movielist[0].length;row++)
				{
					for(int col  = 0;col <movielist.length;col ++)
					{
						if(movielist[col][row]!=null)
						{
							if(row==0)
							{
								System.out.print(movielist[col][row]+"\t");
							}
							else
							{
								System.out.print(movielist[col][row]+"\t \t");
							}
						}
					}
					System.out.print("\n");
				}
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					try {
						LoginModule.Login();
						
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
					System.out.println("   ______      __  __                   _______                  __                       ");
					System.out.println("  / ____/___ _/ /_/ /_  ____ ___  __   / ____(_)___  ___  ____  / /__  _  _____  _____    ");
					System.out.println(" / /   / __ `/ __/ __ \\/ __ `/ / / /  / /   / / __ \\/ _ \\/ __ \\/ / _ \\| |/_/ _ \\/ ___/   ");
					System.out.println("/ /___/ /_/ / /_/ / / / /_/ / /_/ /  / /___/ / / / /  __/ /_/ / /  __/>  </  __(__  )     ");
					System.out.println("\\____/\\__,_/\\__/_/ /_/\\__,_/\\__, /   \\____/_/_/ /_/\\___/ .___/_/\\___/_/|_|\\___/____/      ");
					System.out.println("                           /____/                     /_/                                 ");
					break;
				case 8:
					System.out.println("Goodbye!");	
					System.out.println("   ______      __  __                   _______                  __                       ");
					System.out.println("  / ____/___ _/ /_/ /_  ____ ___  __   / ____(_)___  ___  ____  / /__  _  _____  _____    ");
					System.out.println(" / /   / __ `/ __/ __ \\/ __ `/ / / /  / /   / / __ \\/ _ \\/ __ \\/ / _ \\| |/_/ _ \\/ ___/   ");
					System.out.println("/ /___/ /_/ / /_/ / / / /_/ / /_/ /  / /___/ / / / /  __/ /_/ / /  __/>  </  __(__  )     ");
					System.out.println("\\____/\\__,_/\\__/_/ /_/\\__,_/\\__, /   \\____/_/_/ /_/\\___/ .___/_/\\___/_/|_|\\___/____/      ");
					System.out.println("                           /____/                     /_/                                 ");
					break;
				default:
					System.out.println("Invalid Option!");
					System.out.println("Please re-enter!");
					break;
			
			}
		}
	}

}
