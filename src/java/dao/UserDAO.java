package dao;

import dto.User;


public interface UserDAO {
    
    public User insertUpdateUser(User user);
    public User getUser(String userID);
    public User getUserByFBID(String fbUserID);
    
}
