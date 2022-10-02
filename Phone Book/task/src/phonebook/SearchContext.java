package phonebook;

import java.util.List;
import java.util.Map;

public interface SearchContext {

    SearchAlgorithm<Person> linearSearch(List<Person> people, List<String> names);
    SearchAlgorithm<Person> bubbleSort(List<Person> persons, long duration);
    SearchAlgorithm<Person> jumpSearch(List<Person> persons, List<String> names);
    int jumpSearch(List<Person> persons, String name);

    SearchAlgorithm<Person> quickSort(List<Person> persons);

    SearchAlgorithm<Person> binarySearch(List<Person> results, List<String> names);
    int binarySearch(List<Person> persons, int l, int r, String name);

    SearchAlgorithm<Person> instantSearch(Map<String, Person> map, List<String> names);
}
