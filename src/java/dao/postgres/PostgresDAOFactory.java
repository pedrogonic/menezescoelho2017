package dao.postgres;

import dao.DAOFactory;
import java.sql.DriverManager;
import java.sql.SQLException;
import lib.Secret;


public class PostgresDAOFactory extends DAOFactory {
    
    private java.sql.Connection con;
    
    public PostgresDAOFactory() {
        try {
            con = getConnection();
        } catch (Exception e){}
    }
    
    private java.sql.Connection getConnection() throws Exception{
        try {
            Class.forName(Secret.POSTGRES_DRIVER);
            this.con = DriverManager.getConnection(Secret.POSTGRES_URL + Secret.POSTGRES_DBNAME
                    , Secret.POSTGRES_USERNAME
                    , Secret.POSTGRES_PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e) {
                throw e;
        }
        return con;
    }
    
    @Override
    public PostgresMessageDAO getMessageDAO() {
        return new PostgresMessageDAO(con);
    }
    
    @Override
    public PostgresUserDAO getUserDAO() {
        return new PostgresUserDAO(con);
    }
    
    @Override
    public void close() {
        try { if ( con != null ) { con.close(); } } catch(SQLException e) {} 
    }

}
