package phonebook.search;

import phonebook.model.Person;

import java.util.List;
import java.util.Map;

public interface SearchContext {

    SearchResult<Person> linearSearch(List<Person> people, List<String> names);
    SearchResult<Person> bubbleSort(List<Person> persons, long duration);
    SearchResult<Person> jumpSearch(List<Person> persons, List<String> names);

    SearchResult<Person> quickSort(List<Person> persons);

    SearchResult<Person> binarySearch(List<Person> results, List<String> names);

    SearchResult<Person> instantSearch(Map<String, Person> map, List<String> names);
}
