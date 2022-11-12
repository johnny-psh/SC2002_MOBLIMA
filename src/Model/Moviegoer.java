package Model;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Represents a viewer going to the movie; 
 * @author Group 6
 * @version 1.0
 * @since 12/11/2022
 */
public class Moviegoer {
    /*
    //If there is login
    private String mUser; //username
    private String mPass; //password 
    */
    /**
     * List of reviews by Moviegoer
     */
    private ArrayList<Review> glist = new ArrayList<Review>();

    //Moviegoer info
    /**
     * Name of this Moviegoer 
     */
    private String Name;
    /**
     * Email of this Moviegoer 
     */
    private String email;
    /**
     * Phone number of this Moviegoer
     */
    private int mobileNo;
    /**
     * Age of this Moviegoer
     */
    private int age;
    /**
     * Creates a new Moviegoer 
     * @param name Name of this Moviegoer
     * @param mobile Mobile number of this Moviegoer
     * @param mail Email of this Moviegoer
     * @param age Age of this Moviegoer
     */
    public Moviegoer(String name,int mobile,String mail,int age) {
        this.Name = name;
        this.mobileNo = mobile;
        this.email = mail;
        this.age = age;
    }
    /**
     * Adds review of this Moviegoer to list of reviews
     * @param g Review by this Moviegoer
     */
    public void join(Review g) {
		glist.add(g);  // partcipant note game's ref
	}
    /**
     * Display rating of movie by Moviegoer
     */
    public void printRating() {
		System.out.println(Name + " have this rating :");
		for (Review g : glist)
			System.out.println(this.Name + g.getRating() + "" + g.getDescription());
	}
    /**
     * Get name of this Moviegoer
     * @return Name of this
     */
    public String getName()
    {
        return this.Name;
    }
    /**
     * Sets the name of this Moviegoer
     * @param name Name of this Moviegoer
     */
    public void setName(String name)
    {
        this.Name = name;
    }
    /**
     * Gets the email of this Moviegoer
     * @return Email of this Moviegoer
     */
    public String getEmail()
    {
        return this.email;
    }
    /**
     * Set the email of this Moviegoer
     * @param email Email of this Moviegoer
     */
    public void setEmail(String email)
    {
        if(email != "")
        {
            String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if(matcher.matches())
            {
                this.email = email;
            }
            else
            {
                System.out.println("Invalid email or invalid email format");
            }
        }
        else
        {
            System.out.println("Empty Input");
        }
    }
    /**
     * Gets the phone number of this Moviegoer
     * @return Phone number of this Moviegoer
     */
    public int getPhone()
    {
        return this.mobileNo;
    }
    /**
     * Sets the phone number of this Moviegoer
     * @param pno Phone number of this Moviegoer
     */
    public void setPhone(int pno)
    {
        if(pno==0)
        {
        String regex = "(8|9)[0-9]{0,7}";
        Pattern pattern = Pattern.compile(regex);
        String newNo = Integer.toString(pno);
        Matcher matcher = pattern.matcher(newNo);
        if(matcher.matches())
        {
            this.mobileNo = pno;
        }
        else
        {
            System.out.println("Invalid SG Phone Number");
        }
        }
        else
        {
            System.out.println("Empty Input");
        }
    }
    /**
     * Get the age of this Moviegoer
     * @return Age of this Moviegoer
     */
    public int getAge()
    {
        return this.age;
    }
    /**
     * Set age of this Moviegoer
     * @param age Age of this Moviegoer
     */
    public void setAge(int age)
    {
        this.age = age;
    }
    
    
}
