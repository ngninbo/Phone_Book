import java.util.Scanner;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        subtractFromEpoch(scanner.nextInt(), scanner.next());
    } 

    public static void subtractFromEpoch(int days, String zone) {
        System.out.println(Instant.EPOCH.minus(Duration.ofDays(days)).atZone(ZoneId.of(zone)));
    }
}