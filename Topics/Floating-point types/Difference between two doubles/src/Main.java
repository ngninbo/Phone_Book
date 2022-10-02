import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double first = scanner.nextDouble();
        double second = scanner.nextDouble();
        double diff = second - first;
        System.out.println(diff);
    }
}