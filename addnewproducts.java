import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class addnewproducts
{
    public JFrame frame;
	public JTextField unitprice;
	public JTextField name;
	public JTextField category;
	public JTextField quantity;
	public JTextField type;

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
					addnewproducts window = new addnewproducts();
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
	public addnewproducts() 
	{
		initialize();
		frame.setVisible(true);
	}

    /**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame("Add New Products/Goods");
		frame.setBounds(300, 70, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		JLabel lblNewLabel_4 = new JLabel("Add New Product/Good");
		lblNewLabel_4.setBounds(330, 40, 200, 16);
		frame.getContentPane().add(lblNewLabel_4);
	
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(277, 90, 61, 16);
		frame.getContentPane().add(lblNewLabel);

		name = new JTextField();
		name.setBounds(277, 115, 245, 26);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Unit Price");
		lblNewLabel_1.setBounds(277, 157, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		unitprice = new JTextField();
		unitprice.setBounds(277, 190, 245, 26);
		frame.getContentPane().add(unitprice);
		unitprice.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setBounds(277, 238, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		quantity = new JTextField();
		quantity.setBounds(277, 265, 245, 26);
		frame.getContentPane().add(quantity);
		quantity.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Category");
		lblNewLabel_3.setBounds(277, 310, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		category = new JTextField();
		category.setBounds(277, 330, 245, 26);
		frame.getContentPane().add(category);
		category.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Type");
		lblNewLabel_6.setBounds(277, 370, 61, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		type = new JTextField();
		type.setBounds(277, 400, 245, 26);
		frame.getContentPane().add(type);
		type.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(356, 450, 120, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		
		btnNewButton.setBounds(340, 480, 117, 29);
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

		btnNewButton_1.setBounds(340, 520, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setBackground(Color.MAGENTA); //changes the color of the button
		
	}


    











}