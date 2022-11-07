import java.util.ArrayList;
import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ViewMovieDetailUI {
     // Open CSV

	// Initialize Cineplexe object, Movie Object
	static XSSFRow row;
    
	public static String[][] getMovies() throws IOException {        
        FileInputStream fis = new FileInputStream(new File("./src/database/Movies.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        Iterator < Row >  rowIterator = spreadsheet.iterator();
        int tRow=0;
        int tCol=0;
		//if add row/col , just change here [row][col]
        String[][] TitleTest = new String[100][100];

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
		workbook.close(); 
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
	
    public static void printArr(String[][] movielist)
	{
		for(int row =0;row<movielist[0].length;row++)
				{
					for(int col  = 0;col <movielist.length;col ++)
					{
						if(movielist[col][row]!=null)
						{
							if(row==0)
							{
								System.out.print(movielist[col][row]+"\t \t");
							}
							else
							{
								System.out.print(movielist[col][row]+"\t \t");
							}
						}
					}
					System.out.print("\n");
				}
		System.out.print("\n");
	}

    public static void displayMenu() throws IOException{
        String[][] getList = getMovies();
        printArr(getList);
        MainMenuUI.displayMenu();   
    }
}


