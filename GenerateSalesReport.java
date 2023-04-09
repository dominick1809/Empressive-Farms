import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class GenerateSalesReport extends JFrame {

    private JTextArea txtSalesReport;
    private JButton btnGenerate;
    private JButton btnReturn;

    public GenerateSalesReport() {
        setTitle("Empressive Farms Sales Report");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create components
        txtSalesReport = new JTextArea();
        btnGenerate = new JButton("Generate Report");
        btnReturn = new JButton("Return to Employee Screen");

        // Set layout manager
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to the panel
        panel.add(txtSalesReport, BorderLayout.CENTER);
        panel.add(btnGenerate, BorderLayout.SOUTH);
        panel.add(btnReturn, BorderLayout.NORTH);

        // Add panel to the frame
        add(panel, BorderLayout.CENTER);

        // Add action listener for the Generate Report button
        btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateSalesReport();
            }
        });

        // Add action listener for the Return to Employee Screen button
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeScreenGUI employeeScreen = new EmployeeScreenGUI();
                employeeScreen.setVisible(true);
                dispose();
                // Code to return to the employee screen goes here
            }
        });

        // Set button color to gray
        btnGenerate.setBackground(Color.GRAY);
        btnReturn.setBackground(Color.GRAY);

        setVisible(true);
    }

    private void generateSalesReport() {
        try {
            // Read data from the Orders.txt file
            BufferedReader reader = new BufferedReader(new FileReader("Orders.txt"));
            String line;
            StringBuilder sb = new StringBuilder();
            sb.append("Order Number\tProduct Name\tQuantity\tTotal Price\n");
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                String orderNumber = tokens[0];
                String productName = tokens[2];
                String quantity = tokens[3];
                String totalPrice = tokens[5];
                sb.append(orderNumber + "\t" + productName + "\t" + quantity + "\t" + totalPrice + "\n");
            }
            reader.close();

            txtSalesReport.setText(sb.toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to generate sales report: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new GenerateSalesReport();
    }
}
