package org.phonepe.lms;

import org.phonepe.lms.model.Lift;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LiftManager {

  private List<Lift> lifts;

  private int numberOfFloors;

  public LiftManager(List<Lift> lift, int numberOfFloors) {
    this.lifts = lifts;
    this.numberOfFloors = numberOfFloors;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("No of Lifts : ");
    int numberOfLifts = scanner.nextInt();
    System.out.print("Number of Floors : ");
    int numberOfFloors = scanner.nextInt();

  }
}
