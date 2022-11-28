import javax.swing.*;
import java.awt.event.*; 
import java.awt.Color;

public class Employee_Login extends JPanel {
    private static JLabel employee;
    private static JLabel password;
    private static JLabel resultMessage;
    private static JTextField employeeUserName;
    private static JPasswordField employeePassword;
    private static JButton loginButton;

    public Employee_Login() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(340, 200);
        frame.setTitle("Employee Login");
        frame.add(panel);

        employee = new JLabel("Employee User Name:");
        employee.setBounds(10, 20, 170, 25);

        employeeUserName = new JTextField(20);
        employeeUserName.setBounds(160, 20, 165, 25);

        password = new JLabel("Password:");
        password.setBounds(10, 50, 80, 25);

        employeePassword = new JPasswordField();
        employeePassword.setBounds(160, 50, 165, 25);

        loginButton = new JButton("Login");
        loginButton.setBounds(241, 80, 80, 25);
        loginButton.addActionListener(new EmployeeLogin());
        loginButton.setBackground(new Color(0 ,153 ,0));
        loginButton.setBorderPainted(false);
        loginButton.setOpaque(true);

        resultMessage = new JLabel("");
        resultMessage.setBounds(10, 130, 300, 25);

        panel.add(employee);
        panel.add(employeeUserName);
        panel.add(password);
        panel.add(employeePassword);
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
        JFrame frame = new JFrame("Employee Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Employee_Login pane = new Employee_Login();
        pane.setOpaque(true);
        frame.setContentPane(pane);
    }   

    private class EmployeeLogin implements ActionListener { 
        @Override
        public void actionPerformed(ActionEvent e) {
            String employeee = employeeUserName.getText();
            String passwrd = employeePassword.getText();

            if (employeee.equals("employee") && passwrd.equals("P@ssword1")) {
                resultMessage.setText("Login was Successful!");
                new employee_screen();
            } else {
                resultMessage.setText("Incorrect User Name or Password was entered!");
            }
        }
    }
}


