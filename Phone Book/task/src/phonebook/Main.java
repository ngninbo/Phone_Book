package phonebook;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            List<Person> persons = SearchUtil.getPersons();
            List<String> names = SearchUtil.loadNames();

            Finder finder = new Finder(persons, names, new SearchStrategy());

            System.out.println("Start searching (linear search)...");
            SearchAlgorithm<Person> linearSearch = finder.linearSearch();
            SearchUtil.printSearchResult(linearSearch.getResults().size(), names.size(), linearSearch.getDuration());

            System.out.println("\nStart searching (bubble sort + jump search)...");
            finder.jumpingBubbles(linearSearch.getDuration());

            System.out.println("\nStart searching (quick sort + binary search)...");
            finder.quickBinary();

            System.out.println("\nStart searching (hash table)...");
            finder.instantSearch();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
