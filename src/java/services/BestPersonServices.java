package services;

import dao.DAOFactory;
import dto.BestPerson;
import java.util.List;

public class BestPersonServices {
    
    /**
     * Method for getting all bestmen
     * @return 
     */
    public static List<BestPerson> getList() {
        
        try (DAOFactory daoFactory = DAOFactory.getDAOFactory()) { 
            
            return daoFactory.getBestPersonDAO().getList();
            
        }
        
    }
    
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
