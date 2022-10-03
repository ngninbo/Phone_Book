package phonebook;

import phonebook.model.Person;
import phonebook.search.SearchingContext;
import phonebook.search.SortingContext;
import phonebook.util.SearchUtil;

import java.io.FileNotFoundException;
import java.util.List;

public class SearchFactoryBuilder {

    private final List<Person> persons;
    private final List<String> names;

    private SearchingContext searchContext;

    private SortingContext sortingContext;

    private SearchFactoryBuilder() throws FileNotFoundException {
        persons = SearchUtil.loadPersons();
        names = SearchUtil.loadNames();
    }

    public static SearchFactoryBuilder init() throws FileNotFoundException {
        return new SearchFactoryBuilder();
    }

    public SearchFactoryBuilder withSearchingContext(SearchingContext cxt) {
        this.searchContext = cxt;
        return this;
    }

    public SearchFactoryBuilder withSortingContext(SortingContext cxt) {
        this.sortingContext = cxt;
        return this;
    }

    public SearchFactory build() {
        return new SearchFactory(persons, names, searchContext, sortingContext);
    }
}
