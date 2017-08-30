package services;

import dao.DAOFactory;
import dto.BestPerson;

public class BestPersonServices {
    
    /**
     * Method for getting Best Person information from BD
     * @param cod
     * @return Best Person object or null if code is not registered
     */
    public static BestPerson getBestPerson(String cod){
        
        try (DAOFactory daoFactory = DAOFactory.getDAOFactory()) { 
            
            return daoFactory.getBestPersonDAO().getBestPerson(cod);
        
        }
        
    }
    
}
