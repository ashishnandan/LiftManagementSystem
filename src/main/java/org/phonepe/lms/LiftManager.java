package org.phonepe.lms;

import org.phonepe.lms.model.DoorStatus;
import org.phonepe.lms.model.Lift;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LiftManager {

  private List<Lift> lifts;

  private int numberOfFloors;

  public LiftManager(List<Lift> lifts, int numberOfFloors) {
    this.lifts = lifts;
    this.numberOfFloors = numberOfFloors;
  }

  public void execute(String input) {
    LiftOperations liftOperations = new LiftOperations();
    String[] split = input.split(",");

    // validation here

    for (int i = 0; i < lifts.size(); i++) {
      if (i >= split.length)
        break;
      String[] s = split[i].trim().split(" ");
      liftOperations.operate(lifts.get(i), Integer.valueOf(s[0]), Integer.valueOf(s[1]));
    }
  }

  public Lift identifyLiftToExecute(String input) {
    // identify if any lift is idle
    Lift lift = getFirstIdleLift();
    if (lift != null)
      return lift;
    final String[] s = input.split(" ");
    if (Integer.valueOf(s[1]) > Integer.valueOf(s[1])) {
      // lift is moving up, identify a up moving lift and which is at lesser floor
    } else {

    }
    return lift;
  }

  private Lift getFirstIdleLift() {
    Lift lift = null;
    for (Lift l : lifts) {
      if (l.getStatus() == "IDLE") {
        lift = l;
        break;
      }
    }
    return lift;
  }

  public void execute() {
    LiftOperations liftOperations = new LiftOperations();
    List<String> inputs = new LiftRequests().getRequests();
    // validation here

    for (int i = 0; i < lifts.size(); i++) {
      if (i >= inputs.size())
        break;
      String[] s = inputs.get(i).trim().split(" ");
      liftOperations.operate(lifts.get(i), Integer.valueOf(s[0]), Integer.valueOf(s[1]));
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("No of Lifts : ");
    int numberOfLifts = scanner.nextInt();
    System.out.print("Number of Floors : ");
    int numberOfFloors = scanner.nextInt();

    List<Lift> lifts = new ArrayList<>(numberOfLifts);
    for (int i = 0; i < numberOfLifts; i++) {
      final int id = i + 1;
      lifts.add(new Lift(id + "", DoorStatus.OPEN, 0));
    }

  }
}
