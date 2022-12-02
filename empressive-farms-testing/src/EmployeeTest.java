import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EmployeeTest {

    @Test
    public static void testProductCanBeAdded(){
        Employee e = new Employee("employee", "P@ssword1"); 
        e.saveData();
    }

    @Test
    public void testProductCannotBeAdded(){
        Employee e = new Employee("employee", "P@ssword1"); 
        e.saveData();
    }
}
