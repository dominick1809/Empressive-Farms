public class Order {
    private int productId;
    private int quantity;
    private double totalPrice;
    private String productName; // new field

    public Order(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getProductName() { // new getter
        return productName;
    }

    public void setProductName(String productName) { // new setter
        this.productName = productName;
    }



    AvailableGoodsGUI availableGoodsGUI = new AvailableGoodsGUI();
    double unitPrice = availableGoodsGUI.getUnitPrice(productId);
}

    


