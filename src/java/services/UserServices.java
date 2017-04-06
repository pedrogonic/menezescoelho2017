package services;

import dao.DAOFactory;
import dao.UserDAO;
import dto.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserServices {
    
    public static User authenticate(User user) {
        
        UserDAO userDAO = DAOFactory.getDAOFactory().getUserDAO();
        return userDAO.insertUpdateUser(user);
        
    }
    
    public static User getUserFromRequest(HttpServletRequest request) {
        
        return  new User(request.getParameter("fbUserID")
                            , request.getParameter("fbName")
                            , request.getParameter("fbEmail")
                            , request.getParameter("fbUserImg"));
                
    }
    
    public static User getUserFromSession(HttpSession session) {
        
        return  new User(Integer.parseInt((String) session.getAttribute("userID"))
                            , (String) session.getAttribute("fbUserID")
                            , (String) session.getAttribute("fbName")
                            , (String) session.getAttribute("fbEmail")
                            , (String) session.getAttribute("fbUserImg"));
                
    }
    
    public static void setUserToSession(User user, HttpSession session) {
        
        session.setAttribute("userID", user.getUserID());
        session.setAttribute("fbUserID", user.getFbUserID());
        session.setAttribute("fbName", user.getUserName());
        session.setAttribute("fbEmail", user.getUserEmail());
        session.setAttribute("fbUserImg", user.getUserPicURL());
        
    }
    
}
