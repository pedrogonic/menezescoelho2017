package dto;

import java.time.LocalDateTime;

public class Message {
    
    private String messageID = "";
    private User user;
    private String color;
    private String body;
    private String reply;
    private LocalDateTime time;
    private boolean trashable = false;

    public static enum DeleteResult {
        DELETED, NOT_DELETED, DENIED 
    }
    
    public static enum PostMethod implements AutoCloseable {
        POST_MESSAGE("post"), REPLY_MESSAGE("reply"), TRASH("trash");
        
        private final String methodName;
        
        private PostMethod(String methodName) { this.methodName = methodName;}
        
        public static PostMethod fromString(String text) {
            
            for (PostMethod p : PostMethod.values()) {
                if (p.getMethodName().equalsIgnoreCase(text)) {
                    return p;
                }
            }
            return null;
        
        }
        
        public String getMethodName() { return this.methodName; }
        
        @Override
        public void close() {}
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
    public Message(String messageID, User user, String color
            , String body, String reply, LocalDateTime time) {
        this.messageID = messageID;
        this.user = user;
        this.color = color;
        this.body = body;
        this.reply = reply;
        this.time = time;
    }
    
    /**
     * Constructor for posting a message
     * @param user
     * @param color
     * @param body 
     */
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
    public Message(String messageID, User user) {
        this.messageID = messageID;
        this.user = user;
    }
    
    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
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
    
    public boolean setTrashable(Message msg) {
        if (msg != null)
            this.trashable = (this.messageID.equals(msg.getMessageID()) 
                    && this.getUser().getUserID().equals(msg.getUser().getUserID()));
        return this.trashable;
    }
    
    public boolean setTrashable(User user) {
        if (user != null)
            this.trashable = (this.getUser().getUserID().equals(user.getUserID()));
        return this.trashable;
    }
    
}
