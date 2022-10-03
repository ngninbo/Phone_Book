package phonebook;

import phonebook.search.SearchingStrategy;
import phonebook.search.SortingStrategy;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        try {

            SearchFactory searchFactory = SearchFactoryBuilder.init()
                    .withSearchingContext(new SearchingStrategy())
                    .withSortingContext(new SortingStrategy())
                    .build();

            System.out.println("Start searching (linear search)...");
            long duration = searchFactory.linearSearch();

            System.out.println("\nStart searching (bubble sort + jump search)...");
            searchFactory.jumpingBubbles(duration);

            System.out.println("\nStart searching (quick sort + binary search)...");
            searchFactory.quickBinary();

            System.out.println("\nStart searching (hash table)...");
            searchFactory.instantSearch();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
