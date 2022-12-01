import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Customer{
    private String name;
    private int ID;
    private String password;
    private ArrayList<Order> orders;    // change to list of id for the order so avoid duplication of files
    private static ArrayList<Customer> clist;

    // Class constructors
    public Customer(String name, String password){
        this.name = name;
        this.password = password;
        if(clist.size() == 0){
            fetch_data();
        }
        ID = clist.size() + 1;
        clist.add(this);
    }

    // constructor to be used by file method
    private Customer(int ID, String name, String password){
        orders = new ArrayList<Order>();
        this.ID = ID;
        this.name = name;
        this.password = password;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public boolean checkPassword(String pswrd){
        return pswrd == password;
    }

    public static Customer findCustomer(String name){
        for(Customer c: clist){
            if(c.getName() == name){
                return c;
            }
        }
        return null;
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }

    public void placeOrder(Order O1){
        orders.add(O1);
        for(Product p : O1.getProducts()){
            Product pr = Product.findProduct(p.getID());
            p.updateProduct(new Product(p.getName(), p.getPrice(), pr.getQty() - p.getQty(), p.getCategory(), p.getType()));
        }
    }

    public String toString(){
        String str = String.valueOf(ID) + " " + name + " " + password;
        for( Order o : orders){
            str += String.valueOf(o.getID());
        }
        return str;
    }

    private void fetch_data(){
        try{
            Scanner scan = new Scanner(new File("Customer.dat"));
            while(scan.hasNext()){
                String[] c = scan.nextLine().split(" ");
                Customer c1 = new Customer(Integer.valueOf(c[0]),c[1],c[2]);
                if(c.length > 3){
                    for(int i = 0; i<c.length; i++){
                        Order o = Order.findOrder(Integer.valueOf(c[i+3]));
                        if(o != null){
                            c1.placeOrder(o);
                        }
                    }
                }
                clist.add(c1);
            }
        }catch(FileNotFoundException fe){}
    }

    public static void saveData(){
        try{
            PrintWriter pen = new PrintWriter("Customer.dat");
            for(Customer c : clist){
                pen.println(c);
            }
            pen.close();
        }catch(FileNotFoundException fe){}
    }
}