import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EmployeeTest {

    @Test
    public void testProductCanBeAdded(){
        Employee e = new Employee("employee", "P@ssword1"); 
    }

    @Test
    public void testProductCannotBeAdded(){
        Employee emp = new Employee("employee", "P@ssword1");

    }
}
