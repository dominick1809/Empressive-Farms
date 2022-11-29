import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProductTest {

    @Test
    public void testProductAvailability(){
        Product pr = new Product("Goat", 1350, 5, "Livestock", "Animal");

    }

    @Test
    public void testProductUnavailability(){
        Product p = new Product("Goat", 1350, 0, "Livestock", "Animal");
        
    }

    @Test
    public void testUpdateProductInformation(){
    }

    @Test
    public void testCannotUpdateProductInformation(){
    }
}
