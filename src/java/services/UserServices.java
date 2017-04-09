package services;

import dao.DAOFactory;
import dao.UserDAO;
import dto.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserServices {
    
    /**
     * Inserts or updates user to DB and save login time.
     * @param user
     * @return user with userID
     */
    public static User authenticate(User user) {
        
        UserDAO userDAO = DAOFactory.getDAOFactory().getUserDAO();
        return userDAO.insertUpdateUser(user);
        
    }
    
    /**
     * Utility user method to get the object from request parameters.
     * Used when authenticating and it is unknown if the user is already on DB.
     * @param request
     * @return user
     */
    public static User getUserFromRequest(HttpServletRequest request) {
        
        return  new User(request.getParameter("fbUserID")
                            , request.getParameter("fbName")
                            , request.getParameter("fbEmail")
                            , request.getParameter("fbUserImg"));
                
    }
    
    /**
     * Utility user method to get the object from the session.
     * Used when the object attributes are already on session.
     * @param session
     * @return user
     */
    public static User getUserFromSession(HttpSession session) {
        
        Integer userID = (Integer) session.getAttribute("userID");
        
        if ( userID != null ) {
        
            return  new User(userID
                                , (String) session.getAttribute("fbUserID")
                                , (String) session.getAttribute("fbName")
                                , (String) session.getAttribute("fbEmail")
                                , (String) session.getAttribute("fbUserImg"));
        } else return null;
                
    }
    
    /**
     * Utility user method to save object's attributes to session.
     * Used after authentication.
     * @param user
     * @param session 
     */
    public static void setUserParamsToSession(User user, HttpSession session) {
        
        session.setAttribute("userID", user.getUserID());
        session.setAttribute("fbUserID", user.getFbUserID());
        session.setAttribute("fbName", user.getUserName());
        session.setAttribute("fbEmail", user.getUserEmail());
        session.setAttribute("fbUserImg", user.getUserPicURL());
        
    }
    
}
