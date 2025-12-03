package PharmacyMangementSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Medicine {

    private int ID;
    private String name ;
    private String type ;
    private int qty ;
    private LocalDate manufactureDate ;
    private LocalDate expiryDate ;
    private String company ;
    private double cost ;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public Medicine(){}

    public int getID(){return ID ;}
    public void setID(int ID){this.ID= ID ;}

    public String getName(){ return  name ;}
    public void setName(String name ){this.name =name ;}

    public String gettype(){ return  type ;}
    public void settype(String type ){this.type =type ;}

    public int getqty(){ return qty ; }
    public void setqty(int qty){ this.qty = qty ;}

    public String getmanufactureDate(){ return  dateFormatter.format(manufactureDate) ;}
    public void setmanufactureDate(String manufactureDate ){this.manufactureDate =LocalDate.parse(manufactureDate , dateFormatter) ;}

    public String getexpiryDate(){ return  dateFormatter.format(expiryDate) ;}
    public void setexpiryDate(String expiryDate ){this.expiryDate =LocalDate.parse(expiryDate , dateFormatter) ;}

    public String getcompany(){ return  company ;}
    public void setcompany(String company ){this.company =company ;}

    public double getcost(){ return  cost ;}
    public void setcost(double cost ){this.cost =cost ;}


    public String getDateFormatter(){
        return "yyyy-MM-dd";
    }


    public void print() {
        System.out.println("ID:\t \t \t " + getID());
        System.out.println("Name : \t\t \t" + getName());
        System.out.println("type : \t\t"+ gettype());
        System.out.println("qty : \t\t\t"+getqty());
        System.out.println(" ManufactureDate: \t\t\t"+ getmanufactureDate());
        System.out.println("ExpiryDate : \t\t\t"+ getexpiryDate());
        System.out.println("company : \t\t\t"+ getcompany());
        System.out.println("cost : \t\t\t"+ getcost());
        System.out.println("---------------------------------------");

    }
}
