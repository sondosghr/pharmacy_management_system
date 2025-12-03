package PharmacyMangementSystem;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class ReadMedicineByCompany implements Option{


    @Override
    public String getOption() {
        return "Search Medicine By Company " ;
    }

    @Override
    public void oper(Database database, Scanner s, Employee e) {

        System.out.println("enter company ");
        String company = s.next();
        String select = " select * from medicines where company like"+company+"; ";

    }
}
