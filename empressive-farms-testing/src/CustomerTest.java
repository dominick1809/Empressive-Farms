import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void testPlaceOrder() {
        Product p = new Product("Animal", 480, 15, "Livestock", "Animal");
        Order o = new Order("Animal", 1, p);
        Customer c = new Customer("customer", "pAs$worD2");
        c.placeOrder(o);
    }

    @Test
    public void testCannotPlaceOrder() {
        Product p = new Product("Desert Rose", 250, 7, "Floriculture", "Flower");
        Order o = new Order("Flower", 2, p);
        Customer c = new Customer("customer", "pAs$worD2");
        c.placeOrder(o);
    }
}