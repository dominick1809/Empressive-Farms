import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class AvailableGoodsGUI extends JFrame {

    private JButton btnBack;

    public AvailableGoodsGUI() 
    {
        setTitle("Available Goods");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        getContentPane().setBackground(Color.CYAN); //set background color
    
        // Read data from text file and store it in a two-dimensional array
        Object[][] data = readDataFromFile("AddProductData.txt");

        // Define column names
        String[] columnNames = {"Product ID", "Name", "Type", "Category", "Unit Price"};

        // Create the table with the data and column names
        JTable table = new JTable(data, columnNames);
    
        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    
        // Create the back button
        btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            CustomerScreenGUI customerScreen = new CustomerScreenGUI();
            customerScreen.setVisible(true);
            dispose();
        });
    
        // Add the back button to the bottom panel
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(btnBack);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    
        // Show the window
        setVisible(true);

        btnBack.setBackground(Color.RED);
    }

    /**
     * Reads data from a text file and returns a two-dimensional array
     * @param fileName the name of the file to read from
     * @return a two-dimensional array containing the data read from the file
     */
    private Object[][] readDataFromFile(String fileName) {
        Object[][] data = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Get the number of lines in the file
            int numLines = 0;
            while (br.readLine() != null) {
                numLines++;
            }
    
            // Initialize the data array with the number of lines and 5 columns
            data = new Object[numLines][5];
    
            // Read each line of the file and store the data in the array
            br.close();
            BufferedReader br2 = new BufferedReader(new FileReader(fileName));
            String line;
            int i = 0;
            while ((line = br2.readLine()) != null) {
                String[] fields = line.split(",");
                for (int j = 0; j < fields.length; j++) {
                    data[i][j] = fields[j];
                }
                i++;
            }
            br2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    
    

    public static void main(String[] args) {
        new AvailableGoodsGUI();
    }
}
