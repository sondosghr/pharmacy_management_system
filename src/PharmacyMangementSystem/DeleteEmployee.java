package PharmacyMangementSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployee implements Option {



    @Override
    public String getOption(){
        return "Delete employee";

    }
    @Override
    public void oper(Database database , Scanner s , Employee e ) {

        System.out.println("enter Employee id (int): (1- to show all employees )");
        int ID = s.nextInt();
        while ( ID < 0 ){
            new ReadAllEmployees().oper(database,s,e);
            System.out.println("enter Employee id (int): (1- to show all employees ) ");
            ID = s.nextInt();
        }
        String delete="delete from employee where ID ="+ID+";";

        try {
            database.getStatement().execute(delete);
            System.out.println("employee delelte succssfully ");
        }catch (SQLException EX ){
            EX.printStackTrace();
        }
        }
    }
