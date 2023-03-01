import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlaceOrderGUI extends JFrame implements ActionListener {

    private JButton btnAvailableGoods, btnPlaceOrder, btnSave, btnBack;
    private JTextField txtProductID, txtQuantity;
    private JLabel lblProductID, lblQuantity;
    private JComboBox<String> cmbProductNames;
    private DefaultComboBoxModel<String> productNameModel;
    
    public PlaceOrderGUI() {
        setTitle("Place Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        
        // Create the buttons
        btnAvailableGoods = new JButton("Available Goods");
        btnPlaceOrder = new JButton("Place Order");
        btnSave = new JButton("Save");
        btnBack = new JButton("Back");
        
        // Add action listeners to the buttons
        btnAvailableGoods.addActionListener(this);
        btnPlaceOrder.addActionListener(this);
        btnSave.addActionListener(this);
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
        panel.add(btnAvailableGoods);
        panel.add(btnPlaceOrder);
        panel.add(btnSave);
        panel.add(btnBack);
        
        // Add the panel to the frame
        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getSource() == btnAvailableGoods) {
            AvailableGoodsGUI availableGoodsGUI = new AvailableGoodsGUI();
            availableGoodsGUI.setVisible(true);
        } else if (e.getSource() == btnPlaceOrder) {
            // Code to place the order
            String productName = cmbProductNames.getSelectedItem().toString();
            int productId = Integer.parseInt(txtProductID.getText());
            int quantity = Integer.parseInt(txtQuantity.getText());
            // Code to save the order goes here...
        } else if (e.getSource() == btnSave) {
            // Code to save the order goes here...
        } else if (e.getSource() == btnBack) {
            CustomerScreenGUI customerScreenGUI = new CustomerScreenGUI();
            customerScreenGUI.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        new PlaceOrderGUI();
    }
}
