import java.util.*;

public class LoginModule {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void Login ()
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
