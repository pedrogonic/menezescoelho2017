package dto;

import java.time.LocalDateTime;

public class Message {
    
    private int messageID;
    private String color;
    private String body;
    private String reply;
    private User user;
    private LocalDateTime time;

    public static enum DeleteResult{
        DELETED, NOT_DELETED, DENIED 
    }
    
    public Message() {}

    public Message(int messageID, String color
            , String body, String reply, LocalDateTime time) {
        this.messageID = messageID;
        this.color = color;
        this.body = body;
        this.reply = reply;
        this.time = time;
    }
    
    public Message(int messageID, User user) {
        this.messageID = messageID;
        this.user = user;
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
}