package servicesTests;

import dto.User;
import services.UserServices;

public class UsersTest {

    public static void main(String[] args) {
        
        User user = new User(
                                "10208707423624573"
                                ,"Pedro Goñi Coelho"
                                ,"pedrogonic@gmail.com"
                                ,"https://scontent.xx.fbcdn.net/v/t1.0-1/p50x50/13495239_10206519511888147_3750956283606908054_n.jpg?oh=3556781eebeaee8a5f2ffb864fd27b54&oe=5991A8DF"
                            );
        user = UserServices.authenticate(user);
        System.out.println("UserID: " + user.getUserID());
        
    }
    
}
