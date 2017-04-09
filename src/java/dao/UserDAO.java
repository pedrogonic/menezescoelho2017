package dao;

import dto.User;

public interface UserDAO extends AutoCloseable {
    
    public User insertUpdateUser(User user);
    public User getUser(String userID);
    public User getUserByFBID(String fbUserID);
    
    @Override
    public void close();
    
}
