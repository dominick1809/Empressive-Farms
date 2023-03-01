import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddProductGUI extends JFrame implements ActionListener {

    // Components of the GUI
    private JTextField productIdTextField, nameTextField, typeTextField, categoryTextField, priceTextField;
    private JButton addButton, saveButton, returnButton;
    private JTable productTable;
    private DefaultTableModel tableModel;

    public AddProductGUI() {
        // Set up the GUI components
        JLabel productIdLabel = new JLabel("Product ID:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel typeLabel = new JLabel("Type:");
        JLabel categoryLabel = new JLabel("Category:");
        JLabel priceLabel = new JLabel("Unit Price:");
        productIdTextField = new JTextField();
        nameTextField = new JTextField();
        typeTextField = new JTextField();
        categoryTextField = new JTextField();
        priceTextField = new JTextField();
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        returnButton = new JButton("Return");
        returnButton.addActionListener(this);

        // Create the table and table model
        String[] columnNames = {"Product ID", "Name", "Type", "Category", "Unit Price"};
        tableModel = new DefaultTableModel(columnNames, 0);
        productTable = new JTable(tableModel);
        productTable.setFillsViewportHeight(true);

        // Create the layout for the components
        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(productIdLabel);
        panel.add(productIdTextField);
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(typeLabel);
        panel.add(typeTextField);
        panel.add(categoryLabel);
        panel.add(categoryTextField);
        panel.add(priceLabel);
        panel.add(priceTextField);
        panel.add(addButton);
        panel.add(saveButton);
        panel.add(new JLabel()); // empty label for formatting
        panel.add(returnButton);

        // Add the table and panel to the JFrame
        add(new JScrollPane(productTable), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        setTitle("Add Products");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Get the product details from the text fields
            String productId = productIdTextField.getText();
            String name = nameTextField.getText();
            String type = typeTextField.getText();
            String category = categoryTextField.getText();
            String price = priceTextField.getText();

            // Add the product details to the table model
            Object[] rowData = {productId, name, type, category, price};
            tableModel.addRow(rowData);

            // Clear the text fields
            productIdTextField.setText("");
            nameTextField.setText("");
            typeTextField.setText("");
            categoryTextField.setText("");
            priceTextField.setText("");
            
        } else if (e.getSource() == saveButton) {
            // Save the data in the table to a file or database
            JOptionPane.showMessageDialog(this, "Data saved successfully!");

        } else if (e.getSource() == returnButton) {
            // Return to the EmployeeScreenGUI
            new EmployeeScreenGUI();
            dispose(); // Close the AddProductGUI
        }
    }

    public static void main(String[] args) {
        new AddProductGUI();
    }
}
