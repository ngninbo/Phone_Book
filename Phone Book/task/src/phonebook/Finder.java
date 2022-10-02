package phonebook;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Finder {

    private final List<Person> persons;
    private final List<String> names;

    private final SearchContext cxt;

    public Finder(List<Person> persons, List<String> names, SearchContext context) {
        this.persons = persons;
        this.names = names;
        this.cxt = context;
    }

    public SearchResult<Person> linearSearch() {
        return cxt.linearSearch(persons, names);
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
            var ls = this.linearSearch();
            SearchUtil.printSearchResult(ls.getResults().size(), names.size(), sorting.getDuration() + ls.getDuration());
            SearchUtil.printSortDuration(sorting.getDuration());
            SearchUtil.printDuration("Searching", ls.getDuration());

        } else {
            var jumping = this.jumpSearch(sorting.getResults());
            SearchUtil.printSearchResult(jumping.getResults().size(), names.size(), jumping.getDuration() + sorting.getDuration());
            SearchUtil.printDuration("Sorting", sorting.getDuration());
            SearchUtil.printDuration("Searching", jumping.getDuration());
        }
    }

    public void quickBinary() {
        var sort = cxt.quickSort(persons);
        var search = cxt.binarySearch(sort.getResults(), names);
        SearchUtil.printSearchResult(search.getResults().size(), names.size(), search.getDuration() + sort.getDuration());
        SearchUtil.printDuration("Sorting", sort.getDuration());
        SearchUtil.printDuration("Searching", search.getDuration());
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
        SearchUtil.printDuration("Searching", search.getDuration());
    }
}
