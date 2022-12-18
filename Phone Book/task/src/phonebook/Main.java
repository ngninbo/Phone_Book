package phonebook;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        PhoneBookBuilder
                .init()
                .withSearchFactory()
                .build()
                .search();
    }
}
