package phonebook.search;

import phonebook.algorithm.sorting.BaseSort;
import phonebook.algorithm.sorting.BubbleSort;
import phonebook.algorithm.sorting.QuickSort;
import phonebook.model.Person;

import java.util.List;

public class SortingStrategy implements SortingContext {

    @Override
    public BaseSort bubbleSort(List<Person> persons, long limit) {
        return new BubbleSort(persons).withTimeLimit(limit).perform();
    }

    @Override
    public BaseSort quickSort(List<Person> persons) {
        return new QuickSort(persons).perform();
    }
}
