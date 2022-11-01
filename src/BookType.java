public enum BookType {
    FICTION {
        public Book fromString(String[] in) throws NumberFormatException {
            // Title and author are strings
            boolean hardCover = Boolean.parseBoolean(in[2]);
            return new FictionBook(in[0], in[1], hardCover, in[3]);
        }
    },
    NONFICTION {
        public Book fromString(String[] in) throws NumberFormatException {
            // Title and author are strings
            boolean hardCover = Boolean.parseBoolean(in[2]);
            float callNo = Float.parseFloat(in[3]);
            return new NonFictionBook(in[0], in[1], hardCover, callNo);
        }
    };

    public abstract Book fromString(String[] in);
}
