import java.util.*;
public class TestUser {
    public static void main(String[] args) {
        Moviegoer test1 = new Moviegoer("Test", 97777777, "3332a", 33);
        Rating test3 = new Rating("I love this movie", 5);
        Rating test4 = new Rating("I jhat", 3);
        Moviegoer test2 = new Moviegoer("New", 97777777, "3332a", 33);
        Rating test5 = new Rating("Test22222", 1);
        Rating test6 = new Rating("Test11111", 2);

        test1.join(test3);
        test1.join(test4);

        test2.join(test5);
        test2.join(test6);

        test1.printRating();
        test2.printRating();
    }
}
