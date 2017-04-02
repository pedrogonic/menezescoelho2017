package dao;

import dto.User;

public interface UserDAO extends AutoCloseable {
    
    public User insertUpdateUser(User user);
    public User getUser(String fbUserID);
    
    @Override
    public void close();
    
}
