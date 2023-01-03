import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class UserGUI {
    private JFrame frame;

    // List of books
    // Search list
    // Logout
    // Checkout / check in
    // View + manage checked out books
    public UserGUI() {
        // Create frame
        this.frame = new JFrame("Library");
        this.frame.setSize(400, 400);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout layout = new GridBagLayout();
        this.frame.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        Border black_line_border = BorderFactory.createLineBorder(Color.black);

        JLabel label = new JLabel("Hello World!");

        JMenuBar mb = new JMenuBar();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 0.5;
        constraints.weightx = 1.0;

        JMenu fileMenu = new JMenu("File");
        JMenu libraryMenu = new JMenu("Library");

        JMenuItem preferencesFileMenuItem = new JMenuItem("Preferences...");
        preferencesFileMenuItem.addActionListener(e -> System.out.println("Displaying preferences."));
        fileMenu.add(preferencesFileMenuItem);

        JMenuItem logoutFileMenuItem = new JMenuItem("Logout");
        logoutFileMenuItem.addActionListener(e -> logout());
        fileMenu.add(logoutFileMenuItem);

        mb.add(fileMenu);

        JMenuItem loadLibraryLibraryMenuItem = new JMenuItem("Load library...");
        loadLibraryLibraryMenuItem.addActionListener(e -> System.out.println("Loading library."));
        libraryMenu.add(loadLibraryLibraryMenuItem);

        JMenuItem openCheckedOutMenuItem = new JMenuItem("Open Checked Out Books");
        openCheckedOutMenuItem.addActionListener(e -> System.out.println("Opening checked out books."));
        libraryMenu.add(openCheckedOutMenuItem);

        mb.add(libraryMenu);

        this.frame.add(mb, constraints);
        this.frame.setVisible(true);

        JPanel books = new JPanel();
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(24, 1, 1, 1);
        constraints.fill = GridBagConstraints.BOTH;

        books.setBorder(black_line_border);

        this.frame.add(books, constraints);
    }

    public void logout() {
        int choice = JOptionPane.showConfirmDialog(this.frame, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            this.frame.setVisible(false);
            System.exit(0);
        }
    }
}
