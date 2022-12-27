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
        constraints.gridy = 20;
        constraints.anchor = GridBagConstraints.NORTH;
        JMenu fileMenu = new JMenu("File");
        JMenu viewMenu = new JMenu("View");

        JMenuItem openFileMenuItem = new JMenuItem("Open...");
        openFileMenuItem.addActionListener(e -> System.out.println("Hello World!"));
        fileMenu.add(openFileMenuItem);

        mb.add(fileMenu);

        this.frame.add(mb, constraints);
        this.frame.setVisible(true);
    }
}
