public class NonFictionBook extends Book {
    private float callNo;
    private BookType type;

    public NonFictionBook(String title, String author, boolean hard_cover, float call_no) {
        super(title, author, hard_cover);
        this.callNo = call_no;
        this.type = BookType.NONFICTION;
    }
}
