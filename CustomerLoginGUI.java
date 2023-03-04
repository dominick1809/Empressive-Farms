import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomerLoginGUI extends JFrame implements ActionListener {

    // Components of the GUI
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;
    private Map<String, String> registeredUsers;

    public CustomerLoginGUI() {
        // Set up the GUI components
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameTextField = new JTextField();
        passwordTextField = new JPasswordField();
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setBackground(new Color(0 ,250 ,0)); 

        // Create the layout for the components
        JPanel panel = new JPanel(new GridLayout(5, 3));
        panel.add(usernameLabel);
        panel.add(usernameTextField);
        panel.add(passwordLabel);
        panel.add(passwordTextField);
        panel.add(new JLabel()); // empty label for formatting
        panel.add(loginButton);

        // Add the panel to the JFrame
        add(panel);
        setTitle("Customer Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.CYAN);
        setVisible(true);
        
        registeredUsers = readRegisteredUsersFromFile("Customer.txt");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the username and password from the text fields
        String username = usernameTextField.getText();
        String password = new String(passwordTextField.getPassword());

        // Check if the username and password are valid
        if (isValidLogin(username, password)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            CustomerScreenGUI customerScreenGUI = new CustomerScreenGUI();
            customerScreenGUI.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }

    private boolean isValidLogin(String username, String password) {
        // Check if the username exists in the registered users map
        if (registeredUsers.containsKey(username)) 
        {
            // Get the corresponding password for the username
            String storedPassword = registeredUsers.get(username);
    
            // Check if the provided password matches the stored password for the username
            if (password.equals(storedPassword)) {
                return true; // Valid login
            }
        }
    
        return false; // Invalid login
    }
    
    private Map<String, String> readRegisteredUsersFromFile(String filename) {
        Map<String, String> users = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return users;
    }

    public static void main(String[] args) {
        new CustomerLoginGUI();
    }
}

