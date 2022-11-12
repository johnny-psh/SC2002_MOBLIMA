package View;
import java.io.IOException;
import java.util.*;

import Controller.Validate;
import Model.Administrator;
/**
 * Class of login module 
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class LoginModule {
    
    static Scanner sc = new Scanner(System.in);
    /**
     * Login method for admin account 
     * @throws IOException
     */
    public static void Login () throws IOException
    {
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        Administrator a = new Administrator(username, password);
        Validate v = new Validate();
        v.validateLogin(a);

        if(v.valid)
        {
            a.isValid(true, v.name);
            AdminModule.MenuPage(a);        
        }
        else
        {
            System.out.println("Invalid Credentials!");
        }
    }
}
