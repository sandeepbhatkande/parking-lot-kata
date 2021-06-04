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
  slotNo=0;
  total_capacity=capacity;
  current_capacity=capacity;
  slot_map= new HashMap<Integer, Car>();
 }

 public Map<Integer, Car> getSlot_map() {
  return slot_map;
 }

 public int parkCarandGetSlotNo(  Car car) throws Exception {
  int parkingLot = NearestParkingSlot();
  if (slot_map.size() <= total_capacity && parkingLot != 0) {
 slot_map.put(++slotNo, car);
return slotNo;
}else {
 System.out.println("full capacity");
 return -1;
}
 }

 public int NearestParkingSlot() {
  int emptySlot = 0;
  for (int i = 1; i <= total_capacity; i++){
   Car c = slot_map.get(i);
   if (c == null) {
    emptySlot = i;
    break;
   }
  }
  return emptySlot;
 }
 public String leaveCar(int slot) throws Exception {
  Car c = slot_map.get(slot);
  if (c != null) {
   slot_map.remove(slot);
   return "Slot number " + slot + " is free";
  }else
   return "fail";

 }




}
