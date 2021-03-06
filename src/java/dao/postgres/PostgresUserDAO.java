package dao.postgres;

import dao.UserDAO;
import dto.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import lib.Secret;


@SuppressWarnings("CallToPrintStackTrace")
public class PostgresUserDAO implements UserDAO {
    
    private final java.sql.Connection con;
    
    public PostgresUserDAO(java.sql.Connection con) { this.con = con; }
    
    @Override
    public User insertUpdateUser(User user) {
        
        PreparedStatement ps = null;
        
        try {
            
            User existingUser = getUserByFBID(user.getFbUserID());
            
            if (existingUser != null) {
                
                //UPDATE
                String query = "UPDATE " + Secret.USERS_TABLE
                            + " SET fbUserID = ?"
                            + " ,userName = ?"
                            + " ,userEmail = ?"
                            + " ,userPicURL = ?"
                            + " WHERE userID = ?;";
                
                ps = con.prepareStatement(query);
                ps.setString(1, user.getFbUserID());
                ps.setString(2, user.getUserName());
                ps.setString(3, user.getUserEmail());
                ps.setString(4, user.getUserPicURL());
                ps.setObject(5, UUID.fromString(existingUser.getUserID()));
                ps.executeUpdate();
            
                user.setUserID(existingUser.getUserID());
                
            } else {
                
                //INSERT
                String query = "INSERT INTO " + Secret.USERS_TABLE
                            + " (fbUserID"
                            + " ,userName"
                            + " ,userEmail"
                            + " ,userPicURL)"
                            + " VALUES (?,?,?,?);";

                ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getFbUserID());
                ps.setString(2, user.getUserName());
                ps.setString(3, user.getUserEmail());
                ps.setString(4, user.getUserPicURL());
                ps.executeUpdate();

                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        user.setUserID(generatedKeys.getString(1));
                    }else {
                        throw new SQLException("Failed to get generated ID for User.");
                    }
                }
                
            }
            
            ps.close();
            
            String query = "INSERT INTO " + Secret.LOGIN_TABLE
                            + " (userID)"
                            + " VALUES (?);";
            
            ps = con.prepareStatement(query);
            ps.setObject(1, UUID.fromString(user.getUserID()));
            ps.executeUpdate();

        } catch (SQLException e) { e.printStackTrace(); }
        finally {
            if (ps != null) { try {ps.close();}catch(SQLException e){}}
        }
        
        return user;
    }
    
     @Override
    public User getUser(String userID) {
        
        User user = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            String query = "SELECT * FROM " + Secret.USERS_TABLE
                        + " WHERE userID = ?;";
            
            ps = con.prepareStatement(query);
            ps.setObject(1, UUID.fromString(userID));
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                user = new User(rs.getString(1), rs.getString(2), rs.getString(3)
                        , rs.getString(4), rs.getString(5));
            }
            
        } catch (SQLException e) { e.printStackTrace(); }
        finally {
            if (ps != null) { try {ps.close();}catch(SQLException e){}}
            if (rs != null) { try {rs.close();}catch(SQLException e){}}
        }
        
        return user;
        
    }
    
    @Override
    public User getUserByFBID(String fbUserID) {
        
        User user = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            String query = "SELECT * FROM " + Secret.USERS_TABLE
                        + " WHERE fbUserID = ?;";
            
            ps = con.prepareStatement(query);
            ps.setString(1, fbUserID);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                user = new User(rs.getString(1), rs.getString(2), rs.getString(3)
                        , rs.getString(4), rs.getString(5));
            }
            
        } catch (SQLException e) { e.printStackTrace(); }
        finally {
            if (ps != null) { try {ps.close();}catch(SQLException e){}}
            if (rs != null) { try {rs.close();}catch(SQLException e){}}
        }
        
        return user;
        
    }
    
}
