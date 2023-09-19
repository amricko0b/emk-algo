package xyz.amricko0b.emk.algo.vin;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static xyz.amricko0b.emk.algo.vin.WmiRegion.*;

@Getter
@RequiredArgsConstructor
public enum WmiCountry {
  SOUTH_AFRICA(AFRICA, 'A', 'H'),

  USSR(EUROPE, 'S', 'W'),

  RUSSIA(EUROPE, '0', '3');

  private final WmiRegion region;

  private final char lower;

  private final char upper;

  public boolean supportedBy(char c) {
    for (var code = lower; code <= upper; code++) {
      if (code == c) {
        return true;
      }
    }

    return false;
  }
}
