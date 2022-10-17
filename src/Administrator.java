public class Administrator {
    public String userName;
    public String passWord;
    public Boolean isValid;

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

    public void isValid(Boolean isValid)
    {
        this.isValid = isValid;
    }



    
}
