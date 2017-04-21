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
        Message trashMessage = new Message(
                                        "86826479-9b4e-4cfc-977a-b3266c5c6c1f"
                                        , user // WORKS
                                        //,new User("nonExistent") // FAILS
                                    );
        
        // POSTING
//        message = MessageServices.postMessage(message);
//        System.out.println("MessageID: " + message.getMessageID());
        
        // REPLYING
//        message.setReply("reply!");
//        message = MessageServices.postMessage(message);
//        System.out.println("Reply: " + message.getReply());
        
        //GETTING MESSAGES
        List<Message> list = MessageServices.getAllMessages(user);
        list.forEach((msg) -> {
            System.out.println("MessageID: " + msg.getMessageID());
            System.out.println("Trashable: " + msg.isTrashable());
        });

        // TRASHING
        System.out.println("Delete msg " + trashMessage.getMessageID() + " result: " + MessageServices.trashMessage(trashMessage));
        
    }
    
}
