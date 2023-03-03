import java.util.Date;

public class PlaceOrder {
    private String productName;
    private int productId;
    private int quantity;
    private Date orderDate;

    public placeOrder(String productName, int productId, int quantity) {
        this.productName = productName;
        this.productId = productId;
        this.quantity = quantity;
        this.orderDate = new Date();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
