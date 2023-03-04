import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddProduct {
    private JTextField productIdTextField, nameTextField, typeTextField, categoryTextField, priceTextField;
    private DefaultTableModel tableModel;

    public AddProduct(JTextField productIdTextField, JTextField nameTextField, JTextField typeTextField, 
                        JTextField categoryTextField, JTextField priceTextField, DefaultTableModel tableModel) {
        this.productIdTextField = productIdTextField;
        this.nameTextField = nameTextField;
        this.typeTextField = typeTextField;
        this.categoryTextField = categoryTextField;
        this.priceTextField = priceTextField;
        this.tableModel = tableModel;
    }

    

    public void addProductDetails() {
        
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
        productIdTextField.setText(",");
        nameTextField.setText(",");
        typeTextField.setText(",");
        categoryTextField.setText(",");
        priceTextField.setText(",");
    }
}
