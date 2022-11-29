import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class updatebutton
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
					updatebutton window = new updatebutton();
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
	public updatebutton() 
	{
		initialize();
		frame.setVisible(true);
	}

    /**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame("Update Product Information");
		frame.setBounds(300, 70, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

        JLabel lblNewLabel_6 = new JLabel("Updated Product Information");
		lblNewLabel_6.setBounds(310, 41, 206, 16);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_4 = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("Product Name ");
		lblNewLabel_1.setBounds(130, 123, 101, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Unit Price");
		lblNewLabel_2.setBounds(280, 123, 117, 16);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_8 = new JLabel("Quantity");
		lblNewLabel_8.setBounds(430, 123, 117, 16);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_3 = new JLabel("Category");
		lblNewLabel_3.setBounds(580, 123, 101, 16);
		frame.getContentPane().add(lblNewLabel_3);


















        JButton btnNewButton_5 = new JButton("Save");
		btnNewButton_5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
                new updateproductinfo();
				
			}
		});

		btnNewButton_5.setBounds(345, 470, 117, 29);
		frame.getContentPane().add(btnNewButton_5);
		btnNewButton_5.setBackground(Color.MAGENTA); //changes the color of the button

		JButton btnNewButton_6 = new JButton("Back");
		btnNewButton_6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
                new updateproductinfo();
				
			}
		});

		btnNewButton_6.setBounds(345, 510, 117, 29);
		frame.getContentPane().add(btnNewButton_6);
		btnNewButton_6.setBackground(Color.MAGENTA); //changes the color of the button



    }





}