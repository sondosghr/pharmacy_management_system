package PharmacyMangementSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReadEmployee implements Option{
    @Override
    public void oper(Database database , Scanner s , Employee e ){
        System.out.println("enter Employee id (int): (1- to show all employees ) ");
         int ID = s.nextInt();
        while ( ID < 0 ){
            new ReadAllEmployees().oper(database,s,e);
            System.out.println("enter Employee id (int): (1- to show all employees ) ");
            ID = s.nextInt();
        }

        String select="\"select ID , `FirstName`, `LastName`, `Email`, `PhoneNumber`, `Password`,`Salary`, `DateOfBirth`, `WorkHours`, `StartTime`, `EndTime`, `Job` from employee where ID= "+ID+";";

        try {
            ResultSet rs = database.getStatement().executeQuery(select);

            if (rs.next()) {
                Employee emp;
                int job = rs.getInt("Job");
                switch (job) {
                    case 1:
                        emp = new Manager();
                        break;
                    case 2:
                        emp = new Pharmacist();
                        break;
                    case 3:
                        emp = new Cashier();
                        break;
                    default:
                        emp = new Employee() {

                            @Override
                            String getjob() {
                                return null;
                            }
                        };
                        break;
                }

                emp.setID(ID);
                emp.setFirstName(rs.getString("FirstName"));
                emp.setlasName(rs.getString("LastName"));
                emp.setemail(rs.getString("Email"));
                emp.setphoneNumber(rs.getString("PhoneNumber"));
                emp.setsalary(rs.getDouble("Salary"));
                emp.setdataOfBirth(rs.getString("DataOfBirth"));
                emp.setworkHours(rs.getInt("work hours"));
                emp.setstartTime(rs.getString("StartTime"));
                emp.setEndTime(rs.getString("EndTime"));
                emp.print();
            }

            else {
                System.out.println("employee doesn't exist");
            }


        }catch (SQLException ex) {
            ex.printStackTrace();
        }        }

    @Override
    public String getOption (){
        return "View Employee";
    }

}
