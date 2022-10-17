import java.util.*;
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
    public String getEmail()
    {
        return this.email;
    }
    public int getPhone()
    {
        return this.mobileNo;
    }

    public int getAge()
    {
        return this.age;
    }
    
    
}
