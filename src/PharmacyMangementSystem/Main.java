package PharmacyMangementSystem;

import java.sql.*;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import  GUI.JFrame;
import GUI.JPanel;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.w3c.dom.events.MouseEvent;

public class Main {

    public static void main(String[] args) {
/*import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import  GUI.JFrame;
import GUI.JPanel;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.w3c.dom.events.MouseEvent;


public class PharmacyManagementSystem {


    public static void main(String[] args) {
       JFrame frame = new JFrame(625,350, null);


        JPanel panel = new JPanel(new BorderLayout(20,20));

       panel.add(new GUI.JLabel(" Welcome to pharmacy Management System",25),
               BorderLayout.NORTH);

       JPanel center = new JPanel(new GridLayout(3,2,20,20));

       center.add(new JLabel("Email:",22));
       JTextField email = new JPasswordField(20);
       center.add(email);


       center.add(new JLabel("password:",22));
       JPasswordField password = new JPasswordField(20);
       center.add(password);

       JButton login = new JButton("Login", 20 );
       panel.add(new   JPanel(BorderLayout()).add(login), BorderLayout.SOUTH);
       panel.add(center , BorderLayout.CENTER);


        frame.getContentPane().add(panel,BorderLayout.NORTH);
        frame.setVisible(true);
        // TODO code application logic here

        login.addMouseListener(new MouseEvent);


    }
    public void mouseReleased(MouseEvent e ){

    }

 public void mousePressed(MouseEvent e ){

 }
 public void mouseExited(MouseEvent e ){

    }
      public void mouseEntered(MouseEvent e ){

    }

     public void mouseClicked(MouseEvent e ){ //13:25 --------7 نسخ حااجة من المين متع دعاء ولصقها هني
        //14:19 عدلت حاجة في جملة السليكت متع المين
    }


    private static LayoutManager BorderLayout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}*/

        Scanner s = new Scanner(System.in);
        Database database= new Database();
        System.out.println(" **** welcome to pharmacy mangement system **** ");
        System.out.println("enter your email : ");
        String email = s.next();
        System.out.println("enter your password : ");
        String password = s.next();
       // String select = "select * from 'employees' where 'Email' = '"+email+" ' and 'Password'= '"+password+" ' ; " ;

        try {
            ResultSet rs = database.getStatement().executeQuery("select * from employees where Email = '"+email+"'  and Password= '"+password+"'  ; ");

            if (rs.next()){
                Employee e ;
                int job = rs.getInt("Job");
                switch (job){
                    case 1 :
                        e= new Manager();
                        break;
                    case 2 :
                        e= new Pharmacist();
                        break;
                    case 3 :
                        e= new Cashier();
                        break;
                    default:
                        e = new Employee
                                () {
                            String getjob() {
                                return null;
                            }
                        };
                        break;
                }

                e.setID(rs.getInt("ID"));
                e.setFirstName(rs.getString("FirstName"));
                e.setlasName(rs.getString("LastName"));
                e.setemail(rs.getString("Email"));
                e.setphoneNumber(rs.getString("PhoneNumber"));
                e.setpassword(rs.getString("Password"));
                e.setsalary(rs.getDouble("Salary"));
                e.setdataOfBirth(rs.getString("DateOfBirth"));
                e.setworkHours(rs.getInt("WorkHours"));
                e.setstartTime(rs.getString("StartTime"));
                e.setEndTime(rs.getString("EndTime"));
                e.showOptions(database, s );
            }
            else {
                System.out.println( "Incorrect email or password ");
            }
        }catch (SQLException e){
           // e.printStackTrace();

            System.out.println(e);

        }
    }


}