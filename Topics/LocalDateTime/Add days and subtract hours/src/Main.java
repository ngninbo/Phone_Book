import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        LocalDateTime dateTime = LocalDateTime.parse(inputs[0]);
        System.out.println(dateTime
                .plusDays(Long.parseLong(inputs[1]))
                .minusHours(Long.parseLong(inputs[2])));
    }
}