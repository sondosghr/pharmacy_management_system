package PharmacyMangementSystem;

import javax.swing.plaf.PanelUI;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateEmployee implements Option {
    @Override
    public void oper(Database database , Scanner s , Employee e ){

        System.out.println("enter first name : ");
        String firstName = s.next();
        System.out.println("enter lest name :");
        String lestName = s.next();
        System.out.println("enter email :");
        String email = s.next();
        System.out.println("enter phone number  :");
        String phoneNumber  = s.next();
        System.out.println("enter Password  :");
        String Password  = s.next();
        System.out.println("enter salary(double)  :");
        double salary  = s.nextDouble();
        System.out.println("enter date of birth  ( yyyy-dd-mm )");
        String dateOfBirth  = s.next();
        System.out.println("enter work hours (int) :");
        int workHours = s.nextInt();
        System.out.println("enter start time (hh-mm) : ");
        String startTime = s.next();
        System.out.println("enter end time (hh-mm) : ");
        String endTime = s.next();
        System.out.println("enter job : \n1. Manager \n2. pharmacist\n3. cashier");
        int job = s.nextInt();
        String insert =" INSERT INTO `employees`(`FirstName`, `LastName`, `Email`, `PhoneNumber`, `Password`," +
                " `Salary`, `DateOfBirth`, `WorkHours`, `StartTime`, `EndTime`, `Job`)" +
                " VALUES ("+firstName+","+ lestName+","+email+","+phoneNumber+","+Password+","+salary+","+dateOfBirth+"," +
                ","+workHours+","+startTime+","+endTime+","+job+")";
        try {
              database.getStatement().execute(insert);
            System.out.println("employee added succesfully");
        }catch (SQLException e1){
               e1.printStackTrace();
        }
    }
    @Override
    public String getOption(){
        return "ADD NEW Employee";
    }
}
