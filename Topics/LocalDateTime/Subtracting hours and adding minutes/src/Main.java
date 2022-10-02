import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
        long hours = scanner.nextLong();
        long minutes = scanner.nextLong();
        System.out.println(dateTime.minusHours(hours).plusMinutes(minutes));
    }
}