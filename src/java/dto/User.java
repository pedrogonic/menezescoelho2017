package dto;

public class User {
    
    private String userID = "";
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
    public User(String userID, String fbUserID, String userName
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
    public User(String userID) {
        this.userID = userID;
    }
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
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
