import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class placeorder 
{
    public JFrame frame;
	public JTextField unitprice;
	public JTextField name;
	public JTextField category;
	public JTextField quantity;

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
					placeorder window = new placeorder();
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
	public placeorder() 
	{
		initialize();
		frame.setVisible(true);
	}

    /**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame("Place Order");
		frame.setBounds(300, 70, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		JLabel lblNewLabel_4 = new JLabel("Order Placement");
		lblNewLabel_4.setBounds(330, 51, 200, 16);
		frame.getContentPane().add(lblNewLabel_4);
	
		
		JLabel lblNewLabel = new JLabel("Product Name");
		lblNewLabel.setBounds(277, 107, 100, 16);
		frame.getContentPane().add(lblNewLabel);

		name = new JTextField();
		name.setBounds(277, 135, 245, 26);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Product Quantity");
		lblNewLabel_1.setBounds(277, 184, 100, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		unitprice = new JTextField();
		unitprice.setBounds(277, 212, 245, 26);
		frame.getContentPane().add(unitprice);
		unitprice.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Payment Type");
		lblNewLabel_2.setBounds(277, 260, 100, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		quantity = new JTextField();
		quantity.setBounds(277, 295, 245, 26);
		frame.getContentPane().add(quantity);
		quantity.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Order Date");
		lblNewLabel_3.setBounds(277, 345, 100, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		category = new JTextField();
		category.setBounds(277, 373, 245, 26);
		frame.getContentPane().add(category);
		category.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(356, 424, 120, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Place Order");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
                new customer_screen();
				
			}
		});
		
		btnNewButton.setBounds(340, 464, 117, 29);
		frame.getContentPane().add(btnNewButton);
        btnNewButton.setBackground(Color.cyan); //changes the color of the button
		
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
