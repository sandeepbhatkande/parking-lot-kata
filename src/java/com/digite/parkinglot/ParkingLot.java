package com.digite.parkinglot;

import java.util.HashMap;

public class ParkingLot {

    private static int SLOTS = 0;
    private static HashMap<Integer, Car> w_slotAllocationMap= new HashMap<Integer, Car>();

    public ParkingLot(int a_no_of_slots) {
        this.SLOTS = a_no_of_slots;
    }

    public int getSlots() {
        return this.SLOTS;
    }

    public String allocateSlotToParkCar (Car a_car) {
        String allocationStatus = "";
        int allocatedSlot = 0;

        for (int i = 1; i <= this.SLOTS; i++) {
            if (!w_slotAllocationMap.containsKey(i)){
                w_slotAllocationMap.put(i, a_car);
                allocatedSlot = i;
                break;
            }
        }

        if (allocatedSlot != 0) {
            allocationStatus = "Allocated slot " + allocatedSlot + " to " + a_car.getREG_NO();
        } else {
            allocationStatus = "All slots are booked";
        }

        return allocationStatus;
    }

    public String deAllocateSlot (String w_carNo) {
        String w_deallocationStaus = "";
        int w_slotTodeallocate = 0;

        for (Integer slot: w_slotAllocationMap.keySet())
        {
            Car car = w_slotAllocationMap.get(slot);

            if (w_carNo == car.getREG_NO()) {
                w_slotTodeallocate = slot;
                break;
            }
        }

        if (w_slotTodeallocate > 0) {
            w_deallocationStaus = "Slot " + w_slotTodeallocate + " is available for parking";
        } else {
            w_deallocationStaus = "Car is not parked";
        }

        return w_deallocationStaus;
    }
}
