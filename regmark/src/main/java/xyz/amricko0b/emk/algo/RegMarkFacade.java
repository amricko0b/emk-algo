package xyz.amricko0b.emk.algo;

import xyz.amricko0b.emk.algo.regmark.RegMark;

/** Фасад, реализующий методы из задачи */
public final class RegMarkFacade {

  /**
   * Проверка номера на валидность
   *
   * @param mark номер
   * @return валидный или нет
   */
  public static boolean checkMark(String mark) {
    return RegMark.isValid(mark);
  }

  /**
   * Вычисления следующего свободного номера
   *
   * @param mark текущий номер
   * @return следующий или "Out of stock"
   */
  public static String getNextMarkAfter(String mark) {

    try {
      return RegMark.fromString(mark).next().toString();
    } catch (IllegalStateException ex) {

      if ("Out of stock".equals(ex.getMessage())) {
        return ex.getMessage();
      }

      throw ex;
    }
  }

  /**
   * @deprecated не имеет смысла?
   */
  @Deprecated
  public static String getNextMarkAfterInRange(
      String prevMark, String rangeStart, String rangeEnd) {
    throw new RuntimeException("Not implemented!");
  }

  /**
   * Вычислить кол-во возможных номеров между двумя
   *
   * @param mark1 начало
   * @param mark2 конец
   * @return кол-во номеров
   */
  public static int getCombinationsInRange(String mark1, String mark2) {
    var lower = RegMark.fromString(mark1);
    var end = RegMark.fromString(mark2);

    var count = 0;
    while (!lower.equals(end)) {
      count++;
      lower = lower.next();
    }

    return count;
  }

  private RegMarkFacade() {}
}
