package phonebook.algorithm.sorting;

import phonebook.model.Person;
import phonebook.search.SearchResult;

import java.util.List;

public class BubbleSort extends BaseSort {

    public BubbleSort(List<Person> persons) {
        super(persons);
    }

    public SearchResult<Person> perform(long limit) {
        int n = persons.size();

        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Person current = persons.get(i);
                Person next = persons.get(j);

                if (current.getName().compareTo(next.getName()) > 0) {
                    persons.set(i, next);
                    persons.set(j, current);
                }

                long tmp = System.currentTimeMillis();

                final long tmpDuration = tmp - start;
                duration = tmpDuration;
                if (tmpDuration > 10 * limit) {
                    return new SearchResult<>("Sorting", duration, List.of());
                }
            }
        }
        long end = System.currentTimeMillis();

        duration = end - start;

        return new SearchResult<>("Sorting", duration, persons);
    }
}
