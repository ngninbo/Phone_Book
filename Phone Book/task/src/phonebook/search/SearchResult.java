package phonebook.search;

import phonebook.SearchUtil;

import java.util.List;

public class SearchResult<T> {

    private String opt;
    private long duration;
    private List<T> results;

    public SearchResult(String opt, long duration, List<T> results) {
        this.opt = opt;
        this.duration = duration;
        this.results = results;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
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

    public void printDuration() {
        SearchUtil.printDuration(opt, duration);
    }
}
