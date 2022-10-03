package phonebook.search;

import phonebook.algorithm.searching.BaseSearch;
import phonebook.algorithm.searching.InstantSearch;
import phonebook.model.Person;

import java.util.List;
import java.util.Map;

public interface SearchingContext {

    BaseSearch linearSearch(List<Person> people, List<String> names);
    BaseSearch jumpSearch(List<Person> persons, List<String> names);
    BaseSearch binarySearch(List<Person> results, List<String> names);

    InstantSearch instantSearch(Map<String, Person> map, List<String> names);
}
