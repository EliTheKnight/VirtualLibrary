import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class LoginGUI {
    private JFrame frame;
    private JTextField username;
    private JPasswordField password;
    public HashMap<String, User> users;

    LoginGUI(HashMap<String, User> users) {
        this.users = users;

        this.frame = new JFrame("Library login");

        GridBagLayout frameLayout = new GridBagLayout();
        this.frame.setLayout(frameLayout);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.frame.setResizable(false);
        this.frame.setSize(300, 150);

        JLabel usernameLabel = new JLabel();
        usernameLabel.setText("Username: ");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        this.frame.add(usernameLabel, c);

        JTextField username = new JTextField();
        username.setPreferredSize(new Dimension(200, 28));
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        this.frame.add(username, c);
        this.username = username;

        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password: ");
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        this.frame.add(passwordLabel, c);

        JPasswordField password = new JPasswordField();
        password.setPreferredSize(new Dimension(200, 28));
        c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        this.frame.add(password, c);
        this.password = password;

        JButton go = new JButton("Go fish");
        go.addActionListener(e -> login());
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        this.frame.add(go, c);

        this.frame.setVisible(true);
    }

    private void login() {
        String user = this.username.getText();
        String pass = String.valueOf(this.password.getPassword());

        User target = users.get(user);
        if (target == null) {
            JOptionPane.showMessageDialog(this.frame, "Incorrect username or password", "Login attempt", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean success;
        try {
            success = target.checkPass(pass);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);                                          
        }
        if (success) {
            JOptionPane.showMessageDialog(this.frame, "You've been logged in!", "Login attempt", JOptionPane.INFORMATION_MESSAGE);
            new UserGUI();
            this.frame.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this.frame, "Incorrect username or password", "Login attempt", JOptionPane.ERROR_MESSAGE);
        }
    }
}
