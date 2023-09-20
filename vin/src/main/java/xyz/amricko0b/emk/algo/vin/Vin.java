package xyz.amricko0b.emk.algo.vin;

import java.util.Objects;
import java.util.regex.Pattern;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/** VIN-код */
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Vin {

  /**
   * Парсинг VIN без валидации
   *
   * @param raw сырой VIN
   * @return объект
   */
  public static Vin fromStringUnsafe(String raw) {
    return new Vin(raw.toUpperCase());
  }

  /** Стандартная длина VIN */
  private static final int VIN_LENGTH = 17;

  /** Строка VIN в ВЕРХНЕМ регистре */
  private final String pivot;

  /**
   * @return валидный или нет?
   */
  public boolean isValid() {

    boolean is17 = pivot.length() == VIN_LENGTH;
    boolean hasNoCollisions = !Pattern.matches("[QIO]+", pivot);

    return is17 && hasNoCollisions;
  }

  /**
   * @return страна-изготовитель
   * @see WmiCountry
   */
  public String getCountryName() {

    if (pivot.length() < 3) {
      throw new IllegalStateException("Provided string is not a VIN");
    }

    // WMI - это первые 3 символа
    var wmi = pivot.substring(0, 3);

    // Ищем регулярками для каждой страны
    WmiCountry country = null;
    for (var another : WmiCountry.values()) {
      if (another.getRegexp().matcher(wmi).matches()) {
        country = another;
      }
    }

    if (Objects.isNull(country)) {
      throw new IllegalArgumentException("No such WMI: " + wmi);
    }

    return country.name().replace('_', ' ');
  }

  /**
   * @return год производства
   */
  public String getManufacturingYear() {
    if (!isValid()) {
      throw new IllegalStateException("Provided string is not a VIN");
    }

    char yearCode;
    try {
      // Код года располагается на 10 позиции
      yearCode = pivot.charAt(9);
    } catch (IndexOutOfBoundsException ex) {
      throw new IllegalArgumentException("Unable to determine year - VIN too short");
    }

    // Является ли код буквой?
    var isLetter = Character.isAlphabetic(yearCode);

    // Каждой букве и цифре соответствует 2 разных года.
    // Скоро будет 3, после 2035 что ли
    int old;
    int fresh;

    // Вычисляем год по разнице между кодом сивола и самим годом
    // Фишка в том, что из-за отсутствия в VIN некоторых букв - разница не фиксированная
    if (isLetter && yearCode >= 'A' && yearCode <= 'H') {
      old = yearCode + 1915;
      fresh = yearCode + 1945;
    } else if (isLetter && yearCode >= 'J' && yearCode <= 'N') {
      old = yearCode + 1914;
      fresh = yearCode + 1944;
    } else if (isLetter && yearCode == 'P') {
      old = 1993;
      fresh = 2023;
    } else if (isLetter && yearCode >= 'R' && yearCode <= 'T') {
      old = yearCode + 1912;
      fresh = yearCode + 1942;
    } else if (isLetter && yearCode >= 'V' && yearCode <= 'Y') {
      old = yearCode + 1911;
      fresh = yearCode + 1941;
    } else if (!isLetter) {

      // Если код не является буквой - тогда проще, цифры все входят
      old = yearCode + 1952;
      fresh = yearCode + 1982;
    } else {
      throw new IllegalArgumentException("Wrong year code: " + yearCode);
    }

    return String.format("%d or %d", old, fresh);
  }
}
