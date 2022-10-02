package phonebook.search;

import phonebook.algorithm.searching.BinarySearch;
import phonebook.algorithm.searching.JumpSearch;
import phonebook.algorithm.searching.LinearSearch;
import phonebook.algorithm.sorting.BubbleSort;
import phonebook.algorithm.sorting.QuickSort;
import phonebook.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchStrategy implements SearchContext {

    public SearchResult<Person> linearSearch(List<Person> persons, List<String> names) {
        return new LinearSearch(persons, names).perform();
    }

    public SearchResult<Person> bubbleSort(List<Person> persons, long limit) {
        return new BubbleSort(persons).perform(limit);
    }

    public SearchResult<Person> jumpSearch(List<Person> persons, List<String> names) {
        return new JumpSearch(persons, names).perform();
    }

    @Override
    public SearchResult<Person> quickSort(List<Person> persons) {
       return new QuickSort(persons).quickSort();
    }

    @Override
    public SearchResult<Person> binarySearch(List<Person> persons, List<String> names) {
        return new BinarySearch(persons, names).perform();
    }

    @Override
    public SearchResult<Person> instantSearch(Map<String, Person> map, List<String> names) {

        List<Person> searchResult = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (String name : names) {
            if (map.containsKey(name)) {
                searchResult.add(map.get(name));
            }
        }

        long end = System.currentTimeMillis();
        long searchDuration = end - start;

        return new SearchResult<>("Searching", searchDuration, searchResult);
    }
}
