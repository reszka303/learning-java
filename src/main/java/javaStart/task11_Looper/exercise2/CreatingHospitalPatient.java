package javaStart.task11_Looper.exercise2;

public class CreatingHospitalPatient {
    private final int maxPatientsNumber = 10;
    private Patient[] patients = new Patient[maxPatientsNumber];
    private int registeredPatients = 0;

    void addPatient(Patient patient){
        if (registeredPatients < maxPatientsNumber) {
            patients[registeredPatients] = patient;
            registeredPatients++;
        } else {
            System.out.println("Maximal number of patients" +
                    " have been registered. Welcome tomorrow");
        }
    }

    void removePatient(Patient patient) {
        for (int i = 0; i < patients.length; i++) {
            if (patients[registeredPatients] == patient) {
                for (int j = i; j < (patients.length - 1); j++) {
                        patients[j] = patients[j + 1];
                }
            }
        }
    }

    void displayingPatients() {
        for (int i = 0; i < registeredPatients ; i++) {
            System.out.println(patients[i].getInfo());
        }
    }
}
