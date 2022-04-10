package labtest1;

import java.util.ArrayList;

public class Clinic {
    private String name;
    private Vet practitioner;

    public Vet getPractitioner() {
        return practitioner;
    }

    public static void main(String[] args) {
        // Instantiate a Clinic object with the information given
        Clinic clinic = new Clinic();
        clinic.name = "Happy Animal Clinic";
        clinic.practitioner = new Vet("Abu Bakar", "DVM(India)");

        // Instantiate two Cat objects with the information given
        Cat cat1 = new Cat();
        cat1.setName("Tabby");
        cat1.setBreed("British Shorthair");
        cat1.setWeight(6);
        cat1.setSickness("Worms");

        Cat cat2 = new Cat();
        cat2.setName("Dimmy");
        cat2.setBreed("Siamese");
        cat2.setWeight(5);
        cat2.setSickness("Diarrhea");

        // Instantiate an ArrayList of Prescription
        ArrayList<Prescription<? extends Pet, String, Integer>> list = new ArrayList<>();
        list.add(new Prescription<>(cat1, "Tylosin", 5));
        list.add(new Prescription<>(cat2, "Pyrantel", 3));

        // Display the clinic information
        System.out.println("Clinic: " + clinic.name);
        Vet practitioner = clinic.getPractitioner();
        System.out.println("Vet on Duty: " + practitioner.getName() + ", " + practitioner.getQualification());
        System.out.println();

        // Invoke the giveTreatment method to display the prescription information
        clinic.practitioner.giveTreatment(list);

        // Determine the heaviest pet
        System.out.print("Weight analysis: ");
        if (cat1.compareTo(cat2) > 0)
            System.out.println(cat1.getName() + " is heavier than " + cat2.getName());
        else if (cat1.compareTo(cat2) < 0)
            System.out.println(cat2.getName() + " is heavier than " + cat1.getName());
        else
            System.out.println(cat1.getName() + " and " + cat2.getName() + " have the same weight.");
    }
}
