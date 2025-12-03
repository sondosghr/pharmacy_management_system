package PharmacyMangementSystem;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLException;
import java.util.Scanner;

public class ChangePassword implements Option {


    @Override
    public String getOption() {
        return "Change Password";

    }

    @Override
    public void oper(Database database, Scanner s, Employee e) {

        System.out.println(" enter your old password : ");
        String oldPassword = s.next();
        if (!e.getpassword().equals(oldPassword)){
            System.out.println("Incorrect Password ! ");
            return;
        }
        else {
            String password , ConfirmPassword;
        do {
            System.out.println("enter new password :");
            password = s.next();
            System.out.println("Confirm Password:");
            ConfirmPassword = s.next();
        }while (!password.equals(ConfirmPassword));
        String update = "update employees set Password="+password+" WHERE ID="+e.getID()+";";
        try{
            database.getStatement().execute(update);
            System.out.println("Password Change successfully");

        }catch (SQLException E1){
            E1.printStackTrace();

        }
        }
    }
}