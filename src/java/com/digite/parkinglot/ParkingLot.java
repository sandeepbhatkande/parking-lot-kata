package com.digite.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {

    private static int SLOTS = 0;
    private static HashMap<Integer, Car> w_slotAllocationMap = null;
    private static int BOOKED_SLOTS = 0;

    public ParkingLot(int a_no_of_slots) {
        this.SLOTS = a_no_of_slots;
        this.BOOKED_SLOTS = 0;
        w_slotAllocationMap= new HashMap<Integer, Car>();
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
                BOOKED_SLOTS++;
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

    public String deAllocateSlot (int w_slotNo) {
        String w_deallocationStaus = "";

        if (w_slotAllocationMap.containsKey(w_slotNo)) {
            w_slotAllocationMap.remove(w_slotNo);
            BOOKED_SLOTS--;
            w_deallocationStaus = "Slot " + w_slotNo + " is available for parking";
        } else {
            w_deallocationStaus = "Slot is already empty";
        }

        return w_deallocationStaus;
    }

    public HashMap<Integer, Car> getSlotAllocationMap () {
        return this.w_slotAllocationMap;
    }

    public String getRemainingSlotStatus() {
        return "Remaining slots are: " + (this.SLOTS - this.BOOKED_SLOTS);
    }
}
