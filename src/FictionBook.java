public class FictionBook extends Book {
    private String callNo;
    private BookType type;

    public FictionBook(String title, String author, boolean hard_cover, String call_no) {
        super(title, author, hard_cover);
        this.callNo = call_no;
        this.type = BookType.FICTION;
    }
}
