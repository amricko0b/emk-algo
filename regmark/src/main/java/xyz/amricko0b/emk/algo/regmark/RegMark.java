package xyz.amricko0b.emk.algo.regmark;

import java.util.Arrays;
import java.util.regex.Pattern;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class RegMark {

  public static boolean isValid(String raw) {
    return REG_MARK_PATTERN.matcher(raw.toLowerCase()).matches();
  }

  public static RegMark fromString(String raw) {

    if (!isValid(raw)) {
      throw new IllegalArgumentException("Not a valid reg mark: " + raw);
    }

    var series = new char[] {raw.charAt(0), raw.charAt(4), raw.charAt(5)};
    var number = Integer.parseInt(raw.substring(1, 4));
    return new RegMark(series, number, raw.substring(6));
  }

  private static final Pattern REG_MARK_PATTERN =
      Pattern.compile("^[a-z][0-9]{3}[a-z]{2}[0-9]{2,3}$");

  private final char[] series;
  private final int number;
  private final String region;

  public RegMark next() {

    // Если номер меньше 1000 - серию можно продолжать
    var nextNumber = number + 1;
    if (nextNumber < 1000) {
      return new RegMark(this.series, nextNumber, this.region);
    }

    // Если номер больше тысячи - надо выпускать новую серию.
    var newSeries = Arrays.copyOf(this.series, 3);
    for (var idx = 2; idx >= 0; idx--) {

      var nextLetter = newSeries[idx] + 1;

      // Если всё ещё в алфавите находимся - ок.
      if (nextLetter <= 'z') {
        newSeries[idx] = (char) nextLetter;
        return new RegMark(newSeries, 1, this.region);
      } else {
        // Если нет - надо следующий символ смотреть, а текущий обнуляем
        newSeries[idx] = 'a';
      }
    }

    throw new IllegalStateException("Out of stock");
  }

  @Override
  public String toString() {
    return this.series[0]
        + String.format("%03d", this.number)
        + this.series[1]
        + this.series[2]
        + this.region;
  }

  @Override
  public boolean equals(Object obj) {

    if (!(obj instanceof RegMark other)) {
      return false;
    }

    return this.toString().equals(other.toString());
  }
}
