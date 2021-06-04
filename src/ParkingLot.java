import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ParkingLot {
public static final int MAX_SLOT=10;

int slotNo=0;
int total_capacity=0;
int current_capacity=0;
 public Map <Integer,Car> slot_map ;

 public ParkingLot (int capacity){
  total_capacity=capacity;
  current_capacity=capacity;
  slot_map= new HashMap<Integer, Car>();
 }

 public Map<Integer, Car> getSlot_map() {
  return slot_map;
 }

 public int parkCarandGetSlotNo(  Car car) throws Exception {
if (slotNo<total_capacity) {
 slot_map.put(++slotNo, car);
return slotNo;
}else {
 System.out.println("full capacity");
 return -1;
}
 }




}
