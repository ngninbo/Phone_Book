package phonebook.util;

public class SearchDuration {

    private static final long millisecond = 1000; //s
    private static final long minute = 60; // s

    private final long minutes;
    private final long seconds;
    private final long milliseconds;

    public SearchDuration(long duration) {
        minutes = duration / (minute * millisecond);
        seconds = duration % (minute * millisecond) / millisecond;
        milliseconds = duration % (minute * millisecond) % millisecond;
    }

    public long getMinutes() {
        return minutes;
    }

    public long getSeconds() {
        return seconds;
    }

    public long getMilliseconds() {
        return milliseconds;
    }
}
