package org.phonepe.lms.model;

import static org.phonepe.lms.model.DoorStatus.CLOSED;
import static org.phonepe.lms.model.DoorStatus.OPEN;

public class Lift {

    private String id;

    private DoorStatus doorStatus;

    private int currentFloor;

    private String status;

    public Lift(String id, DoorStatus doorStatus, int currentFloor) {
        this.id = id;
        this.doorStatus = doorStatus;
        this.currentFloor = currentFloor;
    }

    public void openDoor() {
        this.doorStatus = OPEN;
    }

    public void closeDoor() {
        this.doorStatus = CLOSED;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveUp() {
        currentFloor++;
    }

    public void moveDown() {
        currentFloor--;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "LIFT " + id + " -> " + this.currentFloor + "(" + this.doorStatus + ")";
    }
}
