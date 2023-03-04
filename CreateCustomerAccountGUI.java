import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class CreateCustomerAccountGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public CreateCustomerAccountGUI() {
        super("Create Customer Account");
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
        panel.setBackground(Color.CYAN);

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
                FileWriter writer = new FileWriter("Customer.txt", true);
                writer.write(username + "," + password + "\n");
                writer.close();
                JOptionPane.showMessageDialog(null, "Customer Account created successfully.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error creating account");
            }
        }
    }
    
    private class BackButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose(); // Close the current window
            new Welcome_Screen(); // Show the welcome screen
        }
    }

    public static void main(String[] args) {
        new CreateCustomerAccountGUI();
    }
}

