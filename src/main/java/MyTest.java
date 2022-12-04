import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {
    @Test
    public void addingBooks() {
        Book book = new FictionBook("abc", "aaa", false, "AAA");
        Catalog cat = new Catalog();
        cat.addBook(book);
        assertTrue(cat.findBook(book));
    }
    
    @Test
    @Disabled("Takes too long lmao")
    public void catalogStressSorting() {
        Catalog cat = new Catalog();

        long before = System.nanoTime();

        ArrayList<String> allPossibleAuthors = new ArrayList<>();
        char author1 = 'a', author2 = 'a', author3 = 'a';
        while (author1 != 'z') {
            author3++;
            if (author3 == 'z' + 1) {
                author3 = 'a';
                author2++;
            }
            if (author2 == 'z' + 1) {
                author2 = 'a';
                author1++;
            }
            String author = String.valueOf(author1) + author2 + author3;
            allPossibleAuthors.add(author);
        }
        Collections.shuffle(allPossibleAuthors);

        ArrayList<String> allPossibleNames = new ArrayList<>();
        char name1 = 'a', name2 = 'a';
        while (name1 != 'z') {
            name2++;
            if (name2 == 'z' + 1) {
                name2 = 'a';
                name1++;
            }
            String name = String.valueOf(name1) + name2;
            allPossibleNames.add(name);
        }
        Collections.shuffle(allPossibleNames);
        System.out.println(allPossibleAuthors.size());
        System.out.println(allPossibleNames.size());

        long count = 0;
        for (String name : allPossibleNames) {
            for (String author : allPossibleAuthors) {
                cat.addBook(new FictionBook(name, author, true, author.toUpperCase()));
                count++;
            }
        }
        cat.sort();
        ArrayList<Book> res = cat.getCatalog();

        for (int i = 0; i < res.size() - 1; i++) {
            assertEquals(-1, Book.compare(res.get(i), res.get(i + 1)));
        }

        long after = System.nanoTime();
        System.out.println(after - before);
        System.out.println(count);
    }
}
