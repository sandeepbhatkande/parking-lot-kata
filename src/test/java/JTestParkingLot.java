import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.digite.kata.parkinglot.ParkingLot;

public class JTestParkingLot
{
	@Test
	public void testIssueParkingSlot()
    {
        ParkingLot p = new ParkingLot(6);
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2701", "Blue"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2702", "Red"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2703", "Black"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2704", "Yellow"));
    }
	
	@Test
	public void testGetNearestSlot()
    {
        ParkingLot p = new ParkingLot(6);
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2701", "Blue"));
        assertEquals(2, p.getNearestSlot());
    }
	
	@Test
	public void testNoParkingSlot()
    {
        ParkingLot p = new ParkingLot(1);
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2701", "Blue"));
        assertEquals("No Slot available", p.issueParkingSlot("KA-01-HH-2702", "Green"));
    }
	
	@Test
	public void testLeaveParkingSlot()
    {
        ParkingLot p = new ParkingLot(6);
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2701", "Blue"));
        assertEquals("Leave Parking Slot successful", p.leaveParkingSlot(1L));
    }
	
	@Test
	public void testIssueIntermidiateParkingSlot()
    {
        ParkingLot p = new ParkingLot(6);
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2701", "Blue"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2702", "Red"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2703", "Black"));
        assertEquals("Leave Parking Slot successful", p.leaveParkingSlot(2L));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2704", "Yellow"));
        assertEquals("KA-01-HH-2704", p.getSlots().get(2L).getRegistrationNumber());
    }
	
	@Test
	public void testFindSlotNumberByRegNumber()
    {
        ParkingLot p = new ParkingLot(6);
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2701", "Blue"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2702", "Green"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2703", "Green"));
        Long expectedSlotNumber = 2L;
        assertEquals(expectedSlotNumber, p.findSlotNumberByRegNumber("KA-01-HH-2702"));
    }
	
	@Test
	public void testFindSlotNumberByRegNumberNotFound()
    {
        ParkingLot p = new ParkingLot(6);
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2701", "Blue"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2702", "Green"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2703", "Green"));
        Long expectedSlotNumber = 0L;
        assertEquals(expectedSlotNumber, p.findSlotNumberByRegNumber("KA-01-HH-2705"));
    }
	
	@Test
	public void testFindSlotsByCarColor()
    {
        ParkingLot p = new ParkingLot(6);
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2701", "Blue"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2702", "Green"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2703", "Green"));
        List<Long> expectedSlotList =  new ArrayList<Long>();
        expectedSlotList.add(2L);
        expectedSlotList.add(3L);
        assertEquals(expectedSlotList, p.findSlotsByCarColor("Green"));
    }
	
	@Test
	public void testFindSlotsByCarColorNotFound()
    {
        ParkingLot p = new ParkingLot(6);
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2701", "Blue"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2702", "Green"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2703", "Green"));
        assertEquals(new ArrayList<Long>(), p.findSlotsByCarColor("Red"));
    }
	
	@Test
	public void testFindRegNumberByCarColor()
    {
        ParkingLot p = new ParkingLot(6);
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2701", "Blue"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2702", "Green"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2703", "Green"));
        List<String> expectedRegNumList =  new ArrayList<String>();
        expectedRegNumList.add("KA-01-HH-2702");
        expectedRegNumList.add("KA-01-HH-2703");
        assertEquals(expectedRegNumList, p.findRegNumberByCarColor("Green"));
    }
	
	@Test
	public void testFindRegNumberByCarColorNotFound()
    {
        ParkingLot p = new ParkingLot(6);
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2701", "Blue"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2702", "Green"));
        assertEquals("Slot allocated successfully", p.issueParkingSlot("KA-01-HH-2703", "Green"));
        assertEquals(new ArrayList<String>(), p.findRegNumberByCarColor("Red"));
    }
}