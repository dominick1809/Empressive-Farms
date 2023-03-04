import java.io.FileWriter;
import java.io.IOException;

public class Employee {
    private String username;
    private String password;
    
    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public void saveToFile(String filename) throws IOException {
        FileWriter writer = new FileWriter("Employee.txt", true);
        writer.write(username);
        writer.write(password);
        writer.close();
    }
}
