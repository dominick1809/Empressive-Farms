import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class CreateEmployeeAccountGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public CreateEmployeeAccountGUI() {
        super("Create Employee Account");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 3));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton createButton = new JButton("Create Account");
        createButton.addActionListener(new CreateButtonListener());
        createButton.setBackground(new Color(0 ,250 ,0));
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new BackButtonListener());
        backButton.setBackground(new Color(0 ,250 ,0));

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(createButton);
        panel.add(backButton);
        panel.setBackground(Color.YELLOW);

        add(panel);

        setVisible(true);
    }

    private class CreateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a username and password.");
                return;
            }

            try {
                FileWriter writer = new FileWriter("Employee.txt", true);
                writer.write(username + "," + password + "\n");
                writer.close();
                JOptionPane.showMessageDialog(null, "Employee Account created successfully.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error creating account");
            }
        }
    }

    private class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();
            new Welcome_Screen();
        }
    }

    public static void main(String[] args) {
        new CreateEmployeeAccountGUI();
    }
}
