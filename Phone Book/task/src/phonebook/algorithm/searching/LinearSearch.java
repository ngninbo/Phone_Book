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

        results = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (String name : names) {
            for (Person person : persons) {
                if (person.getName().equals(name)) {
                    results.add(person);
                }
            }
        }
        long end = System.currentTimeMillis();

        duration = end - start;

        return this;
    }
}
