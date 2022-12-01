import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;   
import java.util.Scanner;

class Order {
    private int orderID;
    private Product product;
    private String paymentType;
    private GregorianCalendar pd_Date;
    private boolean status = false;
    private int cID;                    // to identify the customer
    private static ArrayList<Order> olist;

    // Class constructors
    public Order(String ptype, int cID, Product product){
        this.product = product;
        paymentType = ptype;
        this.cID = cID;
        pd_Date = new GregorianCalendar();                              //initializing the variable, done with current date and time
        pd_Date.add(GregorianCalendar.DAY_OF_MONTH,14);         //two weeks after current date order should be ready
        if(olist.size() == 0){
            fetch_data();
        }
        orderID = olist.size();
        olist.add(this);
    }

    // Constructor to be used by fetch data
    private Order(int ID, String ptype, int cID, boolean status){
        paymentType = ptype;
        this.cID = cID;
        //pd_Date = date;
        this.status = status;
    }

    public int getID(){
        return orderID;
    }

    public Product getProducts(){
        return product;
    }

    public static ArrayList<Order> getOrders(){
        return olist;
    }

    public boolean isFulfilled(){
        return status;
    }

    public void fulfillOrder(){
        status = true;
    }

    public void updateOrder(Order o){
        for(Order o1: olist){
            if(o1.getID() == o.getID()){
                o1 = o;
            }
        }
    }

    public static Order findOrder(int ID){
        for(Order o : olist){
            if(o.getID() == ID){
                return o;
            }
        }
        return null;
    }
    
    public String toString(){
        String str = String.valueOf(orderID) + " " + paymentType + " " + String.valueOf(cID) + " " + String.valueOf(status) + " " + product.toString();
        return str + " " + String.valueOf(pd_Date.get(Calendar.YEAR)) + " " + pd_Date.get(Calendar.MONTH) + " " + pd_Date.get(Calendar.DATE);
    }

    private void fetch_data(){
        try{
            Scanner scan = new Scanner(new File("Order.dat"));
            while(scan.hasNext()){
                String[] o = scan.nextLine().split(" ");
                Order o1 = new Order(Integer.valueOf(o[0]) ,o[1],Integer.valueOf(o[2]), Boolean.valueOf(o[3]));
                o1.product = new Product(o[4], Float.valueOf(o[5]), Float.valueOf(o[6]),o[7],o[8]);
                pd_Date = new GregorianCalendar(Integer.valueOf(o[9]),Integer.valueOf(o[10]),Integer.valueOf(o[11]));
                olist.add(o1);
            }
        }catch(FileNotFoundException fe){}
    }

    public static void saveData(){
        try{
            PrintWriter pen = new PrintWriter("Order.dat");
            for(Order o : olist){
                pen.println(o);
            }
            pen.close();
        }catch(FileNotFoundException fe){}
    }
}