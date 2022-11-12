package Model; 

/**
 * Represents the Administrator of the app
 * @author Group 6
 * @version 1.0
 * @since 6/11/2022
 */
public class Administrator {
    /**
     * User name of this Administrator 
     */
    private String userName;
    /**
     * Password of Administrator account 
     */
    private String passWord;
    /**
     * Boolean to indicate Administrator accound is valid
     */
    private Boolean isValid;
    /**
     * Name of admin
     */
    private String name;
    /**
     * Creates a new Administrator 
     * @param userName Name of Administrator
     * @param passWord Password of Administrator account 
     */
    public Administrator(String userName, String passWord)
    {
        this.userName = userName;
        this.passWord = passWord;
    }
    /**
     * Get the user name of this Administrator 
     * @return This Administrator user name
     */
    public String getUserName()
    {
        return this.userName;
    }
    /**
     * Get password of this Administrator account
     * @return This Administrator password
     */
    public String getPassword()
    {
        return this.passWord;
    }
    /**
     * Method to check if account is valid 
     * @param isValid Validity boolean 
     * @param name Name of admin
     */
    public void isValid(Boolean isValid, String name)
    {
        this.isValid = isValid;
        this.name = name;
    }
    /**
     * Get validity of this Administrator account
     * @return Validity of this Administrator
     */
    public boolean getValid()
    {
        return this.isValid;
    }



    
}
