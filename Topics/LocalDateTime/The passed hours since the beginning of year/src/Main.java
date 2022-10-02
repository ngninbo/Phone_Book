import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime beginningOfYear = dateTime
                .withDayOfYear(1)
                .withHour(0)
                .minusMinutes(0)
                .withSecond(0);
        long hours = ChronoUnit.HOURS.between(beginningOfYear, dateTime);
        System.out.println(hours);
    }
}