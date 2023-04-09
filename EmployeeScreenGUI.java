import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;




public class EmployeeScreenGUI extends JFrame implements ActionListener {

    private JButton btnAddProduct, btnViewProductInfo, btnPendingOrders, btnUpdateProductInfo, btnSalesReport, btnExit, btnLogout;

    public EmployeeScreenGUI() {
        setTitle("Employee Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create the buttons
        btnAddProduct = new JButton("Add New Product");
        btnViewProductInfo = new JButton("View Product Info");
        btnUpdateProductInfo = new JButton("Update Product Info");
        btnPendingOrders = new JButton("Pending Orders");
        btnSalesReport = new JButton("Sales Report");
        btnExit = new JButton("Exit");
        btnLogout = new JButton("Log Out");

        // Add action listeners to the buttons
        btnAddProduct.addActionListener(this);
        btnViewProductInfo.addActionListener(this);
        btnUpdateProductInfo.addActionListener(this);
        btnPendingOrders.addActionListener(this);
        btnSalesReport.addActionListener(this);
        btnExit.addActionListener(this);
        btnLogout.addActionListener(this);

        // Create a panel to hold the buttons
        JPanel panel = new JPanel(new GridLayout(4, 4));
        panel.add(btnAddProduct);
        panel.add(btnViewProductInfo);
        panel.add(btnUpdateProductInfo);
        panel.add(btnPendingOrders);
        panel.add(btnSalesReport);
        panel.add(btnExit);
        panel.add(btnLogout);

        // Add the panel to the frame
        add(panel);
        setVisible(true);
        panel.setBackground(Color.YELLOW);
        btnAddProduct.setBackground(Color.GRAY);
        btnViewProductInfo.setBackground(Color.GRAY);
        btnUpdateProductInfo.setBackground(Color.GRAY);
        btnSalesReport.setBackground(Color.GRAY);
        btnPendingOrders.setBackground(Color.GRAY);
        btnExit.setBackground(Color.GRAY);
        btnLogout.setBackground(Color.GRAY);
    
    }

    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getSource() == btnAddProduct) {
            // Code to show add product screen
            AddProductGUI addProductGUI = new AddProductGUI();
            addProductGUI.setVisible(true);
            dispose();
        } else if (e.getSource() == btnViewProductInfo) {
            // Code to show product info screen
            ViewProductInfoGUI productInfoGUI = new ViewProductInfoGUI();
            productInfoGUI.setVisible(true);
            dispose();
        } else if (e.getSource() == btnUpdateProductInfo) {
            // Code to show update product info screen
            UpdateProductInfoGUI updateProductInfoGUI = new UpdateProductInfoGUI();
            updateProductInfoGUI.setVisible(true);
            dispose();
        }else if (e.getSource() == btnPendingOrders) {
            // Code to show pending orders screen
            ViewPendingOrdersGUI pendingOrdersGUI = new ViewPendingOrdersGUI();
            pendingOrdersGUI.setVisible(true);
            dispose();
        } else if (e.getSource() == btnSalesReport) {
            // Code to generate sales report
            GenerateSalesReport salesReportGUI = new GenerateSalesReport();
            salesReportGUI.setVisible(true);
            dispose();
        } else if (e.getSource() == btnExit) { 
            // Code to exit the GUI frame
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
        new EmployeeScreenGUI();
    }
}
 