import java.util.ArrayList;
import java.util.HashMap;

public class ParkingSlot 
{
	ArrayList<String> m_slotList;
	HashMap<String, String> m_carRegNoSlotMap = new HashMap<String, String>();
	HashMap<String, ArrayList<String>> m_regNoColorListMap = new HashMap<String, ArrayList<String>>();
	HashMap<String, Car> m_carSlotMap = new HashMap<String, Car>();
	int m_maxSlotSize = 0;
	
	public String createParkingSLot(int a_slotCount)
	{
		if (a_slotCount > 0)
		{
			this.m_maxSlotSize = a_slotCount; 
			m_slotList = new ArrayList<String>();
			for (int i = 0; i < a_slotCount; i++)
			{
				m_slotList.add(String.valueOf(i));
			}
			return "Parking Lot Created.."; 
		}
		return "Provide valid parking slot..";
	}
	
	public String parkCar(Car a_carObj) 
	{
		String w_parkingMsg = "";
		if (m_carRegNoSlotMap.size() == this.m_maxSlotSize)
		{
			w_parkingMsg = "Parking Lot is not available..";
		}
		else
		{
			String w_slotNo = m_slotList.get(0);
			m_carSlotMap.put(w_slotNo, a_carObj);
			m_carRegNoSlotMap.put(a_carObj.getRegistrationNo(), w_slotNo);
			if (m_regNoColorListMap.containsKey(a_carObj.getColor()))
			{
				ArrayList<String> w_regNoList = m_regNoColorListMap.get(a_carObj.getColor());
				w_regNoList.add(a_carObj.getRegistrationNo());
				m_regNoColorListMap.put(a_carObj.getColor(), w_regNoList);
			}
			else
			{
				ArrayList<String> w_regNoList = new ArrayList<String>();
				w_regNoList.add(a_carObj.getRegistrationNo());
				m_regNoColorListMap.put(a_carObj.getColor(), w_regNoList);
			}
			m_slotList.remove(0);
			w_parkingMsg = "Car Parked..";
		}
		return w_parkingMsg;
	}
	
	public String leave(String a_slotNum)
	{
		String w_leaveMsg = "No Car available in parking..";
		if (m_carSlotMap.size() > 0)
		{
			Car w_carObj = m_carSlotMap.get(a_slotNum);
			if (w_carObj == null)
			{
				w_leaveMsg = "No Car to leave..";
			}
			else
			{
				m_carRegNoSlotMap.remove(w_carObj.getRegistrationNo());
				m_carSlotMap.remove(a_slotNum);
				ArrayList<String> w_registerList = m_regNoColorListMap.get(w_carObj.getColor());
				w_registerList.remove(w_carObj.getRegistrationNo());
				m_slotList.add(a_slotNum);
				w_leaveMsg = "Car left..";
			}
		}
		return w_leaveMsg;
	}
	
	public String getRegistrationNumOfAllCars(String a_color)
	{
		String w_msg = "";
		if (m_regNoColorListMap.containsKey(a_color))
		{
			ArrayList<String> w_list = m_regNoColorListMap.get(a_color);
			for (String w_regNo : w_list)
			{
				w_msg += w_regNo + ",";
			}
		}
		else
		{
			w_msg = "No Registration Available for color " + a_color;
		}
		return w_msg;
	}
	
	public String getSlotNumFromRegistrationNum(String a_num)
	{
		String w_slotNum = "";
		if (m_carRegNoSlotMap.containsKey(a_num))
		{
			w_slotNum = m_carRegNoSlotMap.get(a_num);
		}
		else
		{
			w_slotNum = "No Registration Number Available..";
		}
		return w_slotNum;
	}
	
	public String getSlotNumFromColor(String a_color)
	{
		String w_slotNums = "";
		if (m_regNoColorListMap.containsKey(a_color))
		{
			ArrayList<String> w_regNoList = m_regNoColorListMap.get(a_color);
			for (String w_regNo : w_regNoList)
			{
				w_slotNums += Integer.valueOf(m_carRegNoSlotMap.get(w_regNo)) + ",";
			}
			return w_slotNums;
		}
		return "No slot nums available for given color..";
	}
}
