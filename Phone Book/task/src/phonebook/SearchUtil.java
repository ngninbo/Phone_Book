package phonebook;

import phonebook.model.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchUtil {

    public static final String DIRECTORY_PATH = "/Users/bdongmo-ngnintedem/Downloads/directory.txt";
    public static final String FIND_PATH = "/Users/bdongmo-ngnintedem/Downloads/find.txt";

    private static final long millisecond = 1000; //s
    private static final long minute = 60; // s

    public static List<Person> getPersons() throws FileNotFoundException {
        List<Person> persons = new ArrayList<>();
        File file = new File(DIRECTORY_PATH);

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            final Pattern pattern = Pattern.compile("\\d+");
            final Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String number = matcher.group();
                String name = line.replace(number, "").trim();
                Person person = new Person(number, name);
                persons.add(person);
            }
        }

        return persons;
    }

    public static List<String> loadNames() throws FileNotFoundException {
        List<String> names = new ArrayList<>();
        File file = new File(FIND_PATH);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            names.add(scanner.nextLine());
        }

        return names;
    }

    public static void printSearchResult(int resultLength, int searchLength, long duration) {
        final long minutes = duration / (minute * millisecond);
        final long seconds = duration % (minute * millisecond) / millisecond;
        final long milliseconds = duration % (minute * millisecond) % millisecond;
        System.out.printf("Found %d / %d entries. Time taken: %d min. %d sec. %d ms.\n",
                resultLength, searchLength, minutes, seconds, milliseconds);
    }

    public static void printDuration(String opt, long duration) {
        final long minutes = duration / (minute * millisecond);
        final long seconds = duration % (minute * millisecond) / millisecond;
        final long milliseconds = duration % (minute * millisecond) % millisecond;
        System.out.printf("%s time: %d min. %d sec. %d ms.\n", opt, minutes, seconds, milliseconds);
    }

    public static void printSortDuration(long duration) {
        final long minutes = duration / (minute * millisecond);
        final long seconds = duration % (minute * millisecond) / millisecond;
        final long milliseconds = duration % (minute * millisecond) % millisecond;
        System.out.printf("Sorting time: %d min. %d sec. %d ms. - STOPPED, moved to linear search\n", minutes, seconds, milliseconds);
    }
}
