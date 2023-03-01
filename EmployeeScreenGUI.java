import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EmployeeScreenGUI extends JFrame implements ActionListener {

    private JButton btnAddProduct, btnViewProductInfo, btnPendingOrders, btnSalesReport, btnSave, btnExit, btnLogout;

    public EmployeeScreenGUI() {
        setTitle("Employee Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create the buttons
        btnAddProduct = new JButton("Add New Product");
        btnViewProductInfo = new JButton("View Product Info");
        btnPendingOrders = new JButton("Pending Orders");
        btnSalesReport = new JButton("Sales Report");
        btnSave = new JButton("Save");
        btnExit = new JButton("Exit");
        btnLogout = new JButton("Log Out");

        // Add action listeners to the buttons
        btnAddProduct.addActionListener(this);
        btnViewProductInfo.addActionListener(this);
        btnPendingOrders.addActionListener(this);
        btnSalesReport.addActionListener(this);
        btnSave.addActionListener(this);
        btnExit.addActionListener(this);
        btnLogout.addActionListener(this);

        // Create a panel to hold the buttons
        JPanel panel = new JPanel(new GridLayout(7, 1));
        panel.add(btnAddProduct);
        panel.add(btnViewProductInfo);
        panel.add(btnPendingOrders);
        panel.add(btnSalesReport);
        panel.add(btnSave);
        panel.add(btnExit);
        panel.add(btnLogout);

        // Add the panel to the frame
        add(panel);
        setVisible(true);
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
        } else if (e.getSource() == btnPendingOrders) {
            // Code to show pending orders screen
            ViewOrdersGUI pendingOrdersGUI = new ViewOrdersGUI();
            pendingOrdersGUI.setVisible(true);
            dispose();
        } else if (e.getSource() == btnSalesReport) {
            // Code to generate sales report
            SalesReportGUI salesReportGUI = new SalesReportGUI();
            salesReportGUI.setVisible(true);
            dispose();
        } else if (e.getSource() == btnSave) {
            // Code to save all changes made
        } else if (e.getSource() == btnExit) {
            // Code to exit the GUI frame
            dispose();
        } else if (e.getSource() == btnLogout) {
            // Code to return to the welcome screen
            Welcome_Screen welcomeScreenGUI = new Welcome_Screen();
            welcomeScreenGUI.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        new EmployeeScreenGUI();
    }
}
 