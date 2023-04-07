import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EditDeleteOrderGUI extends JFrame implements ActionListener {

    private JTable ordersTable;
    private DefaultTableModel tableModel;
    private JButton btnEditOrder, btnDeleteOrder, btnBack;
    private List<Order> ordersList;

    public EditDeleteOrderGUI() {
        setTitle("Edit/Delete Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Create the table model and add columns
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Order Number");
        tableModel.addColumn("Product ID");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Unit Price");
        tableModel.addColumn("Total Price");

        // Create the orders table using the table model
        ordersTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(ordersTable);

        // Create the buttons
        btnEditOrder = new JButton("Edit Order");
        btnDeleteOrder = new JButton("Delete Order");
        btnBack = new JButton("Back");

        // Add action listeners to the buttons
        btnEditOrder.addActionListener(this);
        btnDeleteOrder.addActionListener(this);
        btnBack.addActionListener(this);

        // Create a panel to hold the buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btnEditOrder);
        buttonsPanel.add(btnDeleteOrder);
        buttonsPanel.add(btnBack);

        // Add the table and buttons panel to the frame
        add(scrollPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        // Load the orders from the Orders.txt file
        ordersList = loadOrdersFromFile("Orders.txt");
        refreshTable();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getSource() == btnEditOrder) {
            // Get the selected row and order
            int selectedRow = ordersTable.getSelectedRow();
            if (selectedRow >= 0) {
                Order order = ordersList.get(selectedRow);

                // Show the edit order dialog and update the order if the user clicks OK
                EditOrderDialog editOrderDialog = new EditOrderDialog(this, order);
                if (editOrderDialog.showDialog() == JOptionPane.OK_OPTION) {
                    // Update the order in the list and table
                    Order updatedOrder = editOrderDialog.getOrder();
                    ordersList.set(selectedRow, updatedOrder);
                    refreshTable();

                    // Save the updated orders to the file
                    saveOrdersToFile("Orders.txt", ordersList);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select an order to edit.");
            }
        } else if (e.getSource() == btnDeleteOrder) {
            // Get the selected row and order
            int selectedRow = ordersTable.getSelectedRow();
            if (selectedRow >= 0) {
                Order order = ordersList.get(selectedRow);

                // Ask the user to confirm the deletion
                int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this order?",
                        "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    // Remove the order from the list and table
                    ordersList.remove(selectedRow);
                    refreshTable();
                    // Save the updated orders to the file
                saveOrdersToFile("Orders.txt", ordersList);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an order to delete.");
        }
    } else if (e.getSource() == btnBack) {
        // Handle back button click
        // Close the current window and go back to the main menu
        dispose();
        CustomerScreenGUI customerScreenGUI = new CustomerScreenGUI();
    }
}

private void refreshTable() {
    // Refresh the orders table with the current data in the orders list
    tableModel.setRowCount(0);
    for (Order order : ordersList) {
        Object[] rowData = {order.getOrderNumber(), order.getProductID(), order.getProductName(),
                order.getQuantity(), order.getUnitPrice(), order.getTotalPrice()};
        tableModel.addRow(rowData);
    }
}

private List<Order> loadOrdersFromFile(String fileName) {
    // Load orders from the specified file
    List<Order> orders = new ArrayList<>();
    try {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            int orderNumber = Integer.parseInt(parts[0]);
            int productID = Integer.parseInt(parts[1]);
            String productName = parts[2];
            int quantity = Integer.parseInt(parts[3]);
            double unitPrice = Double.parseDouble(parts[4]);
            double totalPrice = Double.parseDouble(parts[5]);
            Order order = new Order(orderNumber, productID, productName, quantity, unitPrice, totalPrice);
            orders.add(order);
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return orders;
}

private void saveOrdersToFile(String fileName, List<Order> orders) {
    // Save orders to the specified file
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Order order : orders) {
            String line = order.getOrderNumber() + "," + order.getProductID() + "," +
                    order.getProductName() + "," + order.getQuantity() + "," +
                    order.getUnitPrice() + "," + order.getTotalPrice();
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public static void main(String[] args) {
    new EditDeleteOrderGUI();
}
}
