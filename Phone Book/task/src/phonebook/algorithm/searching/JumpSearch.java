package phonebook.algorithm.searching;

import phonebook.model.Person;

import java.util.ArrayList;
import java.util.List;

public class JumpSearch extends BaseSearch {

    public JumpSearch(List<Person> persons, List<String> names) {
        super(persons, names);
    }

    @Override
    public BaseSearch perform() {
        long start = System.currentTimeMillis();
        results = search(names);

        long end = System.currentTimeMillis();
        duration = end - start;

        return this;
    }

    @Override
    public List<Person> search(List<String> names) {
        List<Person> results = new ArrayList<>();
        int idx;
        for (String name : names) {
            idx = jumpSearch(persons, name);
            if (idx != -1) {
                results.add(persons.get(idx));
            }
        }
        return results;
    }


    public static int jumpSearch(List<Person> sortedPersons, String name) {
        int n = sortedPersons.size();
        int prev = 0;

        int step = (int) Math.floor(Math.sqrt(n));

        while (sortedPersons.get(Math.min(step, n) - 1).getName().compareTo(name) < 0) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        while (sortedPersons.get(prev).getName().compareTo(name) < 0) {
            prev++;

            if (prev == Math.min(step, n))
                return -1;
        }

        if (sortedPersons.get(prev).getName().compareTo(name) == 0)
            return prev;

        return -1;
    }
}
