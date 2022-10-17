import java.util.*;
public class TestUser {
    public static void main(String[] args) {
        Moviegoer test1 = new Moviegoer("Test", 97777777, "3332a", 33);
        Review test3 = new Review("I love this movie", 5);
        Review test4 = new Review("I jhat", 3);
        Moviegoer test2 = new Moviegoer("New", 97777777, "3332a", 33);
        Review test5 = new Review("Test22222", 1);
        Review test6 = new Review("Test11111", 2);

        test1.join(test3);
        test1.join(test4);

        test2.join(test5);
        test2.join(test6);

        test1.printRating();
        test2.printRating();
    }
}
