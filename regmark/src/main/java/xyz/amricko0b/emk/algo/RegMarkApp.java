package xyz.amricko0b.emk.algo;

public class RegMarkApp {

  public static void main(String[] args) {

    System.out.println("Valid: " + RegMarkFacade.checkMark("b278kk147"));
    System.out.println("Next: " + RegMarkFacade.getNextMarkAfter("c999zz147"));
    System.out.println("Next: " + RegMarkFacade.getCombinationsInRange("c999zz147", "e001aa147"));
  }
}
