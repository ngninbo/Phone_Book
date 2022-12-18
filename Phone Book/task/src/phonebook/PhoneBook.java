package phonebook;

public class PhoneBook {

    private final SearchFactory searchFactory;

    public PhoneBook(SearchFactory searchFactory) {
        this.searchFactory = searchFactory;
    }

    public void search() {

        long duration = searchFactory.linearSearch();

        searchFactory.jumpingBubbles(duration);

        searchFactory.quickBinary();

        searchFactory.instantSearch();
    }
}
