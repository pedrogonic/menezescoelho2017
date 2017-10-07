package dto;

import java.util.ArrayList;
import java.util.List;

public class Guest {
    
    private int guestID;
    private String guestName;
    private String userID;

    
    /**
     * Full constructor
     * @param guestID
     * @param guestName
     * @param userID 
     */
    public Guest(int guestID, String guestName, String userID) {
        this.guestID = guestID;
        this.guestName = guestName;
        this.userID = userID;
    }

    /**
     * Constructor for new guests
     * @param guestID
     * @param guestName
     * @param userID 
     */
     public Guest(String guestName, String userID) {
        this.guestName = guestName;
        this.userID = userID;
    }
    
    public int getGuestID() {
        return guestID;
    }

    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
}
