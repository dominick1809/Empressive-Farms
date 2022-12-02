import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

public class OrderTest {
    
    @Test
    public void testEditOrder(ArrayList<Product> products) {
        Order o = new Order("Card", 1, products);
        o.updateOrder(o);
    }

    @Test
    public void testCannotEditOrder(ArrayList<Product> prodts) {
        Order or = new Order("Card", 1, prodts);
        or.updateOrder(or);
    }
}