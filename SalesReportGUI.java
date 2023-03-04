import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SalesReportGUI {
    
    private JFrame frame;
    private JTextArea reportTextArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SalesReportGUI window = new SalesReportGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SalesReportGUI() {
        initialize();
        generateReport();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        frame.setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        reportTextArea = new JTextArea();
        reportTextArea.setEditable(false);
        scrollPane.setViewportView(reportTextArea);
    }
    
    private void generateReport() {
        String ordersFilePath = "Orders.txt";
        GenerateSalesReport salesReport = new GenerateSalesReport(ordersFilePath);
        String report = salesReport.generateReport();
        reportTextArea.setText(report);
    }

    public void setVisible(boolean b) {
    }

}
