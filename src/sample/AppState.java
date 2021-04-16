package sample;

import javafx.collections.ObservableList;

public class AppState {
    private SearchResults searchResults;
    private User user;

    private final static AppState INSTANCE = new AppState();

    private AppState() {
    }

    public static AppState getInstance() {
        return INSTANCE;
    }

    public SearchResults getSearchResults() {
        return searchResults;
    }

    public void setSearchResult(SearchResults searchResults) {
        this.searchResults = searchResults;
    }

    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return user;
    }
}
