package servicesTests;

import dto.Guest;
import java.util.List;
import services.GuestServices;

public class GuestsTest {
    
    public static void main(String[] args) {
        
        List<Guest> guests = GuestServices.getGuestList();
        guests.forEach((guest) -> GuestServices.printGuest(guest));
        
    }
    
}
