// You can experiment here, it won’t be checked

import java.time.*;

public class Task {
  public static void main(String[] args) {
    System.out.println(LocalDateTime.of(2020, 1, 1, 0, 1, 1).minusSeconds(61));
    System.out.println(LocalDateTime.of(LocalDate.of(2019, 12, 31), LocalTime.MAX));
    System.out.println(LocalDateTime.parse("2017-12-31T23:59").withYear(2019));
    System.out.println(LocalDateTime.parse("2019-12-31T23:59").withSecond(59));
    System.out.println(LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.MIDNIGHT).minusSeconds(1));
    System.out.println(LocalDateTime.of(2020, 12, 31, 23, 59, 59).minusYears(1));

    /*
    Instant instant  = Instant.EPOCH;
    instant.minus(Period.ofDays(1));

    System.out.println(instant.minus(Duration.ofDays(32)).atZone(ZoneId.of("GMT+6")));

    Instant instant = Instant.ofEpochSecond(0l, 1_000_000_001);
    System.out.println(instant);*/

    Instant instant = Instant.ofEpochSecond(987654L);
    System.out.println(instant.getEpochSecond());
  }
}
