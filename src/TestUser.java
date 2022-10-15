import java.util.Scanner;
public class TestUser {
    public static void main(String[] args) {
        Moviegoer test1 = new Moviegoer("Test", 97777777, "3332a", 33);
        Rating test2 = new Rating("Test", 5, test1);

        System.out.println(test1.getName() + " " + test1.getEmail());
        System.out.println(test2.getRating() + " " + test2.getdescription());
    }
}
