import javax.swing.*;
import java.awt.event.*;  
import java.awt.Color;
import java.awt.Font;

public class Welcome_Screen extends JPanel {

    private static JLabel label;
    private static JButton employee;
    private static JButton customer;
    private static JButton createEmployee;
    private static JButton createCustomer;
    private JFrame frame; 

    public Welcome_Screen() {
        JPanel panel = new JPanel();
        frame = new JFrame("Welcome Screen"); 

        frame.setSize(550,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); 

        label = new JLabel("Farming Done Empressively.");
        label.setFont(new Font("Serif", Font.ITALIC, 40));

        employee = new JButton("Employee Login");
        employee.addActionListener(new Employee());
        employee.setBackground(new Color(0 ,153 ,0));
        employee.setOpaque(true);
        employee.setBorderPainted(false);
        employee.setFont(new Font("DialogInput", Font.PLAIN, 15));

        customer = new JButton("Customer Login");
        customer.addActionListener(new Customer());
        customer.setBackground(new Color(0 ,153 ,0));
        customer.setOpaque(true);
        customer.setBorderPainted(false);
        customer.setFont(new Font("DialogInput", Font.PLAIN, 15));

        createEmployee = new JButton("Create Employee Account");
        createEmployee.addActionListener(new CreateEmployee());
        createEmployee.setBackground(new Color(255, 140, 0));
        createEmployee.setOpaque(true);
        createEmployee.setBorderPainted(false);
        createEmployee.setFont(new Font("DialogInput", Font.PLAIN, 15));

        createCustomer = new JButton("Create Customer Account");
        createCustomer.addActionListener(new CreateCustomer());
        createCustomer.setBackground(new Color(255, 140, 0));
        createCustomer.setOpaque(true);
        createCustomer.setBorderPainted(false);
        createCustomer.setFont(new Font("DialogInput", Font.PLAIN, 15));

        panel.add(new JLabel(new ImageIcon("empressive-farms-logo.jpg")));
        panel.add(label);
        panel.add(employee);
        panel.add(customer);
        panel.add(createEmployee);
        panel.add(createCustomer);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setLocation(null);
    }

    private static void createGUI() {
        JFrame frame = new JFrame("Empressive Farms Home Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Welcome_Screen pane = new Welcome_Screen();
        pane.setOpaque(true);

        frame.pack();
        frame.setContentPane(pane);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });     
    }

    private class Employee implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { 
            new EmployeeLoginGUI();
            frame.dispose();
        } 
    }

    private class Customer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {  
            new CustomerLoginGUI();
            frame.dispose();        } 
    }

    private class CreateEmployee implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new CreateEmployeeAccountGUI();
            frame.dispose();
        }
    }

    private class CreateCustomer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new CreateCustomerAccountGUI();
            frame.dispose();
        }
    }
}
