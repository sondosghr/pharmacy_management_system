package PharmacyMangementSystem;

import java.time.format.DateTimeFormatter;

public class Cashier extends Employee {

    public Cashier(){
        super();
        this.options= new Option[]{};

        new ChangePassword();

    }

    @Override
    String getjob() {
        return "Cashier";
    }


}
