package services;

import dao.DAOFactory;
import dao.MessageDAO;
import dao.UserDAO;
import dto.Message;
import dto.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class MessageServices {
    
    /**
     * Method for posting or replying.
     * @param message to be inserted or updated
     * @return complete message object inserted/updated
     */
    public static Message postMessage(Message message) {
        
        try (DAOFactory daoFactory = DAOFactory.getDAOFactory()) { 
            
            return daoFactory.getMessageDAO().insertUpdateMessage(message);
        
        }
        
    }
    
    /**
     * Method for deleting a message
     * @param message
     * @return enum object representing result of deletion
     */
    public static Message.DeleteResult trashMessage(Message message) {
        
        try (DAOFactory daoFactory = DAOFactory.getDAOFactory()) { 
        
            return daoFactory.getMessageDAO().deleteMessage(message);
        
        }
        
    }
    
    /**
     * Get all messages without a login.
     * @return list of all messages
     */
    private static List<Message> getAllMessages() {
        
        try (DAOFactory daoFactory = DAOFactory.getDAOFactory()) { 
        
            MessageDAO messageDAO = daoFactory.getMessageDAO();
            List<Message> list = messageDAO.getAllMessages();

            UserDAO userDAO = daoFactory.getUserDAO();
            list.forEach((msg) -> { msg.setUser(userDAO.getUser(msg.getUser().getUserID())); });

            return list;
            
        }
        
    }
    
    /**
     * Get all messages, indicating each of the logged user's messages, 
     * allowing them to trash them
     * @param user
     * @return list of all messages with the boolean trashable set
     */
    public static List<Message> getAllMessages(User user) {
        
        List<Message> list = getAllMessages();
        list.forEach((msg) -> { msg.setTrashable(user); });
        return list;
        
    }

    /**
     * Utility message method to get the object from request parameters.
     * Used to get message from request and insert/delete it.
     * @param request
     * @return message
     */
    public static Message getMessageFromRequest(HttpServletRequest request) {

        String body = request.getParameter("body");
        String reply = request.getParameter("reply");
        String messageID = request.getParameter("messageID");
        User user = UserServices.getUserFromSession(request.getSession());
        
        if ( body != null && !body.equals("") ) {
            
            // POST
            return new Message(user
                                , request.getParameter("color")
                                , request.getParameter("body")
                        );
            
        } else if ( reply != null && !reply.equals("") ) {
            
            // REPLY
            Message message = DAOFactory.getDAOFactory().getMessageDAO()
                    .getMessage(messageID);
            message.setReply(reply);
            
            return message;
            
        } else if ( messageID != null && !messageID.equals("") ) {
            
            // TRASHING
            return new Message(messageID, user);
            
        } else return null;
                
    }
    
    /**
     * Utility message method to set a posted or replied message to session.
     * @param message
     * @param method -> modifier to name of attribute set in session
     * @param session
     */
    public static void setMessageToSession(Message message, Message.PostMethod method, HttpSession session) {
        
        session.setAttribute(method.getMethodName() + "Message", message);
        
    }
    
    public static Message getMessageFromSession(Message.PostMethod method, HttpSession session) {
        
        Message message = (Message) session.getAttribute(method.getMethodName() + "Message");
        session.removeAttribute(method.getMethodName() + "Message");
        return message;
        
    }
    
}
