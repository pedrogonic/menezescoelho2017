package dto;

public class User {
    
    private int userID = 0;
    private String fbUserID;
    private String userName;
    private String userEmail;
    private String userPicURL;
    

    /**
     * Full constructor
     * @param userID
     * @param fbUserID
     * @param userName
     * @param userEmail
     * @param userPicURL 
     */
    public User(int userID, String fbUserID, String userName
            , String userEmail, String userPicURL) {
        this.userID = userID;
        this.fbUserID = fbUserID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPicURL = userPicURL;
    }

    /**
     * Constructor for creating a new user
     * @param fbUserID
     * @param userName
     * @param userEmail
     * @param userPicURL 
     */
    public User(String fbUserID, String userName
            , String userEmail, String userPicURL) {
        this.fbUserID = fbUserID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPicURL = userPicURL;
    }
    
    /**
     * Constructor for creating and deleting a message
     * @param userID
     */
    public User(int userID) {
        this.userID = userID;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFbUserID() {
        return fbUserID;
    }

    public void setFbUserID(String fbUserID) {
        this.fbUserID = fbUserID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPicURL() {
        return userPicURL;
    }

    public void setUserPicURL(String userPicURL) {
        this.userPicURL = userPicURL;
    }
    
}
