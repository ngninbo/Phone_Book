package phonebook.search;

import phonebook.algorithm.searching.*;
import phonebook.model.Person;

import java.util.List;
import java.util.Map;

public class SearchingStrategy implements SearchingContext {

    public BaseSearch linearSearch(List<Person> persons, List<String> names) {
        return new LinearSearch(persons, names).perform();
    }

    public BaseSearch jumpSearch(List<Person> persons, List<String> names) {
        return new JumpSearch(persons, names).perform();
    }

    @Override
    public BaseSearch binarySearch(List<Person> persons, List<String> names) {
        return new BinarySearch(persons, names).perform();
    }

    @Override
    public InstantSearch instantSearch(Map<String, Person> map, List<String> names) {
        return new InstantSearch(map, names);
    }
}
