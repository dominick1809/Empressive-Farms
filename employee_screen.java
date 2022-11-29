import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class employee_screen
{

	public JFrame frame; 
	
	
		
	public employee_screen() //this constructor is called when the object is created
	{
		initialize();
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
		
		
		JLabel lblNewLabel = new JLabel("Empressive Farms Employee's Section"); //used to add A label message

		
		lblNewLabel.setBounds(145, 60, 900, 45); //set bound function defines the position and size, like we did for frame above


		frame.getContentPane().add(lblNewLabel); //once we are done with label creation, position and its size. then we will add this to the main frame

		lblNewLabel.setFont(new Font("Serif", Font.ITALIC, 35)); //sts the font style ,type and size

		
		

		
		

		JButton btnNewButton = new JButton("ADD NEW PRODUCTS/GOODS"); //Jbutton will create a button and its constructor will take in the name of button
		
		btnNewButton.addActionListener(new ActionListener() //this is the event handler code for this button, when we click on this button the following function will execute
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new addnewproducts();               //ADD NEW PRODUCTS/GOODS FUNCTION!!!!!!!!!!
			}
		});

		btnNewButton.setBounds(250, 130, 300, 29); //sets its position and size 
		
		frame.getContentPane().add(btnNewButton); //then adds it to the frame

		btnNewButton.setBackground(Color.MAGENTA); //changes the color of the button
		
		
		JButton btnNewButton_1 = new JButton("UPDATE PRODUCT INFORMATION"); //this is the second button in the gui

		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new updateproductinfo();          //UPDATE PRODUCT INFORMATION FUNCTION!!!!!!!!!!!!
			}
		});
		btnNewButton_1.setBounds(250, 215, 300, 29); //sets its position and size 

		frame.getContentPane().add(btnNewButton_1); //then adds it to the frame

        btnNewButton_1.setBackground(Color.MAGENTA); //changes the color of the button
		
		
		
		JButton btnNewButton_2 = new JButton("VIEW PENDING ORDERS"); //this is the third button in the gui

		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new vieworders();           //VIEW ORDERS FUNCTION!!!!!!!!!!!!!!
			}
		});
		
		btnNewButton_2.setBounds(250, 300, 300, 29); //sets its position and size 

		frame.getContentPane().add(btnNewButton_2); //then adds it to the frame

		btnNewButton_2.setBackground(Color.MAGENTA); //changes the color of the button



		

		

        JButton btnNewButton_4 = new JButton("GENERATE SALES REPORT"); //this is the fifth button in the gui

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

        btnNewButton_4.setBackground(Color.MAGENTA); //changes the color of the button



		JButton btnNewButton_5 = new JButton("Save");
		btnNewButton_5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});

		btnNewButton_5.setBounds(345, 470, 117, 29);
		frame.getContentPane().add(btnNewButton_5);
		btnNewButton_5.setBackground(Color.MAGENTA); //changes the color of the button

		JButton btnNewButton_6 = new JButton("Close");
		btnNewButton_6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});

		btnNewButton_6.setBounds(345, 510, 117, 29);
		frame.getContentPane().add(btnNewButton_6);
		btnNewButton_6.setBackground(Color.MAGENTA); //changes the color of the button







	}


	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try 
				{
					employee_screen window = new employee_screen();
					window.frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}


}

