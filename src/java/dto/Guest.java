package dto;

import java.util.ArrayList;
import java.util.List;

public class Guest {
    
    private int guestID;
    private String guestName;
    private String userID;
    private User responsible;
    private boolean attending;

    
    /**
     * Full constructor
     * @param guestID
     * @param guestName
     * @param userID 
     */
    public Guest(int guestID, String guestName, String userID, boolean attending) {
        this.guestID = guestID;
        this.guestName = guestName;
        this.userID = userID;
        this.attending = attending;
    }

    /**
     * Constructor for new guests
     * @param guestID
     * @param guestName
     * @param userID 
     */
     public Guest(String guestName, String userID, boolean attending) {
        this.guestName = guestName;
        this.userID = userID;
        this.attending = attending;
    }

    /**
     * Constructor for guest list
     * @param guestID
     * @param guestName
     * @param responsible 
     */
    public Guest(int guestID, String guestName, User responsible, boolean attending) {
        this.guestID = guestID;
        this.guestName = guestName;
        this.responsible = responsible;
        this.attending = attending;
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

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public boolean isAttending() {
        return attending;
    }

    public void setAttending(boolean attending) {
        this.attending = attending;
    }
 
    
    
}
