import java.util.ArrayList;
import java.util.HashMap;

public class Catalog {
    private HashMap<BookType, ArrayList<Book>> catalog;

    public void addBook(Book in) {
        if (!catalog.containsKey(in.getType())) {
            ArrayList<Book> new_catalog_part = new ArrayList<>();
            new_catalog_part.add(in);
            catalog.put(in.getType(), new_catalog_part);
        } else {
            catalog.get(in.getType()).add(in);
        }
    }

    public Catalog() {
    }
}
