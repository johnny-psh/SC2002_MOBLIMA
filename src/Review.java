public class Review {

    /* This class is called using <addReview> function of <Movie> class */

    private String description;
    private int rating;

    public Review(String description, int rating)
    {
        this.description = description;
        this.rating = rating;
    }

    public int getRating()
    {
        return this.rating;
    }
    
    public String getDescription()
    {
        return this.description;
    }
}
