package app;

import java.util.ArrayList;



public class MaintainSlot {
	
	private int max_size;
	private int emptySlotCount;
	boolean slotArray[];	
	
	public MaintainSlot(int a_maxSize) {
		max_size = a_maxSize;
		emptySlotCount = a_maxSize;
		slotArray = new boolean[a_maxSize];
	}
	/** slot numbering from 1 to (MAX_SIZE) */
	
	public int entry() {
		if(emptySlotPresent()) {
			int slot = returnMin();
			insertCarInSlot(slot);
			emptySlotCount--;
			return slot;
		}
		return -1;
	}
	
	private void insertCarInSlot(int slot) {
		slotArray[slot-1] = true;
	}
	
	public void exit(int slot) {
		slotArray[slot-1] = false;
		emptySlotCount++;;
	}
	
	public int returnMin() {
		int i;
		for(i=0;i<max_size;i++) {
			if(!slotArray[i]) {
				break;
			}
		}
		return i+1;
	}
	
	public boolean emptySlotPresent() {

		return (emptySlotCount > 0);
	}
	
	public int getRemainingSlots() {
		return emptySlotCount;
	}
	
	public int getSize() {
		return max_size;
	}
}
