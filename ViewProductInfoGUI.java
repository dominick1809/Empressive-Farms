import java.awt.*;
import javax.swing.*;

public class ViewProductInfoGUI extends JFrame {

    private JButton btnBack;

    public ViewProductInfoGUI() {
        setTitle("Product Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        
        // Create the table model
        Object[][] data = {
            {"1", "Product A", "Type 1", "Category 1", "10.00"},
            {"2", "Product B", "Type 1", "Category 2", "20.00"},
            {"3", "Product C", "Type 2", "Category 1", "30.00"},
            {"4", "Product D", "Type 2", "Category 2", "40.00"}
        };
        String[] columnNames = {"Product ID", "Name", "Type", "Category", "Unit Price"};
        JTable table = new JTable(data, columnNames);
        
        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        // Create the back button
        btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            EmployeeScreenGUI employeeScreen = new EmployeeScreenGUI();
            employeeScreen.setVisible(true);
            dispose();
        });
        
        // Add the back button to the bottom panel
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(btnBack);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        
        // Show the window
        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewProductInfoGUI();
    }
}
