package games;

 interface Cell<T> {
    boolean isBomb();
    boolean isSuggestEmpty();
    void suggestEmpty();
    void suggestBomb();
    void draw();
}