import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Library {
    private HashMap<String, User> users;
    private Catalog catalog;

    public Library(HashMap<String, User> users, Catalog catalog) {
        this.users = users;
        this.catalog = catalog;
    }

    public int loadCat(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int lineNo = 0;
        int errors = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineNo++;
            // Parse the line
            String[] parts = line.split(":");
            try {
                // Enum nonsense
                Book next = BookType.valueOf(parts[0]).fromString(Arrays.copyOfRange(parts, 1, parts.length));
                catalog.addBook(next);
            } catch (Exception e) {
                System.err.println("error on line #" + lineNo + ": " + line);
                e.printStackTrace();
                errors++;
            }
        }
        if (errors != 0) {
            System.err.println(errors + " error(s) during loading from catalog file :(");
        }
        return errors;
    }

    public int loadUsers(String filename) {
        Scanner scanner = new Scanner(filename);
        int lineNo = 0;
        int errors = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineNo++;
            String[] parts = line.split(":");
            try {
                users.put(parts[0], new User(parts[1]));
            } catch (Exception e) {
                System.err.println("error on line #" + lineNo + ": " + line + "\n" + Arrays.toString(e.getStackTrace()));
                errors++;
            }
        }
        if (errors != 0) {
            System.err.println(errors + " errors during loading from users file :(");
        }
        return errors;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
