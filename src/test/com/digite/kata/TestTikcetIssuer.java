package com.digite.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTikcetIssuer
{
    @Test
    public void testTicketIssuer()
    {
        ParkingLot w_parkingLot = new ParkingLot(10);
        TicketIssuer w_issuer = new TicketIssuer(w_parkingLot);

        Car w_car = new Car("Red", "MH-03-9000", "Shraddha");
        String w_ticket = "Name : Shraddha, Parking Slot : 1, Registeration No: MH-03-9000, Color: Red";
        Assertions.assertEquals(w_ticket, w_issuer.getTicket(w_car));
    }

    @Test
    public void testTicketIssuerWhenFull()
    {
        ParkingLot w_parkingLot = new ParkingLot(4);
        TicketIssuer w_issuer = new TicketIssuer(w_parkingLot);
        for(int i = 0; i < 4; i++)
        {
            Car w_car = new Car("Red", "MH-03-9000", "Shraddha");
            String  w_ticket =  w_issuer.getTicket(w_car);
        }
        Car w_car = new Car("Red", "MH-03-9000", "Shraddha");
        String  w_ticket = w_issuer.getTicket(w_car);
        Assertions.assertEquals("No Slots Available", w_ticket);
    }
}
