package PharmacyMangementSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReadMedicineID implements Option{


    @Override
    public String getOption() {
        return "Search Medicine By ID ";
    }

    @Override
    public void oper(Database database, Scanner s, Employee e) {
        System.out.println("enter medicine ID (int) : ( -1 to all medicine )");
        int ID = s.nextInt();
        while ( ID < 0 ){
            new ReadAllMedicines().oper(database,s,e);
            System.out.println("enter medicine id (int): (1- to show all medicine ) ");
            ID = s.nextInt();
        }
        String select="select from 'medicine' where 'ID' ="+ID+";";
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
            }else{
                System.out.println("invaild id ");
            }

        }catch ( SQLException e1){
            e1.printStackTrace();

        }
    }
}
