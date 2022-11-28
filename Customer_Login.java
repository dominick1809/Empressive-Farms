import javax.swing.*;
import java.awt.event.*; 
import java.awt.Color;

public class Customer_Login extends JPanel {
    private static JLabel customer;
    private static JLabel password;
    private static JLabel resultMessage;
    private static JTextField customerUserName;
    private static JPasswordField customerPassword;
    private static JButton loginButton;

    public Customer_Login() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(340, 200);
        frame.setTitle("Customer Login");
        frame.add(panel);

        customer = new JLabel("Customer User Name:");
        customer.setBounds(10, 20, 170, 25);
        
        customerUserName = new JTextField(20);
        customerUserName.setBounds(160, 20, 165, 25);
        
        password = new JLabel("Password:");
        password.setBounds(10, 50, 80, 25);
        
        customerPassword = new JPasswordField();
        customerPassword.setBounds(160, 50, 165, 25);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(241, 80, 80, 25);
        loginButton.addActionListener(new CustomerLogin());
        loginButton.setBackground(new Color(0 ,153 ,0));
        loginButton.setBorderPainted(false);
        loginButton.setOpaque(true);

        resultMessage = new JLabel("");
        resultMessage.setBounds(10, 130, 300, 25);
        
        panel.add(customer);
        panel.add(customerUserName);
        panel.add(password);
        panel.add(customerPassword);
        panel.add(loginButton);
        panel.add(resultMessage);
        panel.setLayout(null);
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        JFrame frame = new JFrame("Customer Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Customer_Login pane = new Customer_Login();
        pane.setOpaque(true);
        frame.setContentPane(pane);
    }   

    private class CustomerLogin implements ActionListener { 
        @Override
        public void actionPerformed(ActionEvent e) {
            String customerr = customerUserName.getText();
            String passwrd = customerPassword.getText();

            if (customerr.equals("customer") && passwrd.equals("pAs$worD2")) {
                resultMessage.setText("Login was Successful!");
                new customer_screen();
            } else {
                resultMessage.setText("Incorrect User Name or Password was entered!");
            }
        }
    }
}


