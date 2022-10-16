import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Catalog cat = new Catalog();
        // For testing
        /*
        System.out.print("Press enter to begin: ");
        System.in.read();
        System.out.println("begun!");
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            Book book = new FictionBook(Integer.toString(i), Integer.toString(i), rand.nextBoolean(), nextString(rand));
            cat.addBook(book);
        }
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


        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            Scanner sc = new Scanner(System.in);
            String title = nextString(rand);
            String author = "nextString(rand)";
            boolean hard_cover = rand.nextBoolean();
            System.out.print("Enter a call number: ");
            String call_no = sc.next();
            try {
                float call_no_float = Float.parseFloat(call_no);
                cat.addBook(new NonFictionBook(title, author, hard_cover, call_no_float));
            } catch (NumberFormatException ignored) {
                cat.addBook(new FictionBook(title, author, hard_cover, call_no));
            }
        }
         */

        cat.addBook(new NonFictionBook("a", "b", false, 100.5F));
        System.out.println(cat.findBook(new NonFictionBook("a", "b", false, 100.5F)));
        System.out.println(cat.findBook(new NonFictionBook("a", "b", true, 100.5F)));

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
