package code;

public class CarParkingSlotManagment 
{
	private int max_size;
	private int emptySlotCount;
	boolean slotArray[];	
	
	public CarParkingSlotManagment(int a_maxSize) 
	{
		max_size = a_maxSize; 
		emptySlotCount = a_maxSize;
		slotArray = new boolean[a_maxSize];
	}
	
	public int nearestEntry() 
	{
		if(emptySlotPresent()) 
		{
			int slot = returnMin();
			markedSlotOccupied(slot);
			emptySlotCount--;
			return slot;
		}
		return -1;
	}
	
	private void markedSlotOccupied(int slotNo) 
	{
		slotArray[slotNo-1] = true;
	}
	
	public void markedSlotEmpty(int slotNo) 
	{
		slotArray[slotNo-1] = false;
		emptySlotCount++;
	}
	
	public int returnMin() 
	{
		int i;
		for(i=0;i<max_size;i++) 
		{
			if(!slotArray[i]) 
			{
				break;
			}
		}
		return i+1;
	}
	
	public boolean emptySlotPresent()
	{
		return emptySlotCount > 0;
	}
	
	public int getRemainingSlots() 
	{
		return emptySlotCount;
	}
	
	public int getAllowedParkingSize() 
	{
		return max_size;
	}
}
