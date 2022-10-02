import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime start = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime end = LocalDateTime.parse(scanner.nextLine());
        long hours = start.until(end, ChronoUnit.HOURS);
        System.out.println(hours);
    }
}