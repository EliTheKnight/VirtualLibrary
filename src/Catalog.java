import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Catalog {
    @SuppressWarnings("FieldMayBeFinal")
    private HashMap<BookType, ArrayList<Book>> catalog;
    // TODO: storage

    public void addBook(Book in) {
        if (!catalog.containsKey(in.getType())) {
            ArrayList<Book> new_catalog_part = new ArrayList<>();
            new_catalog_part.add(in);
            catalog.put(in.getType(), new_catalog_part);
        } else {
            catalog.get(in.getType()).add(in);
        }
    }

    public boolean removeBook(Book in) {
        // Finds a book that's equal to the in book and removes it.
        if (!catalog.containsKey(in.getType())) {
            // Nothing to remove, it's not there at all
            return false;
        }
        catalog.get(in.getType()).removeIf(in::equals);
        return true;
    }

    public boolean findBook(Book in) {
        return catalog.containsKey(in.getType()) && catalog.get(in.getType()).contains(in);
    }

    public void clear() {
        // Clear catalog
        for (ArrayList<Book> list : catalog.values()) {
            list.clear();
        }
        catalog.clear();
    }

    public void sort() {
        // Sort each sub-catalog individually and then sort the whole thing by BookType.
        // The TreeMap naturally sorts the elements by key.
        for (ArrayList<Book> list : catalog.values()) {
            list.sort(Book::compare);
        }
    }

    public ArrayList<Book> getCatalog() {
        ArrayList<Book> res = new ArrayList<>();
        for (ArrayList<Book> list : catalog.values()) {
            res.addAll(list);
        }
        return res;
    }

    public Catalog() {
        catalog = new HashMap<>();
    }
}
