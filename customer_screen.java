import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;



public class customer_screen
{

	public JFrame frame;
	
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try 
				{
					customer_screen window = new customer_screen();
					window.frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public customer_screen() //this constructor is called when the object is created
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
		
		
		

	
		JLabel lblNewLabel = new JLabel("Hello, Welcome to Empressive Farms"); //used to add A label message

		
		lblNewLabel.setBounds(145, 60, 900, 45); //set bound function defines the position and size, like we did for frame above

		frame.getContentPane().add(lblNewLabel); //once we are done with label creation, position and its size. then we will add this to the main frame

		lblNewLabel.setFont(new Font("Serif", Font.ITALIC, 35)); //sts the font style ,type and size

		
		
		JButton btnNewButton = new JButton("VIEW AVAILABLE GOODS"); //Jbutton will create a button and its constructor will take in the name of button
		
		btnNewButton.addActionListener(new ActionListener() //this is the event handler code for this button, when we click on this button the following function will execute
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new viewavailablegoods();               //VIEW AVAILABLE GOODS FUNCTION!!!!!!!!!!
			}
		});
		
		btnNewButton.setBounds(250, 165, 300, 29); //sets its position and size 
	
		frame.getContentPane().add(btnNewButton); //then adds it to the frame

		btnNewButton.setBackground(Color.cyan); //changes the color of the button
		
	
		JButton btnNewButton_1 = new JButton("PLACE ORDER"); //this is the second button in the gui

		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new placeorder();          //PLACE ORDER FUNCTION!!!!!!!!!!!!
			}
		});
		btnNewButton_1.setBounds(250, 269, 300, 29); //sets its position and size 

		frame.getContentPane().add(btnNewButton_1); //then adds it to the frame

		btnNewButton_1.setBackground(Color.cyan); //changes the color of the button
		
	
		
		JButton btnNewButton_2 = new JButton("VIEW ORDERS"); //this is the third button in the gui
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new viewcustomerorders();           //VIEW ORDERS FUNCTION!!!!!!!!!!!!!!
			}
		});

		btnNewButton_2.setBounds(250, 374, 300, 29); //sets its position and size 

		frame.getContentPane().add(btnNewButton_2); //then adds it to the frame

		btnNewButton_2.setBackground(Color.cyan); //changes the color of the button

		
		
	}
}
