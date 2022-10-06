package phonebook.algorithm.searching;

import phonebook.model.Person;
import phonebook.util.SearchDuration;
import phonebook.util.SearchUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InstantSearch {

    private static final String OPERATION = "Searching";

    private Map<String, Person> persons;
    private final List<String> names;
    private List<Person> results;
    private long duration;


    public InstantSearch(Map<String, Person> persons, List<String> names) {
        this.persons = persons;
        this.names = names;
    }

    public InstantSearch perform() {
        long start = System.currentTimeMillis();
        results = names.stream()
                .filter(persons::containsKey)
                .map(persons::get)
                .collect(Collectors.toList());

        long end = System.currentTimeMillis();
        duration = end - start;

        return this;
    }

    public Map<String, Person> getPersons() {
        return persons;
    }

    public void setPersons(Map<String, Person> persons) {
        this.persons = persons;
    }

    public List<Person> getResults() {
        return results;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void printDuration() {
        SearchUtil.printDuration(OPERATION, new SearchDuration(duration));
    }
}
