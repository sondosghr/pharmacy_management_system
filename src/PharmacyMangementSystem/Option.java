package PharmacyMangementSystem;

import java.util.Scanner;

public interface Option {

    abstract String getOption();
    abstract void oper(Database database, Scanner s , Employee e);

}
