abstract public class Book {
    private String title, author;
    private boolean hard_cover;

    public Book(String title, String author, boolean hard_cover) {
        this.title = title;
        this.author = author;
        this.hard_cover = hard_cover;
    }

    public BookType getType() {
        return BookType.NONE;
    }

    public boolean equals(Book other) {
        return this.title.equalsIgnoreCase(other.title) && this.author.equalsIgnoreCase(other.author)
                && this.hard_cover == other.hard_cover;
    }

    public String toString() {
        return "(" + title + ", " + author + ", " + hard_cover + ")";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isHard_cover() {
        return hard_cover;
    }

    public void setHard_cover(boolean hard_cover) {
        this.hard_cover = hard_cover;
    }

    abstract public String getCallNoAsString();
}
