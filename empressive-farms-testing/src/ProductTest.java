import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProductTest {

    @Test
    public void testProductAvailability() {
        Product pr = new Product("Goat", 1350, 3, "Livestock", "Animal");
        pr.isAvailable();
        boolean available = true;
        assertEquals((boolean) available, (boolean) pr.isAvailable());
    }

    @Test
    public void testProductUnavailability() {
        Product p = new Product("Hibiscuis", 350, 5, "Floriculture", "Flower");
        p.isAvailable();
        boolean available = false;
        assertEquals((boolean) available, (boolean) p.isAvailable());
    }

    @Test
    public void testUpdateProductInformation() {
        Product product = new Product("Papaya", 3, 56, "Fruits and Vegetables", "Fruit");
        product.updateProduct(product);
    }

    @Test
    public void testCannotUpdateProductInformation() {
        Product prod = new Product("Papaya", 3, 12, "Fruits and Vegetables", "Fruit");
        prod.updateProduct(prod);
    }
}
