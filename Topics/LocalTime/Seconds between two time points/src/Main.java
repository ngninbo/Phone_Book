import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime t1 = LocalTime.parse(scanner.nextLine());
        LocalTime t2 = LocalTime.parse(scanner.nextLine());
        System.out.println(Math.abs(t2.toSecondOfDay() - t1.toSecondOfDay()));
    }
}