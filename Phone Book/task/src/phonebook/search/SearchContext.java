package phonebook.search;

import phonebook.algorithm.searching.BaseSearch;
import phonebook.algorithm.searching.InstantSearch;
import phonebook.algorithm.sorting.BaseSort;
import phonebook.model.Person;

import java.util.List;
import java.util.Map;

public interface SearchContext {

    BaseSearch linearSearch(List<Person> people, List<String> names);
    BaseSort bubbleSort(List<Person> persons, long duration);
    BaseSearch jumpSearch(List<Person> persons, List<String> names);

    BaseSort quickSort(List<Person> persons);

    BaseSearch binarySearch(List<Person> results, List<String> names);

    InstantSearch instantSearch(Map<String, Person> map, List<String> names);
}
