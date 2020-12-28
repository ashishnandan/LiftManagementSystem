package org.phonepe.lms.operations;

import java.util.HashMap;
import java.util.Map;

public class LiftRequests {

    public Map<String, String> requests;

    private int numberOfFloors;

    private static LiftRequests liftRequests;

    public static LiftRequests getInstance(){
        if (liftRequests == null)
            liftRequests = new LiftRequests();
        return liftRequests;
    }

    public static LiftRequests getInstance(int numberOfFloors){
        if (liftRequests == null)
            liftRequests = new LiftRequests();
        liftRequests.numberOfFloors = numberOfFloors;
        return liftRequests;
    }

    private LiftRequests() {
    }

    public void addRequests(String input) {
        if (requests == null)
            requests = new HashMap<>();
        String[] s = input.trim().split(" ");
        requests.put(s[0], s[1]);
        System.out.println(requests);
    }

    public Map<String, String> getRequests() {
        return requests;
    }
}
