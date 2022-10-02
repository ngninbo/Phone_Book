import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.util.function.Predicate;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scanner.nextLine());
        int offset = scanner.nextInt();
        date.datesUntil(date.plusYears(1), Period.ofDays(offset))
                .filter(isSameYear(date))
                .forEach(System.out::println);
    }

    private static Predicate<LocalDate> isSameYear(LocalDate date) {
        return d -> d.getYear() == date.getYear();
    }
}