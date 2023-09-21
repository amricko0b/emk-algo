package xyz.amricko0b.emk.algo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import xyz.amricko0b.emk.algo.vin.Vin;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class VinFacade {

  public static boolean checkVin(String vin) {
    return Vin.isValid(vin);
  }

  public static String getVinCountry(String vin) {
    return Vin.fromString(vin).getCountry().name().replace('_', ' ');
  }

  public static String getTransportYear(String vin) {
    return Vin.fromString(vin).getManufacturingYear();
  }
}
