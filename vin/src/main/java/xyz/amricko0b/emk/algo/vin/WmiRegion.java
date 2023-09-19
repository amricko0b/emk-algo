package xyz.amricko0b.emk.algo.vin;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum WmiRegion {
  AFRICA('A', 'C'),

  ASIA('J', 'R'),

  EUROPE('S', 'Z'),

  NORTH_AMERICA('1', '5'),

  OCEANIA('6', '7'),

  SOUTH_AMERICA('8', '9');

  private final char lower;

  private final char upper;

  public static WmiRegion fromChar(char c) {
    for (var region : WmiRegion.values()) {
      for (var code = region.lower; code <= region.upper; code++) {
        if (code == c) {
          return region;
        }
      }
    }

    throw new IllegalArgumentException("No such WMI region: " + c);
  }
}
