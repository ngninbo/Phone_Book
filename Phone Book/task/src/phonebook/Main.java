package phonebook;

import phonebook.search.SearchStrategy;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        try {

            SearchFactory searchFactory = new SearchFactory().init().withContext(new SearchStrategy());

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
