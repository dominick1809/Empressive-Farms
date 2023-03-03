import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SalesReportGUI extends JFrame implements ActionListener {

    private JButton btnGenerateReport;
    private JTextArea txtReport;

    public SalesReportGUI() {
        setTitle("Sales Report");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create the button and add an action listener to it
        btnGenerateReport = new JButton("Generate Report");
        btnGenerateReport.addActionListener(this);

        // Create the text area
        txtReport = new JTextArea();

        // Create a panel to hold the controls
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(btnGenerateReport, BorderLayout.NORTH);
        panel.add(new JScrollPane(txtReport), BorderLayout.CENTER);

        // Add the panel to the frame
        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getSource() == btnGenerateReport) {
            GenerateSalesReport report = new GenerateSalesReport(PlaceOrderGUI.getOrders());

            // Generate the report and display it in the text area
            String report = salesReport.generateReport();
            txtReport.setText(report);

    }

    

    public static void main(String[] args) {
        new SalesReportGUI();
    }
}
