import java.util.ArrayList;

class Customer{
    private String name;
    private int ID;
    private String password;
    private ArrayList<Order> orders;
    private String cinfo;

    // Class constructor
    public Customer(){}

    public boolean checkPassword(String pswrd){
        return pswrd == password ;
    }

    public Customer findCustomer(String name){
        return this;
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }

    public void placeOrder(Order O1){
        orders.add (O1);
       
    }

    public String toString(){
        String cinfo= (String.ValueOf(ID)+" " +name + " " +password " "+orders)
        return "cinfo"
    }
}
