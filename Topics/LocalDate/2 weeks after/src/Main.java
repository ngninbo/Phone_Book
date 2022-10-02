import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final long days = 14;
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.println(date.plusDays(days));
    }
}