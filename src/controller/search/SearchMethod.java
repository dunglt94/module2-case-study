package controller.search;

public class SearchMethod {
    private SearchStrategy strategy;

    public void setSearchStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public void search() {
        strategy.search();
    }
}
