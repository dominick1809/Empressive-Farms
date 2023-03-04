import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PlaceOrderGUI extends JFrame implements ActionListener {

    private JButton btnPlaceOrder, btnBack;
    private JTextField txtProductID, txtQuantity;
    private JLabel lblProductID, lblQuantity;
    private JComboBox<String> cmbProductNames;
    private DefaultComboBoxModel<String> productNameModel;
    private Order order;  // instance of Order class
    private ArrayList<Order> orders = new ArrayList<Order>();  // orders list

    public PlaceOrderGUI() {

        setTitle("Place Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
    
        // Create the buttons
        btnPlaceOrder = new JButton("Place Order");
        btnBack = new JButton("Back");
    
        // Add action listeners to the buttons
        btnPlaceOrder.addActionListener(this);
        btnBack.addActionListener(this);
    
        // Create the labels and text fields
        lblProductID = new JLabel("Product ID:");
        txtProductID = new JTextField(10);
        lblQuantity = new JLabel("Quantity:");
        txtQuantity = new JTextField(10);
    
        // Create the product name combo box
        productNameModel = new DefaultComboBoxModel<String>();
        cmbProductNames = new JComboBox<String>(productNameModel);
    
        // Create a panel to hold the controls
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Product Name:"));
        panel.add(cmbProductNames);
        panel.add(lblProductID);
        panel.add(txtProductID);
        panel.add(lblQuantity);
        panel.add(txtQuantity);
        panel.add(btnPlaceOrder);
        panel.add(btnBack);
    
        // Add the panel to the frame
        add(panel);
        panel.setBackground(Color.CYAN);
        setVisible(true);
        btnBack.setBackground(Color.RED);
        btnPlaceOrder.setBackground(Color.RED);
    
        // Initialize the Order object
        order = new Order(0, 0);
    
        // Load the available products into the combo box
        AvailableGoodsGUI availableGoodsGUI = new AvailableGoodsGUI();
        List<String> productNames = availableGoodsGUI.getProductNames();
        

    
    }
    

    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getSource() == btnPlaceOrder) {
            // Code to place the order
            String productName = cmbProductNames.getSelectedItem().toString();
            int productId = Integer.parseInt(txtProductID.getText());
            int quantity = Integer.parseInt(txtQuantity.getText());
    
            // Get the unit price and calculate the total price
            double unitPrice = AvailableGoodsGUI.getUnitPrice(productId);
            double totalPrice = unitPrice * quantity;
    
            // Create an order object and add it to the orders list
            Order order = new Order(productId, quantity);
            order.setTotalPrice(totalPrice);
            order.setProductName(productName); // set the productName field
    
            orders.add(order);
    
            // Save the orders to a text file
            try {
                FileWriter writer = new FileWriter("Orders.txt", true);
                writer.write(productName + "," + productId + "," + quantity + "," + totalPrice + "\n");
                writer.close();
                JOptionPane.showMessageDialog(null, "Order placed successfully. Your Total Price is: $"+ totalPrice);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error placing order");
            }
        }
        else if (e.getSource() == btnBack) {
            CustomerScreenGUI customerScreenGUI = new CustomerScreenGUI();
            customerScreenGUI.setVisible(true);
            dispose();
        }
    }
    
    

    public static void main(String[] args) {
        PlaceOrderGUI placeOrderGUI = new PlaceOrderGUI();
        placeOrderGUI.setVisible(true);
    }
    
}


