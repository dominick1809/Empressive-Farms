import java.io.FileWriter;
import java.io.IOException;

public class Customer {
    private String username;
    private String password;
    
    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public void saveToFile(String filename) throws IOException {
        FileWriter writer = new FileWriter("Customer.txt", true);
        writer.write(username + "," + password + "\n");
        writer.close();
    }
}


