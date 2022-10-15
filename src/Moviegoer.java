public class Moviegoer {
    /*
    //If there is login
    private String mUser; //username
    private String mPass; //password 
    */

    //Moviegoer info
    private String Name,email;
    private int mobileNo,age;

    public Moviegoer(String name,int mobile,String mail,int age) {
        this.Name = name;
        this.mobileNo = mobile;
        this.email = mail;
        this.age = age;
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
