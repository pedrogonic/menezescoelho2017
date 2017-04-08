package dto;

import java.time.LocalDateTime;

public class Message {
    
    private int messageID = 0;
    private User user;
    private String color;
    private String body;
    private String reply;
    private LocalDateTime time;
    private boolean trashable;

    public static enum DeleteResult{
        DELETED, NOT_DELETED, DENIED 
    }
    
    
    public Message() {}

    /**
     * Full constructor
     * @param messageID
     * @param user
     * @param color
     * @param body
     * @param reply
     * @param time 
     */
    public Message(int messageID, User user, String color
            , String body, String reply, LocalDateTime time) {
        this.messageID = messageID;
        this.user = user;
        this.color = color;
        this.body = body;
        this.reply = reply;
        this.time = time;
    }
    
    public Message(User user, String color, String body) {
        this.user = user;
        this.color = color;
        this.body = body;
    }
     
    /**
     * Constructor for deleting a message
     * @param messageID
     * @param user 
     */
    public Message(int messageID, User user) {
        this.messageID = messageID;
        this.user = user;
    }

    public boolean isTrashable(Message msg) {
        this.trashable = (this.messageID == msg.getMessageID() 
                && this.getUser().getUserID() == msg.getUser().getUserID());
        return this.trashable;
    }
    
    public boolean isTrashable(User user) {
        this.trashable = (this.getUser().getUserID() == user.getUserID());
        return this.trashable;
    }
    
    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean isTrashable() {
        return trashable;
    }

    public void setTrashable(boolean trashable) {
        this.trashable = trashable;
    }
    
}
