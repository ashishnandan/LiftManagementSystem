package org.phonepe.lms.operations;

import org.phonepe.lms.model.Lift;

import java.util.List;
import java.util.stream.Collectors;

public class LiftIdentifier {
    private List<Lift> lifts;

    public LiftIdentifier(List<Lift> lifts) {
        this.lifts = lifts;
    }

    public Lift getIdleLift() {
        Lift idleLift = null;
        for (Lift lift : lifts) {
            if (lift.getStatus().equalsIgnoreCase("idle")) {
                idleLift = lift;
                break;
            }
        }
        return idleLift;
    }

    public Lift getNearestLiftInSameDirection(String direction) {
        switch (direction) {
            case "up": {
                lifts.parallelStream().filter(l -> l.getStatus().equalsIgnoreCase("up")).collect(
                        Collectors.toList());
                return lifts.get(0);
            }
            case "down": {
                lifts.parallelStream().filter(l -> l.getStatus().equalsIgnoreCase("down")).collect(
                        Collectors.toList());
                return lifts.get(0);
            }
            default: {
                return null;
            }
        }
    }
}
