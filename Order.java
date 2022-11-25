import java.sql.Date;
import java.util.ArrayList;

class Order {
    private int orderID;
    private ArrayList<Product> products;
    private String paymentType;
    private Date pd_Date;
    private boolean status;

    // Class constructor
    public Order(){}

    public boolean isFulfilled(){
        return true;
    }

    public void updateOrder(){}

    public String toString(){
        return "hello";
    }
}