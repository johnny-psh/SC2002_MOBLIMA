import java.util.*;

public class LoginModule {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main (String[] args)
    {
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        Administrator a = new Administrator(username, password);
        Validate v = new Validate();
        System.out.println(v.validateLogin(a));
    }
}
