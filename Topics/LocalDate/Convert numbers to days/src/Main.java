import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        final int numOfDays = 3;
        List<Integer> inputs = IntStream.range(0, numOfDays)
                .mapToObj(i -> scanner.nextInt())
                .collect(Collectors.toList());

        inputs.forEach(dayOfYear -> System.out.println(LocalDate.ofYearDay(year, dayOfYear)));
    }
}