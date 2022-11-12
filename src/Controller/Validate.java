package Controller;
import java.io.*;

import Model.Administrator;
/**
 * Class to validare administrator account 
 * @author Group 6 
 * @version 1.0
 * @since 12/11/2022
 */
public class Validate {
    /**
     * Validating boolean 
     */
    public boolean valid = false;
    /**
     * Name of account 
     */
    public String name;
    /**
     * File path
     */
    static String path = "./database/LoginDetails.csv";
    /**
     * Method to validate account login 
     * @param a Administrator account 
     * @return Validation True or False
     */
    public boolean validateLogin(Administrator a)
    {

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";
            while((line = br.readLine()) != null)
            {
                String values[] = line.split(",");
                if(a.userName.compareTo(values[1].replaceAll("\\s", ""))==0)
                {
                    if(a.passWord.compareTo(values[2].replaceAll("\\s", ""))==0)
                    {
                        valid = true;
                        name = values[0];
                    }
                }
                
            } br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return valid;
    }


    
}
