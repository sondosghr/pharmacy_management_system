package PharmacyMangementSystem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadAllEmployees implements Option{

    @Override
    public void oper (Database database, Scanner s , Employee e ) {

        String select = "select ID, `FirstName`, `LastName`, `Email`, `PhoneNumber`, `Password`,`Salary`, `DateOfBirth`, `WorkHours`, `StartTime`, `EndTime`, `Job` from employee ;";

        ArrayList<Employee> employees = new ArrayList<>();
        try{
            ResultSet rs = database.getStatement().executeQuery(select);
            while (rs.next()){
                Employee emp ;
                int job = rs.getInt("Job");
                switch (job){
                    case 1 :
                        emp= new Manager();
                        break;
                    case 2 :
                        emp= new Pharmacist();
                        break;
                    case 3 :
                        emp= new Cashier();
                        break;
                    default:
                        emp=new Employee(){

                            @Override
                            String getjob(){
                                return null;
                            }
                        };
                        break;
                }

                emp.setID(rs.getInt("ID"));
                emp.setFirstName(rs.getString("FirstName"));
                emp.setlasName(rs.getString("LastName"));
                emp.setemail(rs.getString("Email"));
                emp.setphoneNumber(rs.getString("PhoneNumber"));
                emp.setsalary(rs.getDouble("Salary"));
                emp.setdataOfBirth(rs.getString("DataOfBirth"));
                emp.setworkHours(rs.getInt("work hours"));
                emp.setstartTime(rs.getString("StartTime"));
                emp.setEndTime(rs.getString("EndTime"));
                employees.add(emp);
            }

        }catch (SQLException e1){
            e1.printStackTrace();
        }

       for ( Employee emp : employees){

//في حاجة ناقصة

       }
    }
    @Override
    public String   getOption (){
        return "view all employees ";


        }


    }
