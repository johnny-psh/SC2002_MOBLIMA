import java.io.*;

public class Validate {

    public boolean valid = false;
    public String name;

    //static String path = "/Users/periadhityan/Documents/GitHub/SC2002_Assignment/src/database/LoginDetails.csv";
    static String path = "./src/database/LoginDetails.csv";

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return valid;
    }


    
}
