import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class EditOrderGUI extends JFrame {

    private JLabel lblOrderNumber;
    private JLabel lblProductID;
    private JLabel lblProductName;
    private JLabel lblQuantity;
    private JLabel lblUnitPrice;
    private JLabel lblTotalPrice;
    private JTextField txtOrderNumber;
    private JTextField txtProductID;
    private JTextField txtProductName;
    private JTextField txtQuantity;
    private JTextField txtUnitPrice;
    private JTextField txtTotalPrice;
    private JButton btnSave;
    private JButton btnReturn;

    public EditOrderGUI() {
        setTitle("Edit Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        // Create labels and text fields for input
        lblOrderNumber = new JLabel("Order Number:");
        lblProductID = new JLabel("Product ID:");
        lblProductName = new JLabel("Product Name:");
        lblQuantity = new JLabel("Quantity:");
        lblUnitPrice = new JLabel("Unit Price:");
        lblTotalPrice = new JLabel("Total Price:");
        txtOrderNumber = new JTextField();
        txtProductID = new JTextField();
        txtProductName = new JTextField();
        txtQuantity = new JTextField();
        txtUnitPrice = new JTextField();
        txtTotalPrice = new JTextField();
        btnSave = new JButton("Save");
        btnReturn = new JButton("Return to Customer Screen");

        // Set layout manager
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setSize(500, 500);

        // Add labels and text fields to the panel
        panel.add(lblOrderNumber);
        panel.add(txtOrderNumber);
        panel.add(lblProductID);
        panel.add(txtProductID);
        panel.add(lblProductName);
        panel.add(txtProductName);
        panel.add(lblQuantity);
        panel.add(txtQuantity);
        panel.add(lblUnitPrice);
        panel.add(txtUnitPrice);
        panel.add(lblTotalPrice);
        panel.add(txtTotalPrice);
        panel.add(btnSave);
        panel.add(btnReturn);

        // Add panel to the frame
        add(panel, BorderLayout.CENTER);
        btnSave.setBackground(Color.RED);
        btnReturn.setBackground(Color.RED);

        // Add action listener for the Save button
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveOrderChanges();
            }
        });
        btnReturn.addActionListener(e -> {
            CustomerScreenGUI customerScreen = new CustomerScreenGUI();
            customerScreen.setVisible(true);
            dispose();
        });

        setVisible(true);
    }

    
    private void saveOrderChanges() {
        String orderNumber = txtOrderNumber.getText().trim();
        String productID = txtProductID.getText().trim();
        String productName = txtProductName.getText().trim();
        String quantity = txtQuantity.getText().trim();
        String unitPrice = txtUnitPrice.getText().trim();
        String totalPrice = txtTotalPrice.getText().trim();
    
        try {
            // Open a temporary file for writing
            File tempFile = new File("Orders_temp.txt");
            PrintWriter writer = new PrintWriter(new FileWriter(tempFile));
    
            // Read the original file and write updated data to the temporary file
            BufferedReader reader = new BufferedReader(new FileReader("Orders.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                String currentOrderNumber = tokens[0];
                if (currentOrderNumber.equals(orderNumber)) {
                    writer.println(orderNumber + "," + productID + "," + productName + "," + quantity + "," + unitPrice
                            + "," + totalPrice);
                } else {
                    writer.println(line);
                }
            }
    
            reader.close();
            writer.close();
    
            // Replace the original file with the temporary file
            File originalFile = new File("Orders.txt");
            if (originalFile.exists()) {
                originalFile.delete();
            }
            tempFile.renameTo(originalFile);
    
            JOptionPane.showMessageDialog(this, "Order changes saved successfully!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to save order changes: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new EditOrderGUI();
    }
}

    
