import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JTestMyParkingSlot
{
	MyParkingSlot p = new MyParkingSlot();
	@Test
    public void testAParkingSlotInvalid()
    {
       assertEquals(p.createParkingSLot(0), "Provide valid parking slot.."); 
    }

	@Test
    public void testBParkingSlotValid()
    {
       assertEquals(p.createParkingSLot(6), "Parking Lot Created.."); 
       assertEquals(p.m_slotList.size(), 6);
    }

	@Test
    public void testCParkCar()
    {
		Car w_carObj1 = new Car("123", "White");
		MyParkingSlot p = new MyParkingSlot();
		if (p.m_slotList == null)
			p.createParkingSLot(6);
		assertEquals(p.parkCar(w_carObj1), "Car Parked..");

		Car w_carObj2 = new Car("1231", "White");
		assertEquals(p.parkCar(w_carObj2), "Car Parked..");

		Car w_carObj3 = new Car("234", "White");
		assertEquals(p.parkCar(w_carObj3), "Car Parked..");

		Car w_carObj4 = new Car("456", "Red");
		assertEquals(p.parkCar(w_carObj4), "Car Parked..");

		Car w_carObj5 = new Car("789", "Red");
		assertEquals(p.parkCar(w_carObj5), "Car Parked..");

		Car w_carObj6 = new Car("101", "Blue");
		assertEquals(p.parkCar(w_carObj6), "Car Parked..");

		Car w_carObj7 = new Car("102", "Silver");
		assertEquals(p.parkCar(w_carObj7), "Parking Lot is not available..");
    }

	@Test
    public void testDLeave()
    {
		if (p.m_slotVsCarMap.size() == 0)
			parkCar();

		assertEquals(p.leave("6"), "No Car to leave..");

		assertEquals(p.leave("4"), "Car left..");

		//should park to the vacant nearest slot..
		Car w_carObj = new Car("102", "Silver");
		assertEquals(p.parkCar(w_carObj), "Car Parked..");
		Car w_modifiedObj = p.m_slotVsCarMap.get("4");
		assertTrue(w_modifiedObj != null);
    }

	@Test
    public void testELeaveNoCarAvailableInParking()
    {
		assertEquals(p.leave("1"), "No Car available in parking..");
    }

	@Test
	public void testSlotNumberFromRegNum()
	{
		if (p.m_slotVsCarMap.size() == 0)
			parkCar();

		assertEquals(p.getSlotNumFromRegistrationNum("123"), "0");

		//invalid
		assertEquals(p.getSlotNumFromRegistrationNum("222"), "No Registration Number Available..");
	}

	@Test
	public void testGetSlotNumFromColor()
	{
		if (p.m_slotVsCarMap.size() == 0)
			parkCar();

		assertEquals(p.getSlotNumFromColor("White"), "0,1,2,");

		//invalid
		assertEquals(p.getSlotNumFromColor("Green"), "No slot nums available for given color..");
	}

	@Test
	public void testGetRegistrationNumOfAllCars()
	{
		if (p.m_slotVsCarMap.size() == 0)
			parkCar();

		assertEquals(p.getRegistrationNumOfAllCars("White"), "123,1231,234,");

		assertEquals(p.getRegistrationNumOfAllCars("Green"), "No Registration Available for color Green");

	}

	public void parkCar() 
	{
		Car w_carObj1 = new Car("123", "White");
		if (p.m_slotList == null)
			p.createParkingSLot(6);
		p.parkCar(w_carObj1);

		Car w_carObj2 = new Car("1231", "White");
		p.parkCar(w_carObj2);

		Car w_carObj3 = new Car("234", "White");
		p.parkCar(w_carObj3);

		Car w_carObj4 = new Car("456", "Red");
		p.parkCar(w_carObj4);

		Car w_carObj5 = new Car("789", "Red");
		p.parkCar(w_carObj5);

		Car w_carObj6 = new Car("101", "Blue");
		p.parkCar(w_carObj6);
	}
}
