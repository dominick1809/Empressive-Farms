import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private String password;
    private int ID;
    private static ArrayList<Employee> elist;      

    // Class constructors
    public Employee(String name, String password){
        this.name = name;
        this.password = password;
        if(elist.size() == 0){
            fetch_data();
        }
        ID = elist.size() + 1;
        elist.add(this);
    }

    // Constructor to be used by fetch_data
    private Employee(int ID, String name, String password){
        this.ID = ID;
        this.name = name;
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public boolean checkPassword(String pswrd){
        return pswrd == password;
    }

    public static Employee findEmployee(String name){
        for(Employee e: elist){
            if(e.getName() == name){
                return e;
            }
        }
        return null;
    }

    // parameter constraints to limit data to be displayed, maybe move to orders
    public void createReport(){}

    public String toString(){
        return String.valueOf(ID) + " " + name + " " + password;
    }

    private void fetch_data(){
        try{
            Scanner scan = new Scanner(new File("Employee.dat"));
            while(scan.hasNext()){
                String[] e = scan.nextLine().split(" ");
                Employee e1 = new Employee(Integer.valueOf(e[0]),e[1],e[2]);
                elist.add(e1);
            }
        }catch(FileNotFoundException fe){}
    }

    public static void saveData(){
        try{
            PrintWriter pen = new PrintWriter("Employee.dat");
            for(Employee e : elist){
                pen.println(e);
            }
            pen.close();
        }catch(FileNotFoundException fe){}  
    }
}