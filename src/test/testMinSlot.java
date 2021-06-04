package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import app.*;


public class testMinSlot {
	
	@Test
	public void testFirstSlot() {
		MaintainSlot w_firstSlot = new MaintainSlot(10);
		w_firstSlot.entry();
		assertEquals(w_firstSlot.returnMin(), 2);
	}
	
	@Test
	public void testEmptyProperty() {
		MaintainSlot w_firstSlot = new MaintainSlot(10);
		for(int i=0;i < 10;i++)
		{
			assertTrue(w_firstSlot.emptySlotPresent());
			w_firstSlot.entry();
		}
		assertTrue(!w_firstSlot.emptySlotPresent());
		assertTrue(w_firstSlot.entry()==-1);
	}
	
	@Test
	public void testRandomEntryExit() {
		MaintainSlot w_firstSlot = new MaintainSlot(10);
		assertEquals(w_firstSlot.entry(), 1);
		assertEquals(w_firstSlot.entry(), 2);
		assertEquals(w_firstSlot.entry(), 3);
		w_firstSlot.exit(2);
		assertEquals(w_firstSlot.entry(), 2);
		w_firstSlot.exit(1);
		assertEquals(w_firstSlot.entry(), 1);
		assertEquals(w_firstSlot.entry(), 4);
		assertEquals(w_firstSlot.entry(), 5);
		w_firstSlot.exit(2);
		w_firstSlot.exit(4);
		assertEquals(w_firstSlot.entry(), 2);
	}

}
