package phonebook.algorithm.sorting;

import phonebook.model.Person;

import java.util.List;

public abstract class BaseSort {
    public List<Person> persons;
    public long duration;

    public BaseSort(List<Person> persons) {
        this.persons = persons;
    }
}
