package dao.postgres;

import dao.MessageDAO;
import dto.Message;
import dto.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lib.Secret;


@SuppressWarnings("CallToPrintStackTrace")
public class PostgresMessageDAO implements MessageDAO {

    private final java.sql.Connection con;
    
    public PostgresMessageDAO(java.sql.Connection con) { this.con = con; }
    
    @Override
    public Message insertUpdateMessage(Message message){
       
        PreparedStatement ps = null;

        try {
            
            if (message.getMessageID() == 0) {
            
                //INSERT
                String query = "INSERT INTO " + Secret.MESSAGES_TABLE
                                + " (userID"
                                + " ,color"
                                + " ,body)"
                                + " VALUES (?,?,?);";

                ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, message.getUser().getUserID());
                ps.setString(2, message.getColor());
                ps.setString(3, message.getBody());
                ps.executeUpdate();

                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        message.setMessageID(generatedKeys.getInt(1));
                    }else {
                        throw new SQLException("Failed to get generated ID for Message.");
                    }
                }

            } else {
                
                //UPDATE
                String query = "UPDATE " + Secret.MESSAGES_TABLE + " SET"
                                + " color = ?"
                                + " ,body = ?"
                                + " ,reply = ?)"
                                + " WHERE messageID = ?;";
                
                ps = con.prepareStatement(query);
                ps.setString(1, message.getColor());
                ps.setString(2, message.getBody());
                ps.setString(3, message.getReply());
                ps.setInt(4, message.getMessageID());
                ps.executeUpdate();
                
            }
                
        } catch (SQLException e) { e.printStackTrace(); }
        finally {
            if (ps != null) { try {ps.close();}catch(SQLException e){}}
        }
        
        return message;
        
    }
    
    @Override
    public Message.DeleteResult deleteMessage(Message message) {
        
        Message candidateMessage = getMessage(message.getMessageID());
        
        if (message.getUser().getUserID() != candidateMessage.getUser().getUserID())
            return Message.DeleteResult.DENIED;
        else {
            
            PreparedStatement ps = null;
            
            try {
                
                String query = "DELETE FROM " + Secret.MESSAGES_TABLE
                            + " WHERE messageID = ?;";
                
                ps = con.prepareStatement(query);
                ps.setInt(1, message.getMessageID());
                if (ps.executeUpdate() > 0)
                    return Message.DeleteResult.DELETED;
                
            } catch (SQLException e) { e.printStackTrace(); }
            finally {
                if (ps != null) { try {ps.close();}catch(SQLException e){}}
            }
            
        }
        
        return Message.DeleteResult.NOT_DELETED;
        
    }
    
    @Override
    public Message getMessage(int messageID) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Message message = null;
        
        try {
            
            String query = "SELECT (" 
                            + " userID"
                            + " ,color"
                            + " ,body"
                            + " ,reply"
                            + " ,messageTime"
                            + ") FROM " + Secret.MESSAGES_TABLE
                            + " WHERE messageID = ?;";
            
            ps = con.prepareStatement(query);
            ps.setInt(1, messageID);
            rs = ps.executeQuery();
            
            while ( rs.next() ) {
                message = new Message(
                                    messageID
                                    , new User(rs.getInt(1))
                                    , rs.getString(2)
                                    , rs.getString(3)
                                    , rs.getString(4)
                                    , rs.getTimestamp(5).toLocalDateTime()
                                );
            }
                
        } catch (SQLException e) { e.printStackTrace(); }
        finally {
            if (ps != null) { try {ps.close();}catch(SQLException e){}}
            if (rs != null) { try {rs.close();}catch(SQLException e){}}
        }
        
        return message;
        
    }
    
    @Override
    public List<Message> getAllMessages() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Message> list = new ArrayList<>();
        
        try {
            
            String query = "SELECT (" 
                            + " messageID"
                            + " ,userID"
                            + " ,color"
                            + " ,body"
                            + " ,reply"
                            + " ,messageTime"
                            + ") FROM " + Secret.MESSAGES_TABLE + ";";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while ( rs.next() ) {
                list.add(new Message(
                                    rs.getInt(1)
                                    , new User(rs.getInt(2))
                                    , rs.getString(3)
                                    , rs.getString(4)
                                    , rs.getString(5)
                                    , rs.getTimestamp(6).toLocalDateTime()
                                ));
            }
            
        } catch (SQLException e) { e.printStackTrace(); }
        finally {
            if (ps != null) { try {ps.close();}catch(SQLException e){}}
            if (rs != null) { try {rs.close();}catch(SQLException e){}}
        }
        
        return list;
    }
    
    @Override
    public void close() {
        try { if(con != null) {con.close();} } catch(SQLException e) {e.printStackTrace();}
    }
    
}
