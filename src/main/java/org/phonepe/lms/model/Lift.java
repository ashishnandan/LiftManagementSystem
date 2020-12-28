package org.phonepe.lms.model;

public class Lift {

    private String id;

    private String doorStatus = "CLOSED";

    private int currentFloor;

    public Lift(String id, String doorStatus, int currentFloor) {
        this.id = id;
        this.doorStatus = doorStatus;
        this.currentFloor = currentFloor;
    }

    public void openDoor() {
        this.doorStatus = "OPEN";
    }

    public void closeDoor() {
        this.doorStatus = "CLOSED";
    }

    public String getDoorStatus() {
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

    @Override
    public String toString() {
        return "LIFT " + id + " -> " + this.currentFloor + "(" + this.doorStatus + ")";
    }
}
