import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class viewavailablegoods 
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
					viewavailablegoods window = new viewavailablegoods();
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
	public viewavailablegoods() 
	{
		initialize();
		frame.setVisible(true);
	}

    /**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame("View Avilable Goods");
		frame.setBounds(300, 70, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		JLabel lblNewLabel_6 = new JLabel("All Available Goods");
		lblNewLabel_6.setBounds(350, 41, 206, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("Product Name ");
		lblNewLabel_1.setBounds(130, 123, 101, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product Unit Price");
		lblNewLabel_2.setBounds(280, 123, 117, 16);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_8 = new JLabel("Product Quantity");
		lblNewLabel_8.setBounds(430, 123, 117, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_3 = new JLabel("Product Category");
		lblNewLabel_3.setBounds(580, 123, 101, 16);
		frame.getContentPane().add(lblNewLabel_3);

	

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
		
				
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new customer_screen();
			}
		});

		btnNewButton_1.setBounds(340, 505, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
        btnNewButton_1.setBackground(Color.cyan); //changes the color of the button
		
	}
    
}
