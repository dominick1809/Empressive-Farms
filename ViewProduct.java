import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.*;

public class ViewProduct extends JFrame {
    JTable table;
    JLabel heading;
    JPanel tpanel;
    JPanel hpanel;
    DefaultTableModel model;
    //name, price, quantity, category, type
    public ViewProduct(){
        heading = new JLabel("Product List");
        String[] tableHeadings = {"Product ID","Name","Price","Quantity", "Category","Type","Update Product"};
        model = new DefaultTableModel(tableHeadings,0);

        TableColumn col = table.getColumnModel().getColumn(-1);
        JCheckBox c = new JCheckBox();
        c.addItemListener(new updateListener());
        col.setCellEditor(new DefaultCellEditor(c));

        showTable();

        this.pack();
        this.setVisible(true);
    }

    private void showTable(){
        for(Product p : Product.getProducts()){
            addToTable(p);
        }
        table = new JTable(model);
    }

    private void addToTable(Product p){
        String[] prod = p.toString().split(" ");
        model.addRow(prod);
    }

    private class updateListener implements ItemListener{
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == 1){
                for(int i=0; i<table.getRowCount(); i++){
                    JCheckBox cb = (JCheckBox)table.getValueAt(i, -1);
                    if(cb.isSelected()){
                        int prodID = Integer.valueOf((String)table.getValueAt(i, 0));
                        new updateProduct(prodID);
                        break;
                    }
                }
            }
        }
    }

    private class updateProduct extends JFrame{
        JPanel pane;
        JLabel qtyPrompt;
        JTextField qtytext;
        JLabel pricePrompt;
        JTextField pricetext;
        JButton saveButton;
        JFrame thisframe;

        private int pID;

        public updateProduct(int prodID){
            pID = prodID;
            thisframe = this;
            pane = new JPanel();

            // components to enter new quantity for product
            qtyPrompt = new JLabel("Enter new quantity: ");
            qtytext	= new JTextField();
            pane.add(qtyPrompt);
            pane.add(qtytext);

            // components to enter new price
            pricePrompt = new JLabel("Enter new price: ");
            pricetext = new JTextField();
            pane.add(pricePrompt);
            pane.add(pricetext);

            // button to indicate fields are filled
            saveButton = new JButton("Save Changes");
            saveButton.addActionListener(new productListener());
            pane.add(saveButton);

            this.pack();
            this.setVisible(true);
        }

        private class productListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                float newQty = Float.valueOf(qtytext.getText());
                float newPrice = Float.valueOf(pricetext.getText());
                Product product = Product.findProduct(pID);
                product.setPrice(newPrice);
                product.setQty(newQty);

                thisframe.dispose();
            }
        }
    }
}
