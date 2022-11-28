import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String name;
    private float unit_price;
    private float quantity;
    private String category;
    private String type;
    private int ID;
    private static ArrayList<Product> plist;

    // Class constructor
    public Product(String name, float price, float qty, String category, String type){
        this.name = name;
        unit_price = price;
        quantity = qty;
        this.category = category;
        this.type = type;
        if(plist.size() == 0){
            fetch_data();
        }
        ID = plist.size() + 1;
        plist.add(this);
    }

    private Product(int ID, String name, float price, float qty, String category, String type){
        this.ID = ID;
        this.name = name;
        unit_price = price;
        quantity = qty;
        this.category = category;
        this.type = type;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public float getPrice(){
        return unit_price;
    }

    public float getQty(){
        return quantity;
    }

    public String getCategory(){
        return category;
    }

    public String getType(){
        return type;
    }

    public boolean isAvailable(){
        return quantity != 0;
    }

    public static Product findProduct(int ID){
        for(Product p : plist){
            if(ID == p.getID()){
                return p;
            }
        }
        return null;
    }

    public void updateProduct(Product p){
        for(Product p1: plist){
            if(p.getID() == p1.getID()){
                p1 = p;
            }
        }
    }

    public String toString(){
        return String.valueOf(ID) + " " + name + " " + String.valueOf(unit_price) + " " + String.valueOf(quantity) + " " + category + " " + type;
    }

    private void fetch_data(){
        try{
            Scanner scan = new Scanner(new File("Product.dat"));
            while(scan.hasNext()){
                String[] p = scan.nextLine().split(" ");
                Product p1 = new Product(Integer.valueOf(p[0]), p[1], Float.valueOf(p[2]), Float.valueOf(p[3]),p[4],p[5]);
                plist.add(p1);
            }
        }catch(FileNotFoundException fe){}
    }

    public void saveData(){
        try{
            PrintWriter pen = new PrintWriter("Product.dat");
            for(Product p : plist){
                pen.println(p);
            }
            pen.close();
        }catch(FileNotFoundException fe){}
    }
}