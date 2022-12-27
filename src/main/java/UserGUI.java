import javax.swing.*;
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

        JLabel label = new JLabel("Hello World!");

        JMenuBar mb = new JMenuBar();
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
    }

    public void logout() {
        int choice = JOptionPane.showConfirmDialog(this.frame, "Are you sure you want to logout?", "Logout", JOptionPane.OK_CANCEL_OPTION);
        if (choice == 0) {
            this.frame.setVisible(false);
            System.exit(0);
        }
    }
}
