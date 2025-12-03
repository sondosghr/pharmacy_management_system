package PharmacyMangementSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadAllMedicines implements Option{


    @Override
    public String getOption() {
        return "View All Medicines";
    }

    @Override
    public void oper(Database database, Scanner s, Employee e) {

        String select = "select *from medicines;";
        ArrayList<Medicine> medicines = new ArrayList<>();
        try{
            ResultSet rs = database.getStatement().executeQuery(select);
            while (rs.next()){
                Medicine m = new Medicine();
                m.setID(rs.getInt("ID"));
                m.setName(rs.getString("Name"));
                m.settype(rs.getString("Type"));
                m.setqty(rs.getInt("Qty"));
                m.setmanufactureDate(rs.getString("ManufactureDate"));
                m.setexpiryDate(rs.getString("ExpiryDate"));
                m.setcompany(rs.getString("company"));
                m.setcost(rs.getDouble("cost"));
            }
        }catch (SQLException e1){
            e1.printStackTrace();
        }

        for(Medicine m : medicines){
            m.print();
        }
    }
}


