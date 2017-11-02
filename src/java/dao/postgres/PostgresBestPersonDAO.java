package dao.postgres;

import dao.BestPersonDAO;
import dto.BestPerson;
import dto.Guest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lib.Secret;

public class PostgresBestPersonDAO implements BestPersonDAO {
    
    private final java.sql.Connection con;
    
    public PostgresBestPersonDAO(java.sql.Connection con) { this.con = con; }
    
    @Override
    public List<BestPerson> getList() {
        ArrayList<BestPerson> list = new ArrayList();
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            
            
            String query = "SELECT honorID,\n"
                            + "honorName,\n"
                            + "honorNickname,\n"
                            + "honorPicURL,\n"
                            + "honorCouple,\n"
                            + "honorGenderID,\n"
                            + "honortxt\n"
                            + "FROM " + Secret.HONOR_TABLE + "\n"
                            + "ORDER BY random();";

            ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new BestPerson(
                                        rs.getString(1)
                                        , rs.getString(2)
                                        , rs.getString(3)
                                        , rs.getString(4)
                                        , rs.getBoolean(5)
                                        , BestPerson.Gender.fromInt(rs.getInt(6))
                                        , rs.getString(7)
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
    public BestPerson getBestPerson(String cod) {
        //TODO
        return null;
    }
    
}
