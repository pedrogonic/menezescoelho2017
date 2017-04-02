package dao.postgres;

import dao.DAOFactory;
import java.sql.DriverManager;
import java.sql.SQLException;
import lib.Secret;

public class PostgresDAOFactory extends DAOFactory{
    
    public static java.sql.Connection getConnection() throws Exception{
        java.sql.Connection con;
        try {
            Class.forName(Secret.POSTGRES_DRIVER);
            con = DriverManager.getConnection(Secret.POSTGRES_URL + Secret.POSTGRES_DBNAME
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
        return new PostgresMessageDAO();
    }
    
    @Override
    public PostgresMessageDAO getMessageDAO(java.sql.Connection con) {
        return new PostgresMessageDAO(con);
    }
    
    @Override
    public PostgresUserDAO getUserDAO() {
        return new PostgresUserDAO();
    }
    
    @Override
    public PostgresUserDAO getUserDAO(java.sql.Connection con) {
        return new PostgresUserDAO(con);
    }
    
}
