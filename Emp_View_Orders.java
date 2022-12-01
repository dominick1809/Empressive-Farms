import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.*;

public class Emp_View_Orders extends JFrame {
    JTable table;
    JLabel heading;
    JPanel tpanel;
    JPanel hpanel;
    DefaultTableModel model;
    
    public Emp_View_Orders(){
        heading = new JLabel("Pending Orders");
        String[] tableHeadings = {"Order ID","Name","Payment Type","Customer ID", "Status","Fulfill Order"};
        model = new DefaultTableModel(tableHeadings,0);

        TableColumn col = table.getColumnModel().getColumn(-1);
        JCheckBox c = new JCheckBox();
        c.addItemListener(new fulfillListener());
        col.setCellEditor(new DefaultCellEditor(c));

        showTable();

        this.pack();
        this.setVisible(true);
    }

    private void showTable(){
        for(Order o : Order.getOrders()){
            if(o.isFulfilled()){}
            else{
                addToTable(o);
            }
        }
        table = new JTable(model);
    }

    private void addToTable(Order o){
        String[] ord = o.toString().split(" ");
        model.addRow(ord);
    }

    private class fulfillListener implements ItemListener{
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == 1){
                for(int i=0; i<table.getRowCount(); i++){
                    JCheckBox cb = (JCheckBox)table.getValueAt(i, -1);
                    if(cb.isSelected()){
                        int orderID = Integer.valueOf((String)table.getValueAt(i, 0));
                        Order order = Order.findOrder(orderID);
                        order.fulfillOrder();
                        break;
                    }
                }
            }
        }
    }
}