package phonebook;

import phonebook.model.Person;
import phonebook.search.SearchStrategy;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            List<Person> persons = SearchUtil.getPersons();
            List<String> names = SearchUtil.loadNames();

            PhoneRepository phoneRepository = new PhoneRepository(persons, names, new SearchStrategy());

            System.out.println("Start searching (linear search)...");
            long duration = phoneRepository.linearSearch();

            System.out.println("\nStart searching (bubble sort + jump search)...");
            phoneRepository.jumpingBubbles(duration);

            System.out.println("\nStart searching (quick sort + binary search)...");
            phoneRepository.quickBinary();

            System.out.println("\nStart searching (hash table)...");
            phoneRepository.instantSearch();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
