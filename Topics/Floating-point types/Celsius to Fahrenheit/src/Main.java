import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double tempC = scanner.nextDouble();
        final int therm = 32;
        final double factor = 1.8;
        double tempF = tempC * factor + therm;
        System.out.println(tempF);
    }
}