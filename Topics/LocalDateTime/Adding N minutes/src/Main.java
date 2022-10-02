import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine()).plusMinutes(scanner.nextLong());
        System.out.printf("%s %s %s", dateTime.getYear(), dateTime.getDayOfYear(), dateTime.toLocalTime());
    }
}