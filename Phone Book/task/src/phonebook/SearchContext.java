package phonebook;

import java.util.List;
import java.util.Map;

public interface SearchContext {

    SearchResult<Person> linearSearch(List<Person> people, List<String> names);
    SearchResult<Person> bubbleSort(List<Person> persons, long duration);
    SearchResult<Person> jumpSearch(List<Person> persons, List<String> names);
    int jumpSearch(List<Person> persons, String name);

    SearchResult<Person> quickSort(List<Person> persons);

    SearchResult<Person> binarySearch(List<Person> results, List<String> names);
    int binarySearch(List<Person> persons, int l, int r, String name);

    SearchResult<Person> instantSearch(Map<String, Person> map, List<String> names);
}
