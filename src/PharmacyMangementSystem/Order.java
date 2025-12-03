package PharmacyMangementSystem;

import javax.swing.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {

    private int ID ;
    private Employee cashier ;
    private Employee pharmacist ;
    private LocalDateTime dateTime ;
    private double total;
    private ArrayList<Medicine> medicines ;
    private double paid ;
    private double change ;
    private LocalDateTime payDateTime ;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-dd-hh hh:mm");

    public Order(){}

    public int getID(){return ID ;}
    public void setI(int ID){this.ID= ID ;}


    public Employee getCashier(){return cashier ;}
    public void seTCashier(Employee cashier){this.cashier= cashier ;}

    public Employee getpharmacist(){return pharmacist ;}
    public void seTpharmacist(Employee pharmacist){this.pharmacist= pharmacist ;}

    public String getdateTime(){ return  dateTimeFormatter.format(dateTime) ;}
    public void setdateTime(String dateTime ){this.dateTime = LocalDateTime.parse(dateTime,dateTimeFormatter) ;}

    public double getTotal() { return total; }
    public void setTotal(double total){this.total= total;}

    public ArrayList<Medicine> getMedicines() { return medicines;}
    public void setMedicines(ArrayList<Medicine> medicines){this.medicines=medicines;}

    public double getpaid() { return paid; }
    public void setPaid(double paid){this.paid= paid;}

    public double getchange() { return change; }
    public void setchange(double change){this.change= change;}

    public String getpayDateTime(){ return  dateTimeFormatter.format(payDateTime) ;}
    public void setpayDateTime(String payDateTime ){this.payDateTime = LocalDateTime.parse(payDateTime,dateTimeFormatter ) ;}

    public String getdateTimeFormatter(){return "yyyy-dd-hh hh:mm";}
}





