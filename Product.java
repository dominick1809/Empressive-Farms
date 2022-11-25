class Product {
    private String name;
    private float unit_price;
    private float quantity;
    private String category;
    private String type;

    // Class constructor
    public Product(){}

    public boolean isAvailable(quantity_r){
        if (quantity ==0 and quantity_r >= quantity){
            return true;
        }
        else{
            system.out.println("Quantity requested cannot be fulfilled")
        }
    }

    public void updateProduct(){}

    public String toString(){
        return "hello";
    }
}
