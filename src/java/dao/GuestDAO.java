package dao;

import dto.Guest;
import java.util.List;

public interface GuestDAO {
    
    public List<Guest> rsvp(List<Guest> guests);
    public List<Guest> getList();
    
}
