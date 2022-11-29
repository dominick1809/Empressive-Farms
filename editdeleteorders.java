import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class editdeleteorders 
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
					editdeleteorders window = new editdeleteorders();
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
	public editdeleteorders() 
	{
		initialize();
		frame.setVisible(true);
	}

    /**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(300, 70, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Product Name");
		lblNewLabel.setBounds(277, 107, 100, 16);
		frame.getContentPane().add(lblNewLabel);

		name = new JTextField();
		name.setBounds(277, 135, 245, 26);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Product Unit Price");
		lblNewLabel_1.setBounds(277, 184, 150 , 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		unitprice = new JTextField();
		unitprice.setBounds(277, 212, 245, 26);
		frame.getContentPane().add(unitprice);
		unitprice.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Product Quantity");
		lblNewLabel_2.setBounds(277, 260, 100, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		quantity = new JTextField();
		quantity.setBounds(277, 295, 245, 26);
		frame.getContentPane().add(quantity);
		quantity.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Product Category");
		lblNewLabel_3.setBounds(277, 345, 100, 16);
		frame.getContentPane().add(lblNewLabel_3);

		category = new JTextField();
		category.setBounds(277, 373, 245, 26);
		frame.getContentPane().add(category);
		category.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Save"); 
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				new vieworders();           
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
				new vieworders();
			}
		});

		btnNewButton_1.setBounds(340, 505, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setBackground(Color.MAGENTA); //changes the color of the button
		
	}
    
}
