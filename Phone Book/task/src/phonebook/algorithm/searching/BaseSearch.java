package phonebook.algorithm.searching;

import phonebook.model.Person;
import phonebook.search.SearchResult;
import phonebook.SearchUtil;

import java.util.List;

public abstract class BaseSearch {

    public List<Person> persons;
    public List<String> names;
    public long duration;
    public List<Person> results;

    public BaseSearch(List<Person> persons, List<String> names) {
        this.persons = persons;
        this.names = names;
    }

    public abstract SearchResult<Person> perform();


    public void printDuration() {
        SearchUtil.printDuration("Searching", duration);
    }
}
