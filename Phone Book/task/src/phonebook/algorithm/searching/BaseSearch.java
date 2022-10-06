package phonebook.algorithm.searching;

import phonebook.model.Person;
import phonebook.util.SearchDuration;
import phonebook.util.SearchUtil;

import java.util.List;

public abstract class BaseSearch {

    private static final String OPERATION = "Searching";

    protected List<Person> persons;
    protected List<String> names;
    protected long duration;
    protected List<Person> results;

    public BaseSearch(List<Person> persons, List<String> names) {
        this.persons = persons;
        this.names = names;
    }

    public abstract BaseSearch perform();

    public abstract List<Person> search(List<String> names);

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public List<Person> getResults() {
        return results;
    }

    public void printDuration() {
        SearchUtil.printDuration(OPERATION, new SearchDuration(duration));
    }
}
