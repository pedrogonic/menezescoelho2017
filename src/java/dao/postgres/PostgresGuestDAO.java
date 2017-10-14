package dao.postgres;

import dao.GuestDAO;
import dto.Guest;
import dto.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lib.Secret;

@SuppressWarnings("CallToPrintStackTrace")
public class PostgresGuestDAO implements GuestDAO{
    
    private final java.sql.Connection con;
    
    public PostgresGuestDAO(java.sql.Connection con) { this.con = con; }
    
    @Override
    public List<Guest> rsvp(List<Guest> guests){
        
        PreparedStatement ps = null;
        boolean ok = true;
        
        try {
            
            for (Guest guest : guests) {
            
                String query = "INSERT INTO " + Secret.GUEST_TABLE 
                                + " (guestname"
                                + " ,userid"
                                + " ,attending) "
                                + " VALUES (?,?,?);";

                ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, guest.getGuestName());
                ps.setObject(2, UUID.fromString(guest.getUserID()));
                ps.setBoolean(3, guest.isAttending());
                ps.executeUpdate();
                
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        guest.setGuestID(generatedKeys.getInt(1));
                    }else {
                        ok = false;
                        throw new SQLException("Failed to get generated ID for Guest.");
                    }
                }
                    
            }
            
        } catch (SQLException e) { ok = false; e.printStackTrace(); }
        finally {
            if (ps != null) { try {ps.close();}catch(SQLException e){}}
        }
        
        if (ok)
            return guests;
        else
            return null;
    }
    
    @Override
    public List<Guest> getList() {
        
        PreparedStatement ps = null;
        ResultSet rs;
        List<Guest> guests = new ArrayList<>();
        
        try {
            
            
            String query = "select  \n" +
                            "guestID \n" +
                            ",guestname \n" +
                            ",userid\n" +
                            "from " + Secret.GUEST_TABLE + ";";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()) {
                guests.add(new Guest(rs.getInt(1),
                                    rs.getString(2),
                                    new User(rs.getString(3))));
            }
                    
            
        } catch (SQLException e) { e.printStackTrace(); }
        finally {
            if (ps != null) { try {ps.close();}catch(SQLException e){}}
        }
        
        return guests;
        
    }
    
}
