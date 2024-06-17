import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Patient> patientList;

    public static void main(String[] args) {
        try {
            String familyBookContent = readFile("family_book.csv");
            List<List<String>> familyBookTable = toTable(familyBookContent);

            patientList = new ArrayList<>();
            for (int i = 1; i < familyBookTable.size(); i++) {
                patientList.add(new Patient(familyBookTable.get(i).get(0), familyBookTable.get(i).get(1)));
            }

            addPastMedicalRecord();

            FamilyTree tree = new FamilyTree();
            for (Patient patient : patientList) {
                tree.add(patient);
            }
            addParentRelationship(tree);

            List<List<String>> finalTable = getFinalTable(tree);
            displayTable(finalTable);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Patient findPatient(String firstName, String lastName) {
        for (Patient patient : patientList) {
            if (patient.getFirstName().equals(firstName) && patient.getLastName().equals(lastName)) {
                return patient;
            }
        }
        return null;
    }

    private static void addPastMedicalRecord() throws FileNotFoundException {
        String pastMedicalRecordContent = readFile("past_medical_record.csv");
        List<List<String>> table = toTable(pastMedicalRecordContent);

        for (int i = 1; i < table.size(); i++) {
            String firstName = table.get(i).get(0);
            String lastName = table.get(i).get(1);

            // find patient with the names
            Patient currentPatient = findPatient(firstName, lastName);
            if (currentPatient == null) continue;

            PastMedicalRecord pastMedicalRecord = new PastMedicalRecord();
            pastMedicalRecord.setHeight(Integer.parseInt(table.get(i).get(2)));
            pastMedicalRecord.setWeight(Integer.parseInt(table.get(i).get(3)));
            pastMedicalRecord.setOccupation(table.get(i).get(4));
            pastMedicalRecord.setDiabetic(table.get(i).get(5));
            pastMedicalRecord.setHeartDisease(table.get(i).get(6));
            pastMedicalRecord.setSmoking(table.get(i).get(7));
            pastMedicalRecord.setDrinkAlcohol(table.get(i).get(8));
            currentPatient.setPastMedicalRecord(pastMedicalRecord);
        }
    }

    private static void addParentRelationship(FamilyTree tree) throws FileNotFoundException {
        String familyBookContent = readFile("family_book.csv");
        List<List<String>> familyBookTable = toTable(familyBookContent);

        for (int i = 1; i < familyBookTable.size(); i++) {
            List<String> row = familyBookTable.get(i);
            String firstName = row.get(0);
            String lastName = row.get(1);
            Patient patient = findPatient(firstName, lastName);

            String parentFirstName = row.get(2);
            String parentLastName = row.get(3);
            Patient parent = findPatient(parentFirstName, parentLastName);
            tree.addParentRelationship(patient, parent);
        }
    }

    private static List<List<String>> getFinalTable(FamilyTree tree) throws FileNotFoundException {
        String upcomingPatientsContent = readFile("upcoming_patients.csv");
        List<List<String>> upcomingPatientsTable = toTable(upcomingPatientsContent);

        List<List<String>> finalTable = new ArrayList<>();
        finalTable.add(Arrays.asList("FirstName", "LastName", "ParentFirstName", "ParentLastName", "ParentHeight", "ParentWeight", "ParentOccupation", "ParentDiabetic", "ParentHeartDisease", "ParentSmoking", "ParentDrinkAlcohol"));
        for (int i = 1; i < upcomingPatientsTable.size(); i++) {
            String firstName = upcomingPatientsTable.get(i).get(0);
            String lastName = upcomingPatientsTable.get(i).get(1);
            Patient patient = findPatient(firstName, lastName);

            Patient parent = tree.findClosestAncestorWithMedicalRecord(patient);
            List<String> row = new ArrayList<>();
            row.add(firstName);
            row.add(lastName);

            if (parent == null) {
                for (int cnt = 0; cnt < 9; cnt++) {
                    row.add("None");
                }
            } else {
                row.add(parent.getFirstName());
                row.add(parent.getLastName());
                row.add(Integer.toString(parent.getPastMedicalRecord().getHeight()));
                row.add(Integer.toString(parent.getPastMedicalRecord().getWeight()));
                row.add(parent.getPastMedicalRecord().getOccupation());
                row.add(parent.getPastMedicalRecord().getDiabetic());
                row.add(parent.getPastMedicalRecord().getHeartDisease());
                row.add(parent.getPastMedicalRecord().getSmoking());
                row.add(parent.getPastMedicalRecord().getDrinkAlcohol());
            }
            finalTable.add(row);
        }
        return finalTable;
    }

    public static String readFile(String path) throws FileNotFoundException {
        String content = "";
        try (Scanner sc = new Scanner(new FileInputStream(path))) {
            while (sc.hasNextLine()) {
                content += sc.nextLine() + "\n";
            }
        }
        return content;
    }

    public static List<List<String>> toTable(String csvContent) {
        List<List<String>> list = new ArrayList<>();
        for (String line : csvContent.split("\n")) {
            if (line.trim().isEmpty()) continue;
            String[] tokens = line.split(",", -1);
            list.add(Arrays.asList(tokens));
        }
        return list;
    }

    public static void displayTable(List<? extends List<?>> table) {
        int colCount = table.get(0).size();
        int[] colWidths = new int[colCount];
        for (int i = 0; i < colCount; i++) {
            for (List<?> rows : table) {
                colWidths[i] = Math.max(colWidths[i], rows.get(i).toString().length());
            }
        }
        for (List<?> row : table) {
            for (int i = 0; i < colCount; i++) {
                String format = "%" + colWidths[i] + "s\t";
                System.out.printf(format, row.get(i));
            }
            System.out.println();
        }
    }
}
