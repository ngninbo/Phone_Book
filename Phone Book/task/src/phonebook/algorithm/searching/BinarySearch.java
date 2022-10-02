package phonebook.algorithm.searching;

import phonebook.model.Person;
import phonebook.search.SearchResult;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch extends BaseSearch {

    public BinarySearch(List<Person> persons, List<String> names) {
        super(persons, names);
    }

    @Override
    public SearchResult<Person> perform() {
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
        return new SearchResult<>("Searching", duration, results);
    }

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
}
