package org.phonepe.lms;

import org.phonepe.lms.model.Lift;

public class LiftOperations {

    private static final int TIME_UNIT = 1;
    private static final int BASE_FLOOR = 0;

    public void operate(Lift lift, int startFloor, int destinationFloor) {
        int time = 0;
        lift.openDoor();
        trackLiftJourney(lift, time);
        lift.closeDoor();
        time++;
        for (int i = startFloor; i < destinationFloor; i++) {
            trackLiftJourney(lift, time);
            lift.moveUp();
            time++;
        }
        lift.openDoor();
        trackLiftJourney(lift, time);
    }

    public void trackLiftJourney(Lift lift, int time) {
        System.out.println("T = " + time);
        System.out.println(lift);
    }
}
