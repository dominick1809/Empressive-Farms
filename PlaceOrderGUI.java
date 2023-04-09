import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class PlaceOrderGUI {
    private JFrame frame;
    private JTextField productIdField;
    private JTextField productNameField;
    private JTextField quantityField;
    private JTextField priceField;
    private JLabel totalLabel;
    private JButton placeOrderButton;
    private JLabel orderNumberLabel;
    private JButton returnButton; // Added return button

    public PlaceOrderGUI() {
        frame = new JFrame("Place Order");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(8, 2)); // Updated layout to accommodate return button

        productIdField = new JTextField();
        productNameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();
        totalLabel = new JLabel("Total:");
        orderNumberLabel = new JLabel("");
        returnButton = new JButton("Return to Customer Screen"); // Added return button

        placeOrderButton = new JButton("Place Order");
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productId = productIdField.getText();
                String productName = productNameField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());
                double total = quantity * price;
                totalLabel.setText("Total: " + total);

                // Generate a random order number
                Random random = new Random();
                int orderNumber = random.nextInt(100000);
                orderNumberLabel.setText("Order Number: " + orderNumber);

                // Save the order in the text file
                String orderData = orderNumber + "," + productId + "," + productName + "," + quantity + "," + price + "," + total;
                saveOrderToFile(orderData);
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current frame
                new CustomerScreenGUI(); // Open the customer screen GUI
            }
        });

        frame.add(new JLabel("Product ID:"));
        frame.add(productIdField);
        frame.add(new JLabel("Product Name:"));
        frame.add(productNameField);
        frame.add(new JLabel("Quantity:"));
        frame.add(quantityField);
        frame.add(new JLabel("Price:"));
        frame.add(priceField);
        frame.add(totalLabel);
        frame.add(new JLabel(""));
        frame.add(orderNumberLabel);
        frame.add(new JLabel(""));
        frame.add(placeOrderButton);
        frame.add(returnButton); // Added return button
        placeOrderButton.setBackground(Color.RED);
        returnButton.setBackground(Color.RED);

        frame.setVisible(true);
    }

    private void saveOrderToFile(String orderData) {
        try {
            FileWriter fileWriter = new FileWriter("Orders.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(orderData);
            printWriter.close();
            JOptionPane.showMessageDialog(frame, "Order saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Failed to save order. Please try again.");
        }
    }

    public static void main(String[] args) {
        new PlaceOrderGUI();
    }

    public void setVisible(boolean b) {
    }
}

    