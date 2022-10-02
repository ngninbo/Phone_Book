package phonebook;

import phonebook.model.Person;
import phonebook.search.SearchContext;
import phonebook.search.SearchResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PhoneRepository {

    private final List<Person> persons;
    private final List<String> names;

    private final SearchContext cxt;

    public PhoneRepository(List<Person> persons, List<String> names, SearchContext context) {
        this.persons = persons;
        this.names = names;
        this.cxt = context;
    }

    public long linearSearch() {
        final SearchResult<Person> search = cxt.linearSearch(persons, names);
        SearchUtil.printSearchResult(search.getResults().size(), names.size(), search.getDuration());
        return search.getDuration();
    }

    public SearchResult<Person> bubbleSort(long timeLimit) {
        return cxt.bubbleSort(persons, timeLimit);
    }

    public SearchResult<Person> jumpSearch(List<Person> persons) {
        return cxt.jumpSearch(persons, names);
    }

    public void jumpingBubbles(long lsDuration) {
        var sorting = this.bubbleSort(lsDuration);
        if (sorting.getResults().isEmpty()) {
            var ls = cxt.linearSearch(persons, names);
            printOutcome(sorting.getDuration(), ls.getResults().size(), ls.getDuration());
            SearchUtil.printSortDuration(sorting.getDuration());
            ls.printDuration();

        } else {
            var jumping = this.jumpSearch(sorting.getResults());
            printOutcome(jumping.getDuration(), jumping.getResults().size(), sorting.getDuration());
            sorting.printDuration();
            jumping.printDuration();
        }
    }

    public void quickBinary() {
        var sort = cxt.quickSort(persons);
        var search = cxt.binarySearch(sort.getResults(), names);
        printOutcome(search.getDuration(), search.getResults().size(), sort.getDuration());
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
        var search = cxt.instantSearch(map, names);

        SearchUtil.printSearchResult(search.getResults().size(), names.size(), search.getDuration() + creationTime);
        SearchUtil.printDuration("Creating", creationTime);
        search.printDuration();
    }

    private void printOutcome(long sortingTime, int resultSize, long duration) {
        SearchUtil.printSearchResult(resultSize, names.size(), sortingTime + duration);
    }
}
