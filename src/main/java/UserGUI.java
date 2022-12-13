import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JPanel menuPanel = new JPanel();
        menuPanel.setSize(400, 22);
        JMenuBar mb = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu viewMenu = new JMenu("View");

        JMenuItem openFileMenuItem = new JMenuItem("Open...");
        openFileMenuItem.addActionListener(e -> System.out.println("Hello World!"));
        fileMenu.add(openFileMenuItem);

        mb.add(fileMenu);
        menuPanel.add(mb);
        this.frame.add(menuPanel);
        this.frame.setVisible(true);
    }
}
