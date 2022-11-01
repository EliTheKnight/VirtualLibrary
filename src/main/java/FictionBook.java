public class FictionBook extends Book {
    private String callNo;

    public FictionBook(String title, String author, boolean hard_cover, String call_no) {
        super(title, author, hard_cover);
        this.callNo = call_no;
    }

    public BookType getType() {
        return BookType.FICTION;
    }

    public boolean equals(FictionBook other) {
        return super.equals(other) && this.callNo.equalsIgnoreCase(other.callNo);
    }

    public String toString() {
        String tmp = super.toString();
        return tmp.substring(0, tmp.length() - 1) + ", " + callNo + ")";
    }

    public void setCallNo(String callNo) {
        this.callNo = callNo;
    }

    public String getCallNoAsString() {
        return callNo;
    }
}
