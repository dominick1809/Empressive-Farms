import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;



public class CustomerScreenGUI extends JFrame implements ActionListener {

    private JButton btnAvailableGoods, btnPlaceOrder, btnViewOrders, btnClose, btnLogout;

    public CustomerScreenGUI() {
        setTitle("Customer Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        
        // Create the buttons
        btnAvailableGoods = new JButton("Available Goods");
        btnPlaceOrder = new JButton("Place Order");
        btnViewOrders = new JButton("View Orders");
        btnClose = new JButton("Exit");
        btnLogout = new JButton("Log Out");
        
        // Add action listeners to the buttons
        btnAvailableGoods.addActionListener(this);
        btnPlaceOrder.addActionListener(this);
        btnViewOrders.addActionListener(this);
        btnClose.addActionListener(this);
        btnLogout.addActionListener(this);
        
        // Create a panel to hold the buttons
        JPanel panel = new JPanel(new GridLayout(5, 5));
        panel.add(btnAvailableGoods);
        panel.add(btnPlaceOrder);
        panel.add(btnViewOrders);
        panel.add(btnClose);
        panel.add(btnLogout);
        
        // Add the panel to the frame
        add(panel);
        setVisible(true);
        panel.setBackground(Color.CYAN);
        btnAvailableGoods.setBackground(Color.RED);
        btnPlaceOrder.setBackground(Color.RED);
        btnViewOrders.setBackground(Color.RED);
        btnClose.setBackground(Color.RED);
        btnLogout.setBackground(Color.RED);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getSource() == btnAvailableGoods) {
            // Code to show available goods screen
            AvailableGoodsGUI availableGoodsGUI = new AvailableGoodsGUI();
            availableGoodsGUI.setVisible(true);
            dispose();
        } else if (e.getSource() == btnPlaceOrder) {
            // Code to show place order screen
            PlaceOrderGUI orderGUI = new PlaceOrderGUI();
            orderGUI.setVisible(true);
            dispose();
        } else if (e.getSource() == btnViewOrders) {
            // Code to show view orders screen
            ViewOrdersGUI viewordersGUI = new ViewOrdersGUI();
            viewordersGUI.setVisible(true);
            dispose();
        } 
        else if (e.getSource() == btnClose) {
            // Code to close the GUI frame
            dispose();
        } else if (e.getSource() == btnLogout) {
            // Code to return to the welcome screen
            JOptionPane.showMessageDialog(this, "Logout successful!");
            Welcome_Screen welcomeScreenGUI = new Welcome_Screen();
            welcomeScreenGUI.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        new CustomerScreenGUI();
    }
}
