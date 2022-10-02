import java.time.LocalDate;
import java.util.Scanner;

class Main {

    private static final int NUM_YEARS = 30;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.println(date.minusYears(NUM_YEARS));
        System.out.println(date.plusYears(NUM_YEARS));
    }
}