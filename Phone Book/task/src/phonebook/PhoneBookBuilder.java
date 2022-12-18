package phonebook;

import phonebook.search.SearchingStrategy;
import phonebook.search.SortingStrategy;

import java.io.FileNotFoundException;

public class PhoneBookBuilder {

    private SearchFactory searchFactory;

    private PhoneBookBuilder() {
    }

    public static PhoneBookBuilder init() {
        return new PhoneBookBuilder();
    }

    public PhoneBookBuilder withSearchFactory() throws FileNotFoundException {
        this.searchFactory = SearchFactoryBuilder.init()
                .withSearchingContext(new SearchingStrategy())
                .withSortingContext(new SortingStrategy())
                .build();

        return this;
    }

    public PhoneBook build() {
        return new PhoneBook(searchFactory);
    }
}
