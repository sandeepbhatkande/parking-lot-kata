package app;

import java.util.ArrayList;



public class FirstSlot {
	
	private int max_size;
	private int emptySlotCount;
	int slotArray[];	
	
	public FirstSlot(int a_maxSize) {
		max_size = a_maxSize;
		emptySlotCount = a_maxSize;
		slotArray = new int[a_maxSize];
	}
	/** slot numbering from 1 to MAX_SIZE */
	
	public void entry(int slot) {
		
	}
	
	public void exit(int slot) {
		
	}
	
	public int returnMin() {
		return 1;
	}
	
	public boolean emptySlotPresent() {
		return true;
	}

}
