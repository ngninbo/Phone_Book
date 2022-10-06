package phonebook;

import phonebook.algorithm.searching.BaseSearch;
import phonebook.algorithm.searching.InstantSearch;
import phonebook.algorithm.sorting.BaseSort;
import phonebook.model.Person;
import phonebook.search.SearchingContext;
import phonebook.search.SortingContext;
import phonebook.util.SearchDuration;
import phonebook.util.SearchUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchFactory {

    private final List<Person> persons;
    private final List<String> names;

    private final SearchingContext searchContext;

    private final SortingContext sortingContext;

    public SearchFactory(List<Person> persons, List<String> names, SearchingContext searchingContext, SortingContext sortingContext) {
        this.persons = persons;
        this.names = names;
        this.searchContext = searchingContext;
        this.sortingContext = sortingContext;
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
            SearchUtil.printSortDuration(new SearchDuration(sorting.getDuration()));
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

        SearchUtil.printSearchResult(search.getResults().size(), names.size(), new SearchDuration(search.getDuration() + creationTime));
        SearchUtil.printDuration("Creating", new SearchDuration(creationTime));
        search.printDuration();
    }

    private void printOutcome(int resultSize, long duration) {
        SearchUtil.printSearchResult(resultSize, names.size(), new SearchDuration(duration));
    }
}
