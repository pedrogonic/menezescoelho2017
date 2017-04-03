package dao;

import dao.postgres.PostgresDAOFactory;
import lib.Utils;

public abstract class DAOFactory {
    
    public enum Type {
        POSTGRES ("Postgres");
        
        private final String typeName;
        
        private Type(String typeName) { this.typeName = typeName;}
        
        public String getTypeName() { return typeName; }
        
    }
    
    public static DAOFactory getDAOFactory() {
        return getDAOFactory(Utils.DEFAULT_DB);
    }
    
    public static DAOFactory getDAOFactory(Type type){
    
        switch(type) {
            default:
                return new PostgresDAOFactory();
        }
        
    }
    
    public abstract MessageDAO getMessageDAO();
    
    public abstract MessageDAO getMessageDAO(java.sql.Connection con);
    
    public abstract UserDAO getUserDAO();
    
    public abstract UserDAO getUserDAO(java.sql.Connection con);
    
}
