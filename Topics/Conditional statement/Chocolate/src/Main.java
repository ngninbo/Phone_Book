import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(isBreakable(n, m, k) ? "YES" : "NO");
    }

    private static boolean isBreakable(int n, int m, int k) {
        return k % n == 0 && k / n < m || (k % m == 0 && k / m < n);
    }
}