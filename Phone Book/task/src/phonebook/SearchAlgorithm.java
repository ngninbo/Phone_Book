package phonebook;

import java.util.List;

public class SearchAlgorithm<T> {

    private String name;
    private long duration;
    private List<T> results;

    public SearchAlgorithm(String name, long duration, List<T> results) {
        this.name = name;
        this.duration = duration;
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
