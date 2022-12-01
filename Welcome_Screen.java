import javax.swing.*;
import java.awt.event.*;  
import java.awt.Color;
import java.awt.Font;

public class Welcome_Screen extends JPanel {

    private static JLabel label;
	private static JButton employee;
	private static JButton customer;
    private JFrame frame;
	
    public Welcome_Screen() {
        JPanel panel = new JPanel();
		frame = new JFrame("Welcome Screen"); 

		frame.setSize(550,430);
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

		panel.add(new JLabel(new ImageIcon("empressive-farms-logo.jpg")));
        panel.add(label);
		panel.add(employee);
		panel.add(customer);
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
            new Employee_Login();
            frame.dispose();
        } 
	}

	private class Customer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {  
            new Customer_Login();
            frame.dispose();
        } 
    }
}
