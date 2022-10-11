public class NonFictionBook extends Book {
    private float call_no;

    public NonFictionBook(String title, String author, boolean hard_cover, float call_no) {
        super(title, author, hard_cover);
        this.call_no = call_no;
    }
}
