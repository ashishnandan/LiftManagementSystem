package org.phonepe.lms;

import java.util.ArrayList;
import java.util.List;

public class LiftRequests {

    public List<String> requests;

    public void addRequests(String input){
        if (requests == null)
            requests = new ArrayList<>();
        requests.add(input);
    }

    public List<String> getRequests() {
        return requests;
    }
}
