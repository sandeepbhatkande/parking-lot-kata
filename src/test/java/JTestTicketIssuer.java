import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.digite.kata.tracker.Car;
import com.digite.kata.tracker.ParkingLot;
import com.digite.kata.tracker.TicketIssuer;

public class JTestTicketIssuer
{
    @Test
    public void testTicketIssuer()
    {
        ParkingLot w_parkingLot = new ParkingLot(10);
        Car w_car = new Car("Red", "MH-03-9000");
        TicketIssuer w_issuer = new TicketIssuer(w_car, w_parkingLot);
        String w_ticket = "Name : Hitesh Narwani, Parking Slot : 1, Registeration No: MH-03-9000, Color: White";
        Assertions.assertEquals(w_ticket, w_issuer.getTicket());

    }
}