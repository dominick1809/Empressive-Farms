import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Employee_Screen
{
	public JFrame frame; 
	
	// Class constructor	
	public Employee_Screen()
	{
		initialize();
        frame.pack();
		frame.setVisible(true);
	}
	
	private void initialize() //this method will make the GUI
	{
		frame = new JFrame(); //create the frame object
        frame.setTitle("EMPRESSIVE FARMS"); //sets the frame title
		frame.setBounds(300, 70, 800, 600); //set its position, width and height // x-axix, y-axix, width, height
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //this method will close the frame on pressing cross button in upper corner
		frame.getContentPane().setLayout(null); //layout manager is set to null
        frame.getContentPane().setBackground(Color.gray); //sets the background color for the frame
			
        // Creating and adding a heading to the frame
		JLabel heading = new JLabel("Empressive Farms Employee's Section"); 
		heading.setBounds(145, 60, 900, 45); 
		frame.getContentPane().add(heading); //once we are done with label creation, position and its size. then we will add this to the main frame
    	heading.setFont(new Font("Serif", Font.ITALIC, 35)); //sts the font style ,type and size

		// Button to use to add product
		JButton addButton = new JButton("ADD NEW PRODUCTS/GOODS"); //Jbutton will create a button and its constructor will take in the name of button
		addButton.addActionListener(new ActionListener() //this is the event handler code for this button, when we click on this button the following function will execute
		{
			public void actionPerformed(ActionEvent e) 
			{
				new addNewProducts();
                frame.dispose();
			}
		});

        // adjusting appearance
		addButton.setBounds(250, 130, 300, 29); //sets its position and size 
		frame.getContentPane().add(addButton); //then adds it to the frame
		addButton.setBackground(Color.MAGENTA); //changes the color of the button
		
        // Button to view product information
		/*JButton updateButton = new JButton("VIEW PRODUCT INFORMATION"); //this is the second button in the gui
		updateButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new ViewProduct(); 
                frame.dispose();   
			}
		});

        // adjusting appearance
		updateButton.setBounds(250, 215, 300, 29); //sets its position and size 
		frame.getContentPane().add(updateButton); //then adds it to the frame
        updateButton.setBackground(Color.MAGENTA); //changes the color of the button
		*/

		// Button to view orders		
		JButton viewButton = new JButton("VIEW PENDING ORDERS"); //this is the third button in the gui
		viewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new Emp_View_Orders();           
			}
		});
		
        // adjusting appearance
		viewButton.setBounds(250, 300, 300, 29); //sets its position and size 
		frame.getContentPane().add(viewButton); //then adds it to the frame
		viewButton.setBackground(Color.MAGENTA); //changes the color of the button

       /*JButton btnNewButton_4 = new JButton("GENERATE SALES REPORT"); //this is the fifth button in the gui

		btnNewButton_4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new generatesalesreport();           //GENERATE SALES REPORT FUNCTION!!!!!!!!
			}
		});

		btnNewButton_4.setBounds(250, 400, 300, 29); //sets its position and size 

		frame.getContentPane().add(btnNewButton_4); //then adds it to the frame

        btnNewButton_4.setBackground(Color.MAGENTA); //changes the color of the button*/

        // Button to save changes made and exit
		JButton saveButton = new JButton("Save and Exit");
		saveButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
                Product.saveData();
                Order.saveData();
				frame.dispose();
			}
		});

        // adjusting appearance
		saveButton.setBounds(345, 470, 117, 29);
		frame.getContentPane().add(saveButton);
		saveButton.setBackground(Color.MAGENTA); //changes the color of the button
	}

    private class addNewProducts extends JFrame{ 
        JLabel namelbl;
        JTextField nametext;
        JLabel pricelbl;
        JTextField pricetext;
        JLabel qtylbl;
        JTextField qtytext;
        JLabel catlbl;
        JTextField catText;
        JLabel typelbl;
        JTextField typetext;
        JButton addProd;
        JFrame thisframe;
        JPanel pane;

        public addNewProducts(){
            thisframe = this;
            pane = new JPanel();
            JPanel npanel = new JPanel();
            JPanel ppanel = new JPanel();
            JPanel qpanel = new JPanel();
            JPanel cpanel = new JPanel();
            JPanel tpanel = new JPanel();
            JPanel bpanel = new JPanel();

            // product name 
            namelbl = new JLabel("Product Name");
            namelbl.setBounds(277, 107, 100, 16);
            npanel.add(namelbl);
            nametext = new JTextField();
            npanel.add(nametext);

            // product price
            pricelbl = new JLabel("Product Unit Price");
            pricelbl.setBounds(277, 107, 100, 16);
            ppanel.add(pricelbl);
            pricetext = new JTextField();
            ppanel.add(pricetext);

            // product quantity
            qtylbl = new JLabel("Product Quantity");
            qtylbl.setBounds(277, 107, 100, 16);
            qpanel.add(qtylbl);
            qtytext = new JTextField();
            qpanel.add(qtytext);

            // product category
            catlbl = new JLabel("Product Category");
            catlbl.setBounds(277, 107, 100, 16);
            cpanel.add(catlbl);
            catText = new JTextField();
            cpanel.add(catText);

            // product type
            typelbl = new JLabel("Product Type");
            typelbl.setBounds(277, 107, 100, 16);
            tpanel.add(typelbl);
            typetext = new JTextField();
            tpanel.add(typetext);

            // Button to indicate textfields are filled
            addProd = new JButton("Add New Product");
            addProd.addActionListener(new addProdListener());
            bpanel.add(addProd);

            pane.add(npanel);
            pane.add(ppanel);
            pane.add(qpanel);
            pane.add(cpanel);
            pane.add(tpanel);
            pane.add(bpanel);

            this.add(pane);
            this.pack();
            this.setVisible(true);
        }

        //name, price, quantity, categoy, type
        private class addProdListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                String name = nametext.getText();
                float price = Float.valueOf(pricetext.getText());
                float qty = Float.valueOf(qtytext.getText());
                String cat = catText.getText();
                String type = typetext.getText();
                new Product(name, price, qty, cat, type);
                thisframe.dispose();
            }
        }
    }
}
