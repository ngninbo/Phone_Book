import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double u1 = scanner.nextDouble();
        double u2 = scanner.nextDouble();
        double v1 = scanner.nextDouble();
        double v2 = scanner.nextDouble();

        double prod = u1 * v1 + u2 * v2;
        double u = Math.sqrt(Math.pow(u1, 2) +  Math.pow(u2, 2));
        double v = Math.sqrt(Math.pow(v1, 2) +  Math.pow(v2, 2));
        final double grad = Math.acos(prod / (u * v));
        double angle = Math.toDegrees(grad);
        System.out.println(angle);
    }
}