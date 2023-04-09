import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DeleteOrderGUI extends JFrame {

    private JPanel contentPane;
    private JTextField txtOrderNumber;
    private String fileName = "Orders.txt"; // File name of the data file

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteOrderGUI frame = new DeleteOrderGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DeleteOrderGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("Delete Order");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(1, 2, 10, 10));

        JLabel lblOrderNumber = new JLabel("Order Number:");
        panel.add(lblOrderNumber);

        txtOrderNumber = new JTextField();
        panel.add(txtOrderNumber);
        txtOrderNumber.setColumns(10);

        JButton btnDelete = new JButton("Delete Order");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteOrder();
            }
        });
        contentPane.add(btnDelete, BorderLayout.SOUTH);
    }
     // Method to delete an order from the Orders.txt file
     private void deleteOrder() {
        // Retrieve the order number to delete from text field
        String orderNumber = txtOrderNumber.getText();

        // Read all lines from the Orders.txt file into a list
        java.util.List<String> lines = new java.util.ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to delete order. Please try again.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Find and remove the line with the matching order number
        boolean orderFound = false;
        for (int i = 0; i < lines.size(); i++) {
            String[] orderData = lines.get(i).split(", ");
            if (orderData.length > 0 && orderData[0].equals(orderNumber)) {
                lines.remove(i);
                orderFound = true;
                break;
            }
        }

        // Write the updated list of lines back to the Orders.txt file
        if (orderFound) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
                JOptionPane.showMessageDialog(this, "Order successfully deleted.", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to delete order. Please try again.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Order not found. Please enter a valid order number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    
}


