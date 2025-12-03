package PharmacyMangementSystem;

public class Manager extends Employee{

    public Manager() {
        super();
        this.options = new Option[]{
                new CreateEmployee(),
                new ReadAllEmployees(),
                new ReadEmployee(),
                new UpdateEmployee(),
                new DeleteEmployee(),
                new ChangePassword(),
                new CreateMedicine(),
                new ReadMedicineID(),
                new ReadMedicineByName(),
                new ReadMedicineByType(),
                new ReadMedicineByCompany(),
                new ReadAllMedicines(),
                new UpdateMedicine()




        };
    }

    @Override
    String getjob() {
        return "Manager";
    }


    }

