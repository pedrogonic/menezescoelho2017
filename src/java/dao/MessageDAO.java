package dao;

import dto.Message;
import java.util.List;

public interface MessageDAO extends AutoCloseable {
    
    public Message insertUpdateMessage(Message message);
    public Message.DeleteResult deleteMessage(Message message);
    public Message getMessage(String id);
    public List<Message> getAllMessages();
    
    @Override
    public void close();
    
}
