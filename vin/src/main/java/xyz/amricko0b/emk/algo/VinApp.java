package xyz.amricko0b.emk.algo;

import xyz.amricko0b.emk.algo.vin.Vin;

public class VinApp {

  public static void main(String[] args) {

    var vin = new Vin("XW8ZZZ61ZJG013140");

    System.out.println("Valid VIN: " + vin.valid());
    System.out.println("WMI Region: " + vin.country());
    System.out.println("Year of Manufacturing: " + vin.year());
  }
}
