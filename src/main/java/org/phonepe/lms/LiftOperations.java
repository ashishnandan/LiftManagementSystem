package org.phonepe.lms;

import org.phonepe.lms.model.Lift;

public class LiftOperations {

    private static final int TIME_UNIT = 1;
    private int journeyTime;

    public void operate(Lift lift, int startFloor, int destinationFloor) {
        if (destinationFloor > startFloor) {
            if (startFloor != 0) {
                trackLiftJourney(lift, journeyTime);
                lift.closeDoor();
                journeyTime++;
                operateUp(lift, 0, startFloor);
                lift.closeDoor();
                journeyTime++;
                operateUp(lift, startFloor, destinationFloor);
            } else {
                trackLiftJourney(lift, journeyTime);
                lift.closeDoor();
                journeyTime++;
                operateUp(lift, startFloor, destinationFloor);
            }
        }
        System.out.println("Lift " + lift.getId() + " : " + journeyTime + "SECONDS");
    }

    private void operateUp(Lift lift, int startFloor, int destinationFloor) {
        for (int i = startFloor; i < destinationFloor; i++) {
            trackLiftJourney(lift, journeyTime);
            lift.moveUp();
            journeyTime++;
        }
        lift.openDoor();
        trackLiftJourney(lift, journeyTime);
    }

    public void trackLiftJourney(Lift lift, int time) {
        System.out.println("T = " + time);
        System.out.println(lift);
    }

    public int getJourneyTime() {
        return journeyTime;
    }
}
