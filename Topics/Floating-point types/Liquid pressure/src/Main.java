import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double rho = scanner.nextDouble();
        double height = scanner.nextDouble();
        final double ga = 9.8;
        double pressure = rho * ga * height;
        System.out.println(pressure);
    }
}