import java.util.ArrayList;

class Customer{
    private String name;
    private int ID;
    private String password;
    private ArrayList<Order> orders;

    // Class constructor
    public Customer(){}

    public boolean checkPassword(String pswrd){
        return true;
    }

    public Customer findCustomer(String name){
        return this;
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }

    public void placeOrder(){}

    public String toString(){
        return "hello";
    }
}