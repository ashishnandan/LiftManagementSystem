package org.phonepe.lms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.phonepe.lms.model.Lift;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LiftOperationsTest {

    private LiftOperations liftOperations;

    @BeforeEach
    public void setUp() {
        liftOperations = new LiftOperations();
    }

    @Test
    public void operateUp_fromBaseFloor() {
        Lift lift = new Lift("1", "OPEN", 0);
        liftOperations.operate(lift, 0, 7);

        assertEquals(7, lift.getCurrentFloor());
        assertEquals(8, liftOperations.getJourneyTime());
    }

    @Test
    public void operateUp_FromNonBaseFloor() {
        Lift lift = new Lift("1", "OPEN", 0);
        liftOperations.operate(lift, 3, 8);

        assertEquals(8, lift.getCurrentFloor());
        assertEquals(10, liftOperations.getJourneyTime());
    }
}