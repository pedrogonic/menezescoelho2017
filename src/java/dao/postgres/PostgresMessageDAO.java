package dao.postgres;

import dao.MessageDAO;
import dto.Message;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("CallToPrintStackTrace")
public class PostgresMessageDAO implements MessageDAO {

    private final java.sql.Connection con;
    
    public PostgresMessageDAO(java.sql.Connection con) { this.con = con; }
    
    @Override
    public int insertMessage(Message message){
        //TODO
        return 1;
    }
    
    @Override
    public Message.DeleteResult deleteMessage(Message message) {
        //TODO
        return Message.DeleteResult.DENIED;
    }
    
    @Override
    public Message getMessage(int id) {
        //TODO
        return new Message();
    }
    
    @Override
    public List<Message> getAllMessages() {
        //TODO
        return new ArrayList<>();
    }
    
    @Override
    public void close() {
        try { if(con != null) {con.close();} } catch(SQLException e) {e.printStackTrace();}
    }
    
}
