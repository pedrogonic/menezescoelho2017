package dao;

import dto.Message;
import java.util.List;

public interface MessageDAO {
    
    public Message insertUpdateMessage(Message message);
    public Message.DeleteResult deleteMessage(Message message);
    public Message getMessage(String id);
    public List<Message> getAllMessages();
    
}
