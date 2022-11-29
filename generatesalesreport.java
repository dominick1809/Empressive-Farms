import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class generatesalesreport 
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
					generatesalesreport window = new generatesalesreport();
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
	public generatesalesreport() 
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
