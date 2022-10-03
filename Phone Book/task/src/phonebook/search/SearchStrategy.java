package phonebook.search;

import phonebook.algorithm.searching.*;
import phonebook.algorithm.sorting.BaseSort;
import phonebook.algorithm.sorting.BubbleSort;
import phonebook.algorithm.sorting.QuickSort;
import phonebook.model.Person;

import java.util.List;
import java.util.Map;

public class SearchStrategy implements SearchContext {

    public BaseSearch linearSearch(List<Person> persons, List<String> names) {
        return new LinearSearch(persons, names).perform();
    }

    public BaseSort bubbleSort(List<Person> persons, long limit) {
        return new BubbleSort(persons).perform(limit);
    }

    public BaseSearch jumpSearch(List<Person> persons, List<String> names) {
        return new JumpSearch(persons, names).perform();
    }

    @Override
    public BaseSort quickSort(List<Person> persons) {
       return new QuickSort(persons).quickSort();
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
