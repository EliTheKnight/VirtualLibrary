public class NonFictionBook extends Book {
    private float callNo;

    public NonFictionBook(String title, String author, boolean hard_cover, float call_no) {
        super(title, author, hard_cover);
        this.callNo = call_no;
    }

    public BookType getType() {
        return BookType.NONFICTION;
    }

    public boolean equals(NonFictionBook other) {
        return super.equals(other) && this.callNo == other.callNo;
    }

    public String toString() {
        String tmp = super.toString();
        return tmp.substring(0, tmp.length() - 1) + ", " + callNo + ")";
    }

    public void setCallNo(float callNo) {
        this.callNo = callNo;
    }

    public String getCallNoAsString() {
        return Float.valueOf(this.callNo).toString().replace(".", "");
    }
}
