import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateSalesReport {
    
    private List<Order> orders;
    
    public GenerateSalesReport(String ordersFilePath) {
        orders = readOrdersFromFile(ordersFilePath);
    }
    
    private List<Order> readOrdersFromFile(String filePath) {
        List<Order> orders = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int orderId = Integer.parseInt(values[0]);
                int productId = Integer.parseInt(values[1]);
                int quantity = Integer.parseInt(values[2]);
                Order order = new Order(productId, quantity);
                orders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }
    
    public String generateReport() {
        // Code to generate the sales report goes here
        String report = "Sales Report\n\n";
        report += "Product ID\tQuantity\tTotal Sales\n";
        report += "----------------------------------------------------------\n";
        
        // Loop through the orders and calculate the total sales for each product
        Map<Integer, Double> productSalesMap = new HashMap<>();
        for (Order order : orders) {
            int productId = order.getProductId();
            int quantity = order.getQuantity();
            double unitPrice = getProductUnitPrice(productId);
            double totalSales = quantity * unitPrice;
            
            if (productSalesMap.containsKey(productId)) {
                totalSales += productSalesMap.get(productId);
            }
            
            productSalesMap.put(productId, totalSales);
        }
        
        // Add the product sales to the report
        for (Map.Entry<Integer, Double> entry : productSalesMap.entrySet()) {
            int productId = entry.getKey();
            double totalSales = entry.getValue();
            report += productId + "\t\t" + getProductQuantity(productId) + "\t\t" + totalSales + "\n";
        }
        
        return report;
    }
    
    private double getProductUnitPrice(int productId) {
        // Code to get the unit price of a product goes here
        // We can use a database or a data file to get this information
        // Here we will use a Products.txt file for testing
        try (BufferedReader br = new BufferedReader(new FileReader("Products.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                double unitPrice = Double.parseDouble(values[2]);
                if (id == productId) {
                    return unitPrice;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
    
    private int getProductQuantity(int productId) {
        int quantity = 0;
        try {
            // Open the Orders.txt file for reading
            BufferedReader reader = new BufferedReader(new FileReader("Orders.txt"));
    
            // Read each line of the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into fields
                String[] fields = line.split(",");
    
                // Check if the product ID matches
                if (Integer.parseInt(fields[1]) == productId) {
                    // Add the quantity to the total
                    quantity += Integer.parseInt(fields[2]);
                }
            }
    
            // Close the file
            reader.close();
        } catch (Exception e) {
            // Handle any errors
            e.printStackTrace();
        }
    
        return quantity;
    }
    
}
    
