import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class GenerateSalesReport {
    
    private List<Order> orders;
    
    public GenerateSalesReport(List<Order> orders) {
        this.orders = orders;
    }
    
    public String generateReport() {
        // Code to generate the sales report goes here
        String report = "Sales Report\n\n";
        report += "Product ID\tQuantity\tTotal Sales\n";
        report += "-----------------------------------------------\n";
        
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
        return 10.0; // Sample unit price for testing
    }
    
    private int getProductQuantity(int productId) {
        // Code to get the quantity of a product goes here
        // We can use a database or a data file to get this information
        return 5; // Sample quantity for testing
    }
    
}




