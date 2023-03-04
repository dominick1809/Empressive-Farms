import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewOrdersGUI extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private List<Order> orders;

    public ViewOrdersGUI() {
        setTitle("View Orders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 300);

        // Create a table to display the orders
        tableModel = new DefaultTableModel(new String[] { "Product Name", "Product ID", "Quantity", "Total Price" }, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Load the orders from the file
        orders = loadOrdersFromFile();

        // Add the orders to the table
        for (Order order : orders) {
            String[] row = new String[] { order.getProductName(), String.valueOf(order.getProductId()),
                    String.valueOf(order.getQuantity()), String.format("%.2f", order.getTotalPrice()) };
            tableModel.addRow(row);
        }

        // Add the table to the frame
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Add the return button to the north of the panel
        JButton returnButton = new JButton("Return to the Customer Screen");
        returnButton.setForeground(Color.BLACK);
        returnButton.setBackground(Color.RED);
        returnButton.setPreferredSize(new Dimension(80, 30));
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CustomerScreenGUI customerScreenGUI = new CustomerScreenGUI();
                customerScreenGUI.setVisible(true);
            }
        });
        mainPanel.add(returnButton, BorderLayout.NORTH);

        add(mainPanel);
        setVisible(true);
    }

    private List<Order> loadOrdersFromFile() {
        List<Order> orders = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("Orders.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 4) {
                    String productName = tokens[0];
                    int productId = Integer.parseInt(tokens[1]);
                    int quantity = Integer.parseInt(tokens[2]);
                    double totalPrice = Double.parseDouble(tokens[3]);
                    Order order = new Order(productId, quantity);
                    order.setTotalPrice(totalPrice);
                    order.setProductName(productName);
                    orders.add(order);
                }
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading orders");
        }

        return orders;
    }

    public static void main(String[] args) {
        ViewOrdersGUI viewOrdersGUI = new ViewOrdersGUI();
    }
}
