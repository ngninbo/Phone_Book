package phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchStrategy implements SearchContext {

    public SearchResult<Person> linearSearch(List<Person> persons, List<String> names) {

        List<Person> results = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (String name : names) {
            for (Person person : persons) {
                if (person.getName().equals(name)) {
                    results.add(person);
                }
            }
        }
        long end = System.currentTimeMillis();

        long duration = end - start;

        return new SearchResult<>("linear search", duration, results);
    }

    public SearchResult<Person> bubbleSort(List<Person> persons, long limit) {

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
                if (tmpDuration > 10 * limit) {
                    return new SearchResult<>("Bubble sort", tmpDuration, List.of());
                }
            }
        }
        long end = System.currentTimeMillis();

        long duration = end - start;

        return new SearchResult<>("Bubble sort", duration, persons);
    }

    public SearchResult<Person> jumpSearch(List<Person> persons, List<String> names) {
        List<Person> results = new ArrayList<>();
        int idx;

        long start = System.currentTimeMillis();
        for (String name : names) {
            idx = jumpSearch(persons, name);
            if (idx != -1) {
                results.add(persons.get(idx));
            }
        }

        long end = System.currentTimeMillis();
        long duration = end - start;

        return new SearchResult<>("jump search", duration, results);
    }

    public int jumpSearch(List<Person> sortedPersons, String name) {
        int n = sortedPersons.size();
        int prev = 0;

        int step = (int) Math.floor(Math.sqrt(n));

        while (sortedPersons.get(Math.min(step, n) - 1).getName().compareTo(name) < 0)
        {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        while (sortedPersons.get(prev).getName().compareTo(name) < 0)
        {
            prev++;

            if (prev == Math.min(step, n))
                return -1;
        }

        if (sortedPersons.get(prev).getName().compareTo(name) == 0)
            return prev;

        return -1;
    }

    @Override
    public SearchResult<Person> quickSort(List<Person> persons) {
        long start = System.currentTimeMillis();
        QuickSort.quickSort(persons, 0, persons.size() - 1);
        long end = System.currentTimeMillis();
        long duration = end - start;
        return new SearchResult<>("Quick sort", duration, persons);
    }

    @Override
    public SearchResult<Person> binarySearch(List<Person> persons, List<String> names) {
        List<Person> results = new ArrayList<>();
        int idx;

        long start = System.currentTimeMillis();
        for (String name : names) {
            idx = binarySearch(persons, 0, persons.size(), name);
            if (idx != -1) {
                results.add(persons.get(idx));
            }
        }

        long end = System.currentTimeMillis();
        long duration = end - start;
        return new SearchResult<>("Binary search", duration, results);
    }

    @Override
    public int binarySearch(List<Person> list, int left, int right, String name) {

        if (right >= left) {
            int middle = left + (right - left) / 2;

            if (list.get(middle).getName().compareTo(name) == 0)
                return middle;

            if (list.get(middle).getName().compareTo(name) > 0)
                return binarySearch(list, left, middle - 1, name);

            return binarySearch(list, middle + 1, right, name);
        }

        return -1;
    }

    @Override
    public SearchResult<Person> instantSearch(Map<String, Person> map, List<String> names) {

        List<Person> searchResult = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (String name : names) {
            if (map.containsKey(name)) {
                searchResult.add(map.get(name));
            }
        }

        long end = System.currentTimeMillis();
        long searchDuration = end - start;

        return new SearchResult<>("Instant search", searchDuration, searchResult);
    }
}
