package xyz.amricko0b.emk.algo.vin;

import java.util.regex.Pattern;

public record Vin(String raw) {

  private static final int VIN_LENGTH = 17;

  public boolean valid() {
    var pivot = raw.toUpperCase();

    // todo Попробовать подобрать регексп
    boolean is17 = pivot.length() == VIN_LENGTH;
    boolean hasNoCollisions = !Pattern.matches("[QIO]+", pivot);

    // todo Проверять на валидность регион

    return is17 && hasNoCollisions;
  }

  public String country() {

    if (!valid()) {
      throw new IllegalStateException("Provided string is not a VIN");
    }

    var pivot = raw.substring(0, 4).toUpperCase();
    var region = WmiRegion.fromChar(pivot.charAt(0));
    var countries = WmiIndex.REGION_COUNTRY.get(region);

    for (var country : countries) {
      if (country.supportedBy(pivot.charAt(1))) {
        return country.name();
      }
    }

    throw new IllegalArgumentException("No such WMI: " + pivot);
  }

  public String year() {
    var yearCode = Character.toUpperCase(raw.charAt(9));

    if (Character.isAlphabetic(yearCode)) {

      // todo нет буквы I
      var old = yearCode + 1915;
      var mint = yearCode + 1945;

      return String.format("%d or %d", old, mint);
    } else {
      // todo Не учтены числовые коды
      return "";
    }
  }
}
