package services;

import dao.DAOFactory;
import dao.UserDAO;
import dto.Guest;
import dto.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class GuestServices {
    
    /**
     * Method for RSVPing
     * @param guests
     * @return true if OK, false otherwise
     */
    public static int rsvp(List<Guest> guests) {
        
        if (guests == null)
            return 0;
        
        try (DAOFactory daoFactory = DAOFactory.getDAOFactory()) { 
            
            guests = daoFactory.getGuestDAO().rsvp(guests);
            
            return guests == null ? 0 : guests.size();
            
        }
        
    }
    
    /**
     * Method for getting the guest list
     * @return 
     */
    public static List<Guest> getGuestList() {
        
        try (DAOFactory daoFactory = DAOFactory.getDAOFactory()) {
            
            List<Guest> guests = daoFactory.getGuestDAO().getList();
            
            UserDAO userDAO = daoFactory.getUserDAO();
            guests.forEach((guest) -> guest.setResponsible(userDAO.getUser(guest.getResponsible().getUserID())));
            
            return guests;
            
        }
        
    }
    
    /**
     * Method for printing the guest in console
     * @param guest 
     */
    public static void printGuest(Guest guest) {
        System.out.println(guest.getGuestName() + "," 
                                + guest.getResponsible().getUserName() + "," 
                                + guest.getResponsible().getFbUserID());
    }
    
    /**
     * Method from getting the list of guests from request
     * @param request
     * @return List of guests
     */
    public static List<Guest> getGuestsFromRequest(HttpServletRequest request) {
        
        User user = UserServices.getUserFromSession(request.getSession());
        
        if(user == null)
            return null;
        
        return splitGuests(new Guest(request.getParameter("guestsNames")
                                    , user.getUserID()
                                    , Boolean.parseBoolean(request.getParameter("attending"))));
        
    }
    
    /**
     * Method for splitting concatenated guests names from request
     * @return List of guests
     */
    private static List<Guest> splitGuests(Guest guest) {
        List<Guest> guests = new ArrayList<Guest>();

        for (String name : guest.getGuestName().split(";")) 
            guests.add(new Guest(name, guest.getUserID(), guest.isAttending()));

        return guests;
    
    }
    
}
