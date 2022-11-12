package Model;

/**
 * Represents the ratings and review of a movie by moviegoer
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class Review {

    /* This class is called using <addReview> function of <Movie> class */
    /**
     * Worded portion of this Review
     */
    private String description;
    /**
     * Numerical portion of this Review
     */
    private int rating;
    /**
     * Creates a new Reivew
     * @param description Worded portion of this Review
     * @param rating Numerical portion of this Review
     */
    public Review(String description, int rating)
    {
        this.description = description;
        this.rating = rating;
    }
    /**
     * Get numerical portion of this Review
     * @return Numerical portion of this Review
     */
    public int getRating()
    {
        return this.rating;
    }
    /**
     * Get worded portion of this Review
     * @return Worded portion of this Review
     */
    public String getDescription()
    {
        return this.description;
    }
}
