import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class vieworders 
{
    public JFrame frame;
	public JTextField type;
	public JTextField name;
	public JTextField age;
	public JTextField price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					vieworders window = new vieworders();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    /**
	 * Create the application.
	 */
	public vieworders() 
	{
		initialize();
		frame.setVisible(true);
	}

    /**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame("View Orders");
		frame.setBounds(300, 70, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		JLabel lblNewLabel_6 = new JLabel("All Orders");
		lblNewLabel_6.setBounds(375, 41, 206, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("Product Name ");
		lblNewLabel_1.setBounds(35, 123, 101, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Payment Type");
		lblNewLabel_2.setBounds(170, 123, 117, 16);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_8 = new JLabel("Payment Date");
		lblNewLabel_8.setBounds(320, 123, 117, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_3 = new JLabel("Order Date");
		lblNewLabel_3.setBounds(465, 123, 101, 16);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("Order ID");
		lblNewLabel_5.setBounds(600, 123, 101, 16);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_7 = new JLabel("Status");
		lblNewLabel_7.setBounds(700, 123, 101, 16);
		frame.getContentPane().add(lblNewLabel_7);



		// this varaible is for verticle positioning of labels 
		int y = 123+22; 
		
		
		//loop through the list and display it

		/*for(int i=0;i<employee_screen.lst.size();i++) 
		{
			product g = employee_screen.lst.get(i);
			lblNewLabel_1 = new JLabel(g.getName());
			lblNewLabel_1.setBounds(119, y, 101, 16);
			frame.getContentPane().add(lblNewLabel_1);
			
			lblNewLabel_2 = new JLabel(String.valueOf(g.getPrice())+" usd");
			lblNewLabel_2.setBounds(260, y, 117, 16);
			frame.getContentPane().add(lblNewLabel_2);
			
			lblNewLabel_3 = new JLabel(g.getType());
			lblNewLabel_3.setBounds(404, y, 251, 16);
			frame.getContentPane().add(lblNewLabel_3);
			
			lblNewLabel_4 = new JLabel(String.valueOf(g.getAge()));
			lblNewLabel_4.setBounds(570, y, 251, 16);
			frame.getContentPane().add(lblNewLabel_4);
			
			y+=22;
		} */
		
		
		
        




        JButton btnNewButton = new JButton("EDIT/DELETE ORDERS"); 
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new editdeleteorders();           //EDIT/DELETE ORDERS FUNCTION!!!!!!!!
			}
		});

        btnNewButton.setBounds(245, 464, 300, 29);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setBackground(Color.MAGENTA); //changes the color of the button
		
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new employee_screen();
			}
		});

		btnNewButton_1.setBounds(340, 505, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setBackground(Color.MAGENTA); //changes the color of the button
		
	}
    
}
