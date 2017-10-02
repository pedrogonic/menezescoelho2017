package dao.postgres;

import dao.BestPersonDAO;
import dto.BestPerson;

public class PostgresBestPersonDAO implements BestPersonDAO {
    
    private final java.sql.Connection con;
    
    public PostgresBestPersonDAO(java.sql.Connection con) { this.con = con; }
    
    @Override
    public BestPerson getBestPerson(String cod) {
        //TODO
        return null;
    }
    
}
