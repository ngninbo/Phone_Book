package phonebook.search;

import phonebook.algorithm.sorting.BaseSort;
import phonebook.model.Person;

import java.util.List;

public interface SortingContext {

    BaseSort bubbleSort(List<Person> persons, long duration);
    BaseSort quickSort(List<Person> persons);
}
