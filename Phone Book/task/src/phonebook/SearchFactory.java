package phonebook;

import phonebook.algorithm.searching.BaseSearch;
import phonebook.algorithm.searching.InstantSearch;
import phonebook.algorithm.sorting.BaseSort;
import phonebook.model.Person;
import phonebook.search.SearchContext;
import phonebook.search.SortingContext;
import phonebook.search.SortingStrategy;
import phonebook.util.SearchUtil;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchFactory {

    private List<Person> persons;
    private List<String> names;

    private SearchContext searchContext;

    private SortingContext sortingContext;

    public SearchFactory init() throws FileNotFoundException {
        persons = SearchUtil.loadPersons();
        names = SearchUtil.loadNames();

        return this;
    }

    public SearchFactory withContext(SearchContext context) {
        this.searchContext = context;
        return this;
    }

    public SearchFactory withSortingContext(SortingStrategy sortingStrategy) {
        this.sortingContext = sortingStrategy;
        return this;
    }

    public long linearSearch() {
        final BaseSearch search = searchContext.linearSearch(persons, names);
        printOutcome(search.getResults().size(), search.getDuration());
        return search.getDuration();
    }

    public BaseSort bubbleSort(long timeLimit) {
        return sortingContext.bubbleSort(persons, timeLimit);
    }

    public BaseSearch jumpSearch(List<Person> persons) {
        return searchContext.jumpSearch(persons, names);
    }

    public void jumpingBubbles(long lsDuration) {
        BaseSort sorting = this.bubbleSort(lsDuration);
        if (sorting.getPersons().isEmpty()) {
            BaseSearch ls = searchContext.linearSearch(persons, names);
            printOutcome(ls.getResults().size(), sorting.getDuration() + ls.getDuration());
            SearchUtil.printSortDuration(sorting.getDuration());
            ls.printDuration();

        } else {
            BaseSearch jumping = this.jumpSearch(sorting.getPersons());
            printOutcome(jumping.getResults().size(), jumping.getDuration() + sorting.getDuration());
            sorting.printDuration();
            jumping.printDuration();
        }
    }

    public void quickBinary() {
        BaseSort sort = sortingContext.quickSort(persons);
        BaseSearch search = searchContext.binarySearch(sort.getPersons(), names);
        printOutcome(search.getResults().size(), search.getDuration() + sort.getDuration());
        sort.printDuration();
        search.printDuration();
    }

    public void instantSearch() {
        long start = System.currentTimeMillis();
        Map<String, Person> map = IntStream.range(0, persons.size())
                .boxed()
                .collect(Collectors.toMap(value -> persons.get(value).getName(), persons::get, (a, b) -> b));
        long end = System.currentTimeMillis();
        long creationTime = end - start;
        InstantSearch search = searchContext.instantSearch(map, names).perform();

        SearchUtil.printSearchResult(search.getResults().size(), names.size(), search.getDuration() + creationTime);
        SearchUtil.printDuration("Creating", creationTime);
        search.printDuration();
    }

    private void printOutcome(int resultSize, long duration) {
        SearchUtil.printSearchResult(resultSize, names.size(), duration);
    }
}
