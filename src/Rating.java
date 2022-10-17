public class Rating {
    private String description;
    private int overallRating;
    /* 
    private Moviegoer user;

    public Rating(Moviegoer t)
    {
        user = t;
    } */

    public Rating(String desc,int rating)
    {
        //this.user = t;
        this.description = desc;
        this.overallRating = rating;
    }
    public int getRating()
    {
        return this.overallRating;
    }
    public String getdescription()
    {
        return this.description;
    }
   


}
