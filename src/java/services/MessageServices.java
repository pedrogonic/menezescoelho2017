package services;

import dao.DAOFactory;
import dao.MessageDAO;
import dao.UserDAO;
import dto.Message;
import dto.User;
import java.util.List;

public class MessageServices {
     
    /**
     * 
     * @return list of all messages
     */
    public static List<Message> getAllMessages() {
        
        DAOFactory daoFactory = DAOFactory.getDAOFactory();
        
        MessageDAO messageDAO = daoFactory.getMessageDAO();
        List<Message> list = messageDAO.getAllMessages();
        
        UserDAO userDAO = daoFactory.getUserDAO();
        list.forEach((msg) -> { msg.setUser(userDAO.getUser(msg.getUser().getUserID())); });
        
        return list;
        
    }
    
    /**
     * 
     * @param user
     * @return list of all messages with the boolean trashable set
     */
    public static List<Message> getAllMessages(User user) {
        
        List<Message> list = getAllMessages();
        list.forEach((msg) -> { msg.isTrashable(user); });
        return list;
        
    }

}
