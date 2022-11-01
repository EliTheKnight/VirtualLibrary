import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Library {
    // TODO: name
    private ArrayList<User> users;
    private Catalog catalog;

    public Library(ArrayList<User> users, Catalog catalog) {
        this.users = users;
        this.catalog = catalog;
    }

    public int loadCat(String filename) {
        Scanner scanner = new Scanner(filename);
        int lineNo = 0;
        int errors = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineNo++;
            // Parse the line
            String[] parts = line.split("·");
            try {
                // Enum nonsense
                Book next = BookType.valueOf(parts[0]).fromString(Arrays.copyOfRange(parts, 1, parts.length));
                catalog.addBook(next);
            } catch (Exception e) {
                System.err.println("error on line #" + lineNo + ": " + line + "\n" + Arrays.toString(e.getStackTrace()));
                errors++;
            }
        }
        if (errors != 0) {
            System.err.println(errors + " errors during loading from catalog file :(");
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
            try {
                users.add(User.fromString(line));
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

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
