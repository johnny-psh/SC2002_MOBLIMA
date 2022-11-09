package Model;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Moviegoer {
    /*
    //If there is login
    private String mUser; //username
    private String mPass; //password 
    */
    private ArrayList<Review> glist = new ArrayList<Review>();

    //Moviegoer info
    private String Name,email;
    private int mobileNo,age;

    public Moviegoer(String name,int mobile,String mail,int age) {
        this.Name = name;
        this.mobileNo = mobile;
        this.email = mail;
        this.age = age;
    }

    public void join(Review g) {
		glist.add(g);  // partcipant note game's ref
	}

    public void printRating() {
		System.out.println(Name + " have this rating :");
		for (Review g : glist)
			System.out.println(this.Name + g.getRating() + "" + g.getDescription());
	}

    public String getName()
    {
        return this.Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public String getEmail()
    {
        return this.email;
    }

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

    public int getPhone()
    {
        return this.mobileNo;
    }

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

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
    
    
}
