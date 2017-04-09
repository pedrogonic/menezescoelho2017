package servicesTests;

import dto.Message;
import dto.User;
import java.util.List;
import lib.Secret;
import services.MessageServices;

public class MessagesTest {

    public static void main(String[] args) {
        
        
        User user = new User(
                                Secret.DB_PEDRO_LOGIN
                            );
        Message message = new Message(
                                        user
                                        ,"#000000"
                                        ,"test"
                                    );
        
        // POSTING
        message = MessageServices.postMessage(message);
        System.out.println("MessageID: " + message.getMessageID());
        
        //GETTING MESSAGES
        List<Message> list = MessageServices.getAllMessages(user);
        list.forEach((msg) -> {
            System.out.println("MessageID: " + msg.getMessageID());
            System.out.println("Trashable: " + msg.isTrashable());
        });

    }
    
}
