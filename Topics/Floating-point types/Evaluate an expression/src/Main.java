import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();

        final double w1 = 10.5;
        final double w2 = 4.4;
        final double w3 = 2.2;
        double value = a * w1 + b * w2 + (c + d) / w3;
        System.out.println(value);
    }
}