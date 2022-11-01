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
        // TODO: pad with zeros to make sure that the bit before the . is three digits
        String asInt = String.valueOf(Integer.valueOf((int) this.callNo));
        int padLength = 3 - asInt.length();
        return "0".repeat(padLength) + this.callNo;
    }
}
