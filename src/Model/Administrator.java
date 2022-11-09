package Model;
public class Administrator {
    public String userName;
    public String passWord;
    public Boolean isValid;
    public String name;

    public Administrator(String userName, String passWord)
    {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public String getPassword()
    {
        return this.passWord;
    }

    public void isValid(Boolean isValid, String name)
    {
        this.isValid = isValid;
        this.name = name;
    }

    public boolean getValid()
    {
        return this.isValid;
    }



    
}
