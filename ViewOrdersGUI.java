import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewOrdersGUI extends JFrame implements ActionListener {
    
    private JButton btnReturn;
    private JTable tblOrders;
    
    public ViewOrdersGUI() {
        setTitle("View Orders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        
        // Create the return button
        btnReturn = new JButton("Return to Customer Screen");
        btnReturn.addActionListener(this);
        btnReturn.setBackground(Color.RED);
        
        // Create the orders table
        tblOrders = new JTable();
        String[] columnNames = {"Order ID", "Product ID", "Product Name", "Quantity", "Unit Price", "Total Price"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        // TODO: Add code to retrieve and populate the table data
        tblOrders.setModel(model);
        JScrollPane scrollPane = new JScrollPane(tblOrders);
        
        // Create a panel to hold the return button and the orders table
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(btnReturn, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Add the panel to the frame
        add(panel);
        panel.setBackground(Color.CYAN);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getSource() == btnReturn) {
            // Code to return to the customer screen
            dispose();
            CustomerScreenGUI customerScreenGUI = new CustomerScreenGUI();
            customerScreenGUI.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new ViewOrdersGUI();
    }
}
