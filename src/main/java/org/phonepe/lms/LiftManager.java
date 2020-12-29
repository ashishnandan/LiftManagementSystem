package org.phonepe.lms;

import org.phonepe.lms.model.DoorStatus;
import org.phonepe.lms.model.Lift;
import org.phonepe.lms.operations.LiftIdentifier;
import org.phonepe.lms.operations.LiftOperations;
import org.phonepe.lms.operations.LiftRequests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LiftManager {

  private List<Lift> lifts;

  private int numberOfFloors;

  public LiftManager(List<Lift> lifts, int numberOfFloors) {
    this.lifts = lifts;
    this.numberOfFloors = numberOfFloors;
  }

  public void execute() throws InterruptedException {
    System.out.println("Called");
    LiftOperations liftOperations = new LiftOperations();
    LiftRequests liftRequests = LiftRequests.getInstance();
    Map<String, String> requests = liftRequests.getRequests();
    synchronized (liftRequests) {
      for (Map.Entry<String, String> entry : requests.entrySet()) {
        String direction = Integer.parseInt(entry.getValue()) > Integer.parseInt(entry.getKey()) ?
                "up" :
                "down";
        Lift lift = getLift(direction);
        while (lift == null) {
          this.wait(1000);
          lift = getLift(direction);
        }
        System.out.println("Lift selected for operation : " + lift.getId());
        liftOperations.operate(lift, Integer.parseInt(entry.getKey()),
                Integer.parseInt(entry.getValue()));
      }
    }
  }

  private Lift getLift(String direction) {
    Lift lift = null;
    final LiftIdentifier liftIdentifier = new LiftIdentifier(lifts);
    lift = liftIdentifier.getIdleLift();
    if (lift == null)
      lift = liftIdentifier.getNearestLiftInSameDirection(direction);
    return lift;
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


    LiftManager liftManager = new LiftManager(lifts, numberOfFloors);

    try {
      ScheduledExecutorService exec = Executors.newScheduledThreadPool(5);
      exec.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
          try {
            liftManager.execute();
          } catch (InterruptedException e) {
            // error handling
          }
        }
      }, 0, 5, TimeUnit.SECONDS);
    } catch (Exception e) {
      System.out.println("ERR -> " + e.getMessage());
    }

    LiftRequests liftRequests = LiftRequests.getInstance(numberOfFloors);
    while (scanner.hasNext()) {
      String s = scanner.next();
      s += scanner.nextLine();
      liftRequests.addRequests(s);
    }
    scanner.close();

  }

}
