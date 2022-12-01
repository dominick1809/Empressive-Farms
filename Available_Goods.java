import java.awt.Color;
import java.awt.event.*; 
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.event.ActionEvent;

public class Available_Goods extends JFrame 
{
    private JTable goods;
    private DefaultTableModel model;
    private Customer cus;
    private JFrame thisframe;

    // Class constuctor
    public Available_Goods(String cname){
        thisframe = this;
        cus = Customer.findCustomer(cname);
        JPanel tpanel = new JPanel();
        JPanel bpanel = new JPanel();
        JScrollPane pane;

        this.setTitle("Available Goods");
        this.setBounds(300, 70, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
        // Table to display product information
        String[] tableHeadings = {"Product ID","Name","Type","Category","Unit Price",""};
        model = new DefaultTableModel(tableHeadings,0);
        showTable();
        
        // Setting final column cell as checkboxes to indicate desire to order an item
        TableColumn col = goods.getColumnModel().getColumn(-1);
        JCheckBox c = new JCheckBox();
        c.addItemListener(new orderCheck());
        col.setCellEditor(new DefaultCellEditor(c));

        pane = new JScrollPane(goods);
        pane.setOpaque(true);
        tpanel.add(pane);
    
        // Allow customer to return to main screen
        JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				new Customer_Screen(cname);
                thisframe.dispose();
			}
		});

		backButton.setBounds(340, 505, 117, 29);
        backButton.setBackground(Color.cyan); //changes the color of the button
        bpanel.add(backButton);

        this.add(tpanel);
        this.add(bpanel);
        //this.setLayout(new GridLayout(2,1));
        this.pack();
        this.setVisible(true);
    }

    // methods for displaying product information on a table
    private void showTable(){
        ArrayList<Product> plist = Product.getProducts();
        for(Product p : plist){
            addToTable(p);
        }
        goods = new JTable(model);
    }

    private void addToTable(Product p){
        String[] prod = {String.valueOf(p.getID()),p.getName(), p.getType(), p.getCategory(), String.valueOf(p.getPrice())};
        model.addRow(prod);
    }

    // prompt for user to enter quantity
    private class qtyPrompt extends JFrame{
        private JLabel prompt;
        private JTextField resBox;
        private JButton comp;
        private JPanel pnl;
        private JFrame thisframe;
        private int ID;

        public qtyPrompt(int ID){
            thisframe = this;
            this.ID = ID;

            // create components
            prompt = new JLabel("Enter desired quantity");
            resBox = new JTextField();
            comp = new JButton("Enter");
            comp.addActionListener(new enterListener());
            
            //adding components to a panel
            pnl.add(prompt);
            pnl.add(resBox);
            pnl.add(comp);

            // adding panel to frame 
            this.add(pnl);
            this.pack();
            this.setVisible(true);
        }

        private class enterListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                float qty = Integer.valueOf(resBox.getText());
                Product product = Product.findProduct(ID);
                product.setQty(qty);
                cus.placeOrder(new Order("cash",cus.getID(),product));

                thisframe.dispose();
            }
        }
    }

    // add functionality to checkbox to allow ordering of an item
    private class orderCheck implements ItemListener{
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == 1){
                for(int i=0; i<goods.getRowCount(); i++){
                    JCheckBox cb = (JCheckBox)goods.getValueAt(i, -1);
                    if(cb.isSelected()){
                        int prodID = Integer.valueOf((String)goods.getValueAt(i, 0));
                        new qtyPrompt(prodID);
                        break;
                    }
                }
            }
        }
    }
}