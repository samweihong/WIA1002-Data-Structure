package labtest1;

import java.util.ArrayList;

public class Vet {
    private String name;
    private String qualification;

    public Vet(String name, String qualification) {
        this.name = name;
        this.qualification = qualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * Loops through the list and prints each object element
     * @param list the list to be looped
     */
    public void giveTreatment(ArrayList<Prescription<? extends Pet, String, Integer>> list) {
        for (Prescription<? extends Pet, String, Integer> prescription : list) {
            Pet pet = prescription.getPet();
            System.out.println("Prescription Note");
            // If the pet is a cat, print its name.
            if (pet instanceof Cat) {
                Cat cat = (Cat) pet;
                System.out.println("Name: " + cat.getName());
            }
            System.out.println("Breed: " + pet.getBreed());
            System.out.println("Weight (KG): " + pet.getWeight());
            System.out.println("Sickness: " + pet.getSickness());
            System.out.println("Medication: " + prescription.getMedication());
            System.out.println("Dosage (ml): " + prescription.getDosage());
            System.out.println();
        }
    }
}
