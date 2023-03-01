import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewProductInfoGUI extends JFrame implements ActionListener {
    private JTable table;
    private JButton returnButton;
    
    public ViewProductInfoGUI(DefaultTableModel model) {
        // Create the table using the given model
        table = new JTable(model);
        
        // Create a scroll pane to hold the table
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Create the return button
        returnButton = new JButton("Return to Employee Screen");
        returnButton.addActionListener(this);

        // Create a panel to hold the return button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(returnButton);

        // Add the scroll pane and button panel to the JFrame
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        setTitle("View Product Information");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the JFrame on the screen
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton) {
            // Return to the employee screen
            new EmployeeScreenGUI();
            dispose(); // Close the current JFrame
        }
    }
}
