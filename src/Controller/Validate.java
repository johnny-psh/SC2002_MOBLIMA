package Controller;
import java.io.*;

import Model.Administrator;

public class Validate {

    public boolean valid = false;
    public String name;

    static String path = "./database/LoginDetails.csv";

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
