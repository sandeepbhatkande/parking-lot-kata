package test;
import static org.junit.Assert.assertEquals;
import org.junit.*;

import app.*;


public class testMinSlot {
	
	@Test
	public void testFirstSlot() {
		FirstSlot w_firstSlot = new FirstSlot(10);
		w_firstSlot.entry(w_firstSlot.returnMin());
		assertEquals(w_firstSlot.returnMin(), 2);
	}

}
