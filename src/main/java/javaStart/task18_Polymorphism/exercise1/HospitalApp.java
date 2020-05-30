package javaStart.task18_Polymorphism.exercise1;

public class HospitalApp {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        hospital.addPerson(new Doctor(
                "Tobi",
                "Cunningham",
                7500,
                1300));
        hospital.addPerson(new Nurse(
                "Meg",
                "Mccartney",
                2200, 6));
        hospital.addPerson(new Nurse(
                "Ann",
                "Adam",
                2100,
                3));

        String info = hospital.getInfo();
        System.out.println(info);
    }
}
