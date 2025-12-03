package PharmacyMangementSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployee implements Option{


    @Override
    public String getOption(){
        return "edit employee";

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
        String select="select `FirstName`, `LastName`, `Email`, `PhoneNumber`, `Password`,`Salary`, `DateOfBirth`, `WorkHours`, `StartTime`, `EndTime`, `Job` from employee where ID= "+ID+";";


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

                System.out.println("enter first name :  (1-to keep"+emp.getFirstName() +"):");
                String firstName = s.next();
                if(!firstName.equals("-1"))emp.setFirstName(firstName);

                System.out.println("enter last name :(1-to keep"+emp.getlasName() +"):");
                String lastName = s.next();
                if(!lastName.equals("-1"))emp.setlasName(lastName);

                System.out.println("Enter Email: (-1 to keep "+emp.getemail()+")");
                String email = s.next();
                if (!email.equals("-1")) emp.setemail(email);

                System.out.println("Enter Phone Number: (-1 to keep "+emp.getphoneNumber()+")");
                String phoneNumber = s.next();
                if (!phoneNumber.equals("-1")) emp.setphoneNumber(phoneNumber);

                System.out.println("Enter Salary: (-1 to keep "+emp.getsalary()+")");
                double salary = s.nextDouble();
                if (salary !=- 1) emp.setsalary(salary);

                System.out.println("Enter Date of Birth ("+emp.getdateTimeFormat()+"): (-1 to keep "+emp.getdataOfBirth()+")");
                String dateOfBirth = s.next();
                if (!dateOfBirth.equals("-1")) emp.setdataOfBirth(dateOfBirth);

                System.out.println("Enter Work Hours (int): (-1 to keep "+emp.getworkHours()+")");
                int workHours = s.nextInt();
                if (workHours !=- 1) emp.setworkHours(workHours);

                System.out.println("Enter Start Time ("+emp.getTimeFormat()+ "): (-1 to keep "+emp.getestartTime()+")");
                String startTime = s.next();
                if (!startTime.equals("-1")) emp.setstartTime(startTime);

                System.out.println("Enter Start Time ("+emp.getTimeFormat()+ "): (-1 to keep "+emp.getestartTime()+")");
                String EndTime = s.next();
                if (!EndTime.equals("-1")) emp.setEndTime(EndTime);



                System.out.println("Enter Job:\n1. Manager\n2. Pharmacist\n3. Cashier");
                System.out.println("(-1 to keep "+emp.getjob()+")");
                int jobN = s.nextInt();
                if (jobN ==- 1) jobN = job;


                String update = "UPDATE employees SET FirstName ="+

                emp.getFirstName()+",LastName="+emp.getlasName()+",Email ="
                        +emp.getemail()+",PhoneNumber="+emp.getphoneNumber()+
                ",Salary="+emp.getsalary()+", DateOfBirth="+
                        emp.getdataOfBirth()+",WorkHours="+emp.getworkHours()+
                ",StartTime="+emp.getestartTime()+",EndTime="+
                emp.getEndTime()+",Job="+jobN+" WHERE ID = "+ID+";";
                database.getStatement().execute(update);
                System.out.println("Employee updated successfully");

                                }

            else {
                System.out.println("employee doesn't exist");
            }


        }catch (SQLException ex) {
            ex.printStackTrace();
        }



    }


    }
