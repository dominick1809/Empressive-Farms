import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

public class View_OrdersTest {

    @Test
    public void testDeleteOrder() {
        View_Orders v = new View_Orders(null);
        v.deleteOrder();
    }

    @Test
    public void testCannotDeleteOrder() {
        View_Orders v = new View_Orders(null);
        v.deleteOrder();
    }
    
}
