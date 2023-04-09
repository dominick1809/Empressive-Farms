import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ViewPendingOrdersGUI extends JFrame {
    

    private JButton btnBack;
    private Object[][] data;

    public ViewPendingOrdersGUI() 
    {
        setTitle("Orders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        getContentPane().setBackground(Color.CYAN); //set background color
    
        // Read data from text file and store it in a two-dimensional array
        data = readDataFromFile("Orders.txt");

        // Define column names
        String[] columnNames = {"Order #", "Product ID", "Product Name", "Quantity", "Unit Price", "Total Price"};

        // Create the table with the data and column names
        JTable table = new JTable(data, columnNames);
        
    
        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    
        // Create the back button
        btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            EmployeeScreenGUI employeeScreen = new EmployeeScreenGUI();
            employeeScreen.setVisible(true);
            dispose();
        });
    
        // Add the back button to the bottom panel
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(btnBack);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    
        // Show the window
        setVisible(true);

        btnBack.setBackground(Color.GRAY);
    }

    /**
     * Reads data from a text file and returns a two-dimensional array
     * @param fileName the name of the file to read from
     * @return a two-dimensional array containing the data read from the file
     */
    private Object[][] readDataFromFile(String fileName) {
        Object[][] data = null;
        try (BufferedReader br = new BufferedReader(new FileReader("Orders.txt"))) {
            // Get the number of lines in the file
            int numLines = 0;
            while (br.readLine() != null) {
                numLines++;
            }
        
            // Initialize the data array with the number of lines and 6 columns
            data = new Object[numLines][6];
        
            // Read each line of the file and store the data in the array
            br.close();
            BufferedReader br2 = new BufferedReader(new FileReader("Orders.txt"));
            String line;
            int i = 0;
            while ((line = br2.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 6) { // check that the line has 6 fields
                    // Check that the unit price is not empty before storing it as a double
                    if (!fields[4].isEmpty()) {
                        data[i][4] = Double.parseDouble(fields[4]);
                    }
                    for (int j = 0; j < fields.length; j++) {
                        data[i][j] = fields[j];
                    }
                    i++;
                }
            }
            
            br2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    

    private List<String> readProductNamesFromFile(String fileName) {
        List<String> productNames = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 2) { // check that the line has at least 2 fields
                    productNames.add(fields[1]);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productNames;
    }
    
    public List<String> getProductNames() {
        return readProductNamesFromFile("Orders.txt");
    }
    
    
    // Define the getUnitPrice method to retrieve the unit price for a given row index
    public double getUnitPrice(int rowIndex) {
        Object[][] data = readDataFromFile("Orders.txt");
        return (double) data[rowIndex][5];
    }
    

    public static void main(String[] args) {
        new ViewPendingOrdersGUI();
    }
}