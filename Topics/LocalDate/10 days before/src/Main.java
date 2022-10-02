import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final long days = 10;
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.println(date.minusDays(days));
    }
}