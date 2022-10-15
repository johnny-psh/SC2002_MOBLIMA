import java.util.*;
public class TestUser {
    public static void main(String[] args) {
        Moviegoer test1 = new Moviegoer("Test", 97777777, "3332a", 33);
        Rating test3 = new Rating("I love this movie", 5);
        Rating test4 = new Rating("I jhat", 3);

        test1.join(test3);
        test1.join(test4);

        test1.printRating();
    }
}
