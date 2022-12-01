import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer_Screen extends JFrame{
	private JFrame frame;
    private String cname;
		
	//this constructor is called when the object is created
	public Customer_Screen(String name) 
	{
        frame = this;
        cname = name;
        JPanel panel = new JPanel();

		// greet the customer with a personalized message
        JLabel greeting = new JLabel("Hello " + name); 
        greeting.setBounds(145, 60, 900, 45);            // defining the position and size
        greeting.setFont(new Font("Serif", Font.ITALIC, 35));    //sts the font style ,type and size
        panel.add(greeting);

        // Display menu options using buttons

        JButton viewGoods = new JButton("VIEW AVAILABLE GOODS");     
        viewGoods.setBounds(250, 165, 300, 29);         //sets its position and size
        viewGoods.setBackground(Color.cyan);                                //changes the color of the button
        viewGoods.addActionListener(new viewGoodsListener());               // add functionality to button
        panel.add(viewGoods);
        
        JButton viewOrders = new JButton("VIEW ORDERS");
        viewOrders.setBounds(250, 269, 300, 29);
        viewOrders.setBackground(Color.cyan);
        viewOrders.addActionListener(new viewOrdersListener());   
        panel.add(viewOrders);      
		
		JButton saveClose = new JButton("SAVE CHANGES AND CLOSE");
        saveClose.setBounds(250, 374, 300, 29);
        saveClose.setBackground(Color.cyan);
        saveClose.addActionListener(new saveCloseListener());
        panel.add(saveClose);

        this.setContentPane(panel);
        this.pack();
		this.setVisible(true);
	}
	
	private class viewGoodsListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            new Available_Goods(cname);
            frame.dispose();
        }
    }

    private class viewOrdersListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //c new View_Orders(cname);
            //frame.dispose;
        }
    }

    private class saveCloseListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Customer.saveData();
            Employee.saveData();
            Order.saveData();
            Product.saveData();
        }
    }
}