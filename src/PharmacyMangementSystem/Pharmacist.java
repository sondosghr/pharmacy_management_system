package PharmacyMangementSystem;

public class Pharmacist extends Employee {

    public Pharmacist(){
        super();
        this.options= new Option[]{

                new CreateMedicine(),
               // new ReadAllEmployees(),
                new ReadMedicineID(),
                new ReadMedicineByName(),
                new ReadMedicineByType(),
                new UpdateMedicine(),
                new ReadMedicineByCompany(),
                new ChangePassword()
        };}

    @Override
    String getjob() {
        return "Pharmacist";
    }


    }


