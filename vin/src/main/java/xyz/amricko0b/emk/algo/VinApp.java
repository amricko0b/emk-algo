package xyz.amricko0b.emk.algo;

public class VinApp {

  public static void main(String[] args) {
    System.out.println("Valid VIN: " + VinFacade.checkVin("XW8ZZZ61ZJG013140"));
    System.out.println("WMI Region: " + VinFacade.getVinCountry("XW8ZZZ61ZJG013140"));
    System.out.println("Year of Manufacturing: " + VinFacade.getTransportYear("XW8ZZZ61ZJG013140"));
  }
}
