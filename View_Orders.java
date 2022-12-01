import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.*;

public class View_Orders extends JFrame{
    JTable table;
    JLabel heading;
    JPanel tpanel;
    JPanel hpanel;
    DefaultTableModel model;
    String cname;
    
    public View_Orders(String cname){
        this.cname = cname;
        heading = new JLabel("Orders");
        String[] tableHeadings = {"Order ID","Name","Payment Type","Customer ID", "Status","Cancel Order"};
        model = new DefaultTableModel(tableHeadings,0);

        TableColumn col = table.getColumnModel().getColumn(-1);
        JCheckBox c = new JCheckBox();
        c.addItemListener(new deleteOrder());
        col.setCellEditor(new DefaultCellEditor(c));

        showTable();

        this.pack();
        this.setVisible(true);
    }

    private void showTable(){
        ArrayList<Order> olist = Customer.findCustomer(cname).getOrders();
        for(Order o : olist){
            addToTable(o);
        }
        table = new JTable(model);
    }

    private void addToTable(Order o){
        String[] ord = o.toString().split(" ");
        model.addRow(ord);
    }

    private class deleteOrder implements ItemListener{
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == 1){
                for(int i=0; i<table.getRowCount(); i++){
                    JCheckBox cb = (JCheckBox)table.getValueAt(i, -1);
                    if(cb.isSelected()){
                        int orderID = Integer.valueOf((String)table.getValueAt(i, 0));
                        Order order = Order.findOrder(orderID);
                        order.updateOrder(null);
                        break;
                    }
                }
            }
        }
    }

    /*private class enterDetails extends JFrame{
        JLabel orderID;
        JLabel order;
        JLabel product;
        JLabel prodID;
        JTextField qbox;
        JButton delButton;
        JButton update;
        private int oID;

        public enterDetails(int ID){
            oID = ID;
            // components to go on the panel and frame
            orderID = new JLabel("Order number: " + String.valueOf(ID));
            order = new JLabel(Order.findOrder(ID).toString());
            prodID = new JLabel("Enter ID of product to be removed: ");
            JTextField qbox = new JTextField();

            // Button to delete order completely
            delButton = new JButton("Delete Order");
            delButton.addActionListener(new deleteOrder());
        }

        private class deleteOrder implements ActionListener{
            public void actionPerformed(ActionEvent e){
                Order.findOrder(oID).updateOrder(null);
            }
        }

        private class updateListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                int pID = Integer.valueOf(prodID.getText());
                Order newOrder = Order.findOrder(oID).removeProduct(pID);
                Order.findOrder(oID).updateOrder(null);
            }
        }
    }*/
}
