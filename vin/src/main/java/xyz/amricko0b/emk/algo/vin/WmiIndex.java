package xyz.amricko0b.emk.algo.vin;

import static xyz.amricko0b.emk.algo.vin.WmiCountry.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WmiIndex {

  public static final Map<WmiRegion, List<WmiCountry>> REGION_COUNTRY =
      Arrays.stream(values()).collect(Collectors.groupingBy(WmiCountry::getRegion));
}
