public class Patient {
    private String firstName;
    private String lastName;
    private PastMedicalRecord pastMedicalRecord;

    public Patient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return firstName.equals(patient.firstName) && lastName.equals(patient.lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public PastMedicalRecord getPastMedicalRecord() {
        return pastMedicalRecord;
    }

    public void setPastMedicalRecord(PastMedicalRecord pastMedicalRecord) {
        this.pastMedicalRecord = pastMedicalRecord;
    }
}
