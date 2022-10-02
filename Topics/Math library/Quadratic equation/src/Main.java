import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        final int magic = 4;
        double delta = Math.pow(b, 2) - (magic * a * c);
        double x1 = (Math.sqrt(delta) - b) / (2 * a);
        double x2 = (-1) * (Math.sqrt(delta) + b) / (2 * a);
        System.out.printf("%s %s", Math.min(x1, x2), Math.max(x1, x2));
    }
}