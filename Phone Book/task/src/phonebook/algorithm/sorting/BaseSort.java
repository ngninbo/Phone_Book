package phonebook.algorithm.sorting;

import phonebook.model.Person;
import phonebook.util.SearchDuration;
import phonebook.util.SearchUtil;

import java.util.List;

public abstract class BaseSort {

    private static final String OPERATION = "Sorting";
    protected List<Person> persons;
    protected long duration;

    public BaseSort(List<Person> persons) {
        this.persons = persons;
    }

    public abstract BaseSort perform();

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void printDuration() {
        SearchUtil.printDuration(OPERATION, new SearchDuration(duration));
    }
}
