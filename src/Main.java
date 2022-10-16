import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        Catalog cat = new Catalog();
        // For testing
        System.out.println("Press enter to begin");
        //noinspection ResultOfMethodCallIgnored
        System.in.read();
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            Book book = new FictionBook(Integer.toString(i), Integer.toString(i), rand.nextBoolean(), nextString(rand));
            cat.addBook(book);
        }
        /*
        System.out.print("Enter title, author, hard_cover and call_no: ");
        cat.addBook(new FictionBook(sc.next(), sc.next(), sc.nextBoolean(), sc.next()));
        System.out.print("Enter title, author, hard_cover and call_no: ");
        cat.addBook(new FictionBook(sc.next(), sc.next(), sc.nextBoolean(), sc.next()));

        System.out.println("Now for nonfiction ");

        System.out.print("Enter title, author, hard_cover and call_no: ");
        cat.addBook(new NonFictionBook(sc.next(), sc.next(), sc.nextBoolean(), sc.nextFloat()));
        System.out.print("Enter title, author, hard_cover and call_no: ");
        cat.addBook(new NonFictionBook(sc.next(), sc.next(), sc.nextBoolean(), sc.nextFloat()));
        System.out.println();
         */

        for (Book book : cat.getCatalog()) {
            System.out.print(book.toString() + ", ");
        }
        System.out.println();

        cat.sort();

        for (Book book : cat.getCatalog()) {
            System.out.print(book.toString() + ", ");
        }
        System.out.println();
    }

    private static String nextString(Random rand) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            res.append((char) rand.nextInt(65, 91));
        }
        return res.toString();
    }
}
