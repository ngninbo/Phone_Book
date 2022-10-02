// You can experiment here, it won’t be checked

import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Task {
  public static void main(String[] args) {
    // put your code here
    Instant instant  = Instant.EPOCH;

    System.out.println(instant.plus(1, ChronoUnit.WEEKS).atZone(ZoneId.of("GMT+4")));
  }
}
