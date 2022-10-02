import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        LocalDate date = LocalDate.of(year, month, 1);

        IntStream.range(1, date.lengthOfMonth())
                .mapToObj(date::withDayOfMonth)
                .filter(isMonday())
                .forEach(System.out::println);
    }

    private static Predicate<LocalDate> isMonday() {
        return date -> date.getDayOfWeek().getValue() == 1;
    }
}