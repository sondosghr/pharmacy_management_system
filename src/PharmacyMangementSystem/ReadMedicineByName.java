package PharmacyMangementSystem;

import java.util.Scanner;

public  class ReadMedicineByName implements Option{
    @Override
    public String getOption() {
        return "Search Medicine By Name ";
    }

    @Override
    public void oper(Database database, Scanner s, Employee e) {

    }
}
