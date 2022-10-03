package phonebook.algorithm.searching;

import phonebook.model.Person;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch extends BaseSearch {

    public LinearSearch(List<Person> persons, List<String> names) {
        super(persons, names);
    }

    @Override
    public LinearSearch perform() {

        long start = System.currentTimeMillis();
        results = search(names);
        long end = System.currentTimeMillis();

        duration = end - start;

        return this;
    }

    @Override
    public List<Person> search(List<String> names) {

        List<Person> results = new ArrayList<>();

        for (String name : names) {
            for (Person person : persons) {
                if (person.getName().equals(name)) {
                    results.add(person);
                }
            }
        }

        return results;
    }
}
