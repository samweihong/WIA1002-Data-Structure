package labtest1;

public class Prescription<E extends Pet, T1, T2> {
    private E pet;
    private T1 medication;
    private T2 dosage;

    public Prescription(E pet, T1 medication, T2 dosage) {
        this.pet = pet;
        this.medication = medication;
        this.dosage = dosage;
    }

    public E getPet() {
        return pet;
    }

    public void setPet(E pet) {
        this.pet = pet;
    }

    public T1 getMedication() {
        return medication;
    }

    public void setMedication(T1 medication) {
        this.medication = medication;
    }

    public T2 getDosage() {
        return dosage;
    }

    public void setDosage(T2 dosage) {
        this.dosage = dosage;
    }
}
