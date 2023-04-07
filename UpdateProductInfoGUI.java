import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UpdateProductInfoGUI extends JFrame implements ActionListener {

    // Components of the GUI
    private JTextField productIdTextField, nameTextField, typeTextField, categoryTextField, priceTextField;
    private JButton updateButton, saveButton, returnButton;
    private JTable productTable;
    private DefaultTableModel tableModel;
    
    public UpdateProductInfoGUI() {
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
        updateButton = new JButton("Update");
        updateButton.addActionListener(this);
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
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(createRow(productIdLabel, productIdTextField));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(createRow(nameLabel, nameTextField));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(createRow(typeLabel, typeTextField));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(createRow(categoryLabel, categoryTextField));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(createRow(priceLabel, priceTextField));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(updateButton);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));
        panel.add(saveButton);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));
        panel.add(returnButton);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        // Add the table and panel to the JFrame
        add(new JScrollPane(productTable), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        setTitle("Update Product Information");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.YELLOW);
        updateButton.setBackground(Color.GRAY);
        saveButton.setBackground(Color.GRAY);
        returnButton.setBackground(Color.GRAY);

        setVisible(true);
    }

    private JPanel createRow(JLabel label, JTextField field) {
        JPanel row = new JPanel(new BorderLayout());
        row.add(label, BorderLayout.WEST);
        row.add(field, BorderLayout.CENTER);
        return row;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateButton) {
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
            // Get the selected file
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    // Open a temporary file for writing
                    File tempFile = File.createTempFile("tempfile", ".txt");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                    // Write the updated data to the temporary file
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        for (int j = 0; j < tableModel.getColumnCount(); j++) {
                            writer.write(tableModel.getValueAt(i, j).toString() + "\t");
                        }
                        writer.newLine();
                    }
                    writer.close();
                    // Replace the contents of the original file with the temporary file
                    if (!file.delete()) {
                        throw new IOException("Could not delete file");
                    }
                    if (!tempFile.renameTo(file)) {
                        throw new IOException("Could not rename file");
                    }
                    JOptionPane.showMessageDialog(this, "Data saved successfully!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving data to file.");
                    ex.printStackTrace();
                }
            }
        }
        
         else if (e.getSource() == returnButton) {
            // Return to the EmployeeScreenGUI
            new EmployeeScreenGUI();
            dispose(); // Close the UpdateProductInfoGUI
        }
    }

    public static void main(String[] args) {
        new UpdateProductInfoGUI();
    }
}