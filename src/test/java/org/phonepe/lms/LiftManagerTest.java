package org.phonepe.lms;

import org.junit.jupiter.api.Test;
import org.phonepe.lms.model.DoorStatus;
import org.phonepe.lms.model.Lift;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LiftManagerTest {

    @Test
    public void operateMultipleLifts(){
        LiftOperations liftOperations = new LiftOperations();
        Lift lift1 = new Lift(1 + "", DoorStatus.OPEN, 0);
        Lift lift2 = new Lift(2 + "", DoorStatus.OPEN, 0);
        Lift lift3 = new Lift(3 + "", DoorStatus.OPEN, 0);

        List<Lift> lifts = Arrays.asList(lift1, lift2, lift3);

        // 0 5, 7 3
        LiftManager liftManager = new LiftManager(lifts, 10);
        String input = "0 5, 7 3";
        liftManager.execute(input);
    }

    @Test
    public void operateLiftsRuntime(){
        LiftOperations liftOperations = new LiftOperations();
        Lift lift1 = new Lift(1 + "", DoorStatus.OPEN, 0);
        Lift lift2 = new Lift(2 + "", DoorStatus.OPEN, 0);
        Lift lift3 = new Lift(3 + "", DoorStatus.OPEN, 0);

        List<Lift> lifts = Arrays.asList(lift1, lift2, lift3);

        // 0 5, 7 3
        LiftManager liftManager = new LiftManager(lifts, 10);
        String input = "0 5, 7 3";
        liftManager.execute(input);
    }

}