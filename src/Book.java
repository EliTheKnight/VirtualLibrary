public class Book {
    private String title, author;
    private boolean hard_cover;
    private BookType type;

    public Book(String title, String author, boolean hard_cover) {
        this.title = title;
        this.author = author;
        this.hard_cover = hard_cover;
        this.type = BookType.NONE;
    }

    public BookType getType() {
        return type;
    }
}
