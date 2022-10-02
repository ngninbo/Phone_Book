import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static LocalDateTime merge(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        int maxYear = Math.max(dateTime2.getYear(), dateTime1.getYear());
        int maxMonth = Math.max(dateTime2.getMonthValue(), dateTime1.getMonthValue());
        int maxDay = Math.max(dateTime2.getDayOfMonth(), dateTime1.getDayOfMonth());
        int maxHours = Math.max(dateTime1.getHour(), dateTime2.getHour());
        int maxMinutes = Math.max(dateTime1.getMinute(), dateTime2.getMinute());
        int maxSeconds = Math.max(dateTime1.getSecond(), dateTime2.getSecond());
        return LocalDateTime.of(maxYear, maxMonth, maxDay, maxHours, maxMinutes, maxSeconds);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LocalDateTime firstDateTime = LocalDateTime.parse(scanner.nextLine());
        final LocalDateTime secondDateTime = LocalDateTime.parse(scanner.nextLine());
        System.out.println(merge(firstDateTime, secondDateTime));
    }
}