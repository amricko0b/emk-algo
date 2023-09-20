package xyz.amricko0b.emk.algo.vin;

import static java.util.regex.Pattern.compile;

import java.util.regex.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** Страна в формате WMI */
@Getter
@RequiredArgsConstructor
public enum WmiCountry {

  // Africa
  SOUTH_AFRICA(compile("^A[A-H].$")),

  // Asia

  JAPAN(compile("^J..$")),

  SOUTH_KOREA(compile("^K[L-R].$")),

  CHINA(compile("^L..$")),

  INDIA(compile("^M[A-E].$")),

  INDONESIA(compile("^M[F-K].$")),

  THAILAND(compile("^M[L-R].$")),

  MYANMAR(compile("^MR.$")),

  TURKEY(compile("^N[L-R].$")),

  PHILIPPINES(compile("^P[A-E].$")),

  MALAYSIA(compile("^P[L-R].$")),

  TAIWAN(compile("^P[L-R].$")),

  // Europe

  UNITED_KINGDOM(compile("^S[A-M].$")),

  GERMANY(compile("^(S[N-T].)|(W..)$")),

  POLAND(compile("^S[U-Z].$")),

  SWITZERLAND(compile("^T[A-H].$")),

  CZECH_REPUBLIC(compile("^T[J-P].$")),

  HUNGARY(compile("^T[R-V].$")),

  PORTUGAL(compile("T[W-Z1].$")),

  AUSTRIA(compile("V[A-E].$")),

  FRANCE(compile("V[F-R].$")),

  SPAIN(compile("V[S-W].$")),

  YUGOSLAVIA(compile("V[X-Z1-2].$")),

  THE_NETHERLANDS(compile("X[LM].$")),

  USSR(compile("X[S-W].$")),

  RUSSIA(compile("X[3-90].$")),

  BELGIUM(compile("Y[A-E].$")),

  FINLAND(compile("Y[F-K].$")),

  SWEDEN(compile("Y[S-W].$")),

  ITALY(compile("Z[A-R].$")),

  // North America

  UNITED_STATES(compile("[145]..$")),

  CANADA(compile("2..$")),

  MEXICO(compile("3..$")),

  // Oceania

  AUSTRALIA(compile("6[A-W].$")),

  NEW_ZEALAND(compile("7[A-E].$")),

  // South america

  ARGENTINA(compile("8[A-E].$")),

  CHILE(compile("8[F-J].$")),

  ECUADOR(compile("8[L-R].$")),

  VENEZUELA(compile("8[X-Z1-2].$")),

  BRAZIL(compile("9[A-E3-9].$")),

  COLOMBIA(compile("9[F-J].$"));

  /** Регулярка для парсинга */
  private final Pattern regexp;
}
