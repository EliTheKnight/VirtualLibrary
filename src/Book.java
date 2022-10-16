abstract public class Book {
    private String title, author;
    private boolean hard_cover;

    public Book(String title, String author, boolean hard_cover) {
        this.title = title;
        this.author = author;
        this.hard_cover = hard_cover;
    }

    abstract public BookType getType();

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) return false;
        return this.title.equalsIgnoreCase(((Book) obj).title) && this.author.equalsIgnoreCase(((Book) obj).author)
                && this.hard_cover == ((Book) obj).hard_cover;
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

    public static int compare(Book lhs, Book rhs) {
        int callNoRes = lhs.getCallNoAsString().compareTo(rhs.getCallNoAsString());
        if (callNoRes != 0) {
            return callNoRes;
        }
        int authRes = lhs.author.compareTo(rhs.author);
        if (authRes != 0) {
            return authRes;
        }
        return lhs.title.compareTo(rhs.title);
    }
}
