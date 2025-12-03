package PharmacyMangementSystem;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class Employee {


    private int ID ;
    private String firstName ;
    private String lasName ;
    private String email ;
    private String phoneNumber ;
    private String password ;
    private double salary;
    private LocalDate dataOfBirth ;
    private int workHours ;
    private LocalTime startTime ;
    private LocalTime endTime ;
    protected Option[] options;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-dd-mm");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm");
    public Employee(){}

    public int getID(){ return ID ; }
    public void setID(int ID){ this.ID = ID ;}

    public String getFirstName(){ return  firstName ;}
    public void setFirstName(String firstName ){this.firstName =firstName ;}

    public String getlasName(){ return  lasName ;}
    public void setlasName(String lasName ){this.lasName =lasName ;}

    public String getemail(){ return email ;}
    public void setemail(String email ){this.email=email ;}

    public String getphoneNumber(){ return  phoneNumber ;}
    public void setphoneNumber(String phoneNumber ){this.phoneNumber =phoneNumber ;}

    public String getpassword(){ return  password ;}
    public void setpassword(String password ){this.password =password ;}

    public double getsalary(){ return  salary ;}
    public void setsalary(double salary ){this.salary =salary ;}

    public String getdataOfBirth(){return dateFormatter.format(dataOfBirth); }
    public void setdataOfBirth(String dataOfBirth){this.dataOfBirth = LocalDate.parse(dataOfBirth , dateFormatter);}

    public int getworkHours(){ return workHours ; }
    public void setworkHours(int workHours){ this.workHours = workHours ;}

    public String getestartTime(){ return timeFormatter.format(startTime);}
    public void setstartTime(String startTime ){this.startTime = LocalTime.parse(startTime , timeFormatter) ;}

    public String getEndTime(){ return timeFormatter.format(endTime);}
    public void setEndTime(String endTime ){this.endTime = LocalTime.parse(endTime , timeFormatter) ;}

    public String getdateTimeFormat(){return "yyyy-dd-hh";}

    public String getTimeFormat(){ return "hh:mm";}

    abstract String getjob();

    public void showOptions(Database database, Scanner s ){

        System.out.println("----------------------------------------");

        for (int i = 0 ; i < options.length ; i ++ ){
            System.out.println((i+1)+". " + options[i].getOption());
        }

        System.out.println("----------------------------------------");

        int i= s.nextInt();

        options[i+1].oper(database, s , this);

        showOptions(database, s );
    }
    public void print(){
        System.out.println("ID:\t \t " + getID());
        System.out.println("First Name : \t\t" + getFirstName()+" "+getlasName());
        System.out.println("Email : \t\t"+ getemail());
        System.out.println("Phone Number : \t\t"+getphoneNumber());
        System.out.println("Salary : \t\t"+ getsalary()+"$");
        System.out.println("Data of birth : \t\t"+ getdataOfBirth());
        System.out.println("setworkHours : \t\t"+ getworkHours());
        System.out.println("Start Time : \t\t"+ getestartTime());
        System.out.println("End Time : \t"+ getEndTime());
        System.out.println("job : \t\t"+ getjob());
        System.out.println("---------------------------------------");

    }


}
