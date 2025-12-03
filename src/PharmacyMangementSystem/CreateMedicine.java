
package PharmacyMangementSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class CreateMedicine implements Option {
    @Override
    public String getOption(){
        return "Add new Medicine";

    }

    @Override
    public void oper (Database database , Scanner s , Employee e ){
        System.out.println("enter Name :");
        String name = s.next();
        System.out.println("Enter Type :");
        String type = s.next();
        System.out.println("Enter qty (int) :");
        String qty = s.next();
        System.out.println("Enter Manufacture Date ( YYYY-DD-MM ) :");
        String manufactureDate = s.next();
        System.out.println("Enter expiry date ( YYYY-DD-MM ) :");
        String expiryDate = s.next();
        System.out.println("Enter company:");
        String company= s.next();
        System.out.println("Enter cost (double) :");
        double cost = s.nextDouble();


        String insert ="INSERT INTO `employees`(`Name`, `Type`, `Qty`,"
                +" `ManufactureDate`, `ExpiryDate`, `Company`, `Cost`) VALUES ('"+
                name +",'"+type+","+qty+","+manufactureDate+","+expiryDate+","+company+","+cost+");";


        try {
            database.getStatement().execute(insert);
            System.out.println("Medicine added successfully");
        }catch (SQLException el){
            el.printStackTrace();

        }


    }
}
