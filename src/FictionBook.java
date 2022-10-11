public class FictionBook extends Book {
    private String call_no;

    public FictionBook(String title, String author, boolean hard_cover, String call_no) {
        super(title, author, hard_cover);
        this.call_no = call_no;
    }
}
