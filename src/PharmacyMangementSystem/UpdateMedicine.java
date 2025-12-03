package PharmacyMangementSystem;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMedicine implements Option {
    @Override
    public String getOption() {
        return "Update Medicine";
    }

    @Override
    public void oper(Database database, Scanner s, Employee e) {
        System.out.println(" enter Medicine id (int): (1- to show all employees )");
        int ID = s.nextInt();
        while (ID < 0) {
            new ReadAllMedicines().oper(database, s, e);
            System.out.println("enter Medicine id (int): (1- to show all employees ) ");
            ID = s.nextInt();
            String select = "select from medicine where ID =" + ID + ";";
            try {
                ResultSet rs = database.getStatement().executeQuery(select);
                if (rs.next()) {

                    Medicine m = new Medicine();
                    m.setID(rs.getInt("ID"));
                    m.setName(rs.getString("Name"));
                    m.settype(rs.getString("Type"));
                    m.setqty(rs.getInt("Qty"));
                    m.setmanufactureDate(rs.getString("ManufactureDate"));
                    m.setexpiryDate(rs.getString("ExpiryDate"));
                    m.setcompany(rs.getString("company"));
                    m.setcost(rs.getDouble("cost"));
                    m.print();

                    System.out.println("Enter Name (-1 to keep " + m.getName() + "):");
                    String name = s.next();
                    if (!name.equals("-1")) m.setName(name);

                    System.out.println("Enter Type (-1 to keep " + m.gettype() + "):");
                    String type = s.next();
                    if (!type.equals("-1")) m.settype(type);

                    System.out.println("Enter Qty (-1 to keep " + m.getqty() + "):");
                    int qty = s.nextInt();
                    if (qty != -1) m.setqty(qty);

                    System.out.println("Enter Manufacture Date (-1 to keep " + m.getmanufactureDate() + "):");
                    String mafufactureDate = s.next();
                    if (!mafufactureDate.equals("-1")) m.setmanufactureDate(mafufactureDate);

                    System.out.println("Enter Expiry Date (-1 to keep " + m.getexpiryDate() + "):");
                    String expiryDate = s.next();
                    if (!expiryDate.equals("-1")) m.setexpiryDate(expiryDate);

                    System.out.println("Enter Company (-1 to keep " + m.getcompany() + "):");
                    String company = s.next();
                    if (!company.equals("-1")) m.setcompany(company);

                    System.out.println("Enter Cost (-1 to keep " + m.getcost() + "):");
                    double cost = s.nextDouble();
                    if (cost != -1) m.setcost(cost);


                    String update = "UPDATE medicines SET name=" + m.getName() +
                            ",Type=" + m.gettype() + ",Qty=" + m.getqty() +
                            ",ManufactureDate=" + m.getmanufactureDate() + ", ExpiryDate="
                            + m.getexpiryDate() + ",Company=" + m.getcompany() + ", Cost=" +
                            m.getcost() + " WHERE ID =" + m.getID() + " ;";

                    try {
                        database.getStatement().execute(update);
                        System.out.println("Medicine updated successfully");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }


                } else {
                    System.out.println("invaild id ");
                }


            } catch (SQLException e1) {
                e1.printStackTrace();
                    }
            }
        }
    }
