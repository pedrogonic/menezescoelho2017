package dao;

import dto.Message;
import dto.User;
import java.util.List;

public interface MessageDAO extends AutoCloseable {
    
    public int insertMessage(Message message);
    public Message.DeleteResult deleteMessage(Message message);
    public Message getMessage(int id);
    public List<Message> getAllMessages();
    
    @Override
    public void close();
    
}
