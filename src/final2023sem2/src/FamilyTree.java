import java.util.LinkedList;
import java.util.List;

public class FamilyTree {
    private class Node {
        Patient patient;
        Node parent;

        public Node(Patient patient) {
            this.patient = patient;
        }
    }

    List<Node> nodes = new LinkedList<>();

    public void add(Patient patient) {
        nodes.add(new Node(patient));
    }

    public void addParentRelationship(Patient patient, Patient parent) {
        Node patientNode = findPatientNode(patient);
        Node parentNode = findPatientNode(parent);
        patientNode.parent = parentNode;
    }

    public Patient findClosestAncestorWithMedicalRecord(Patient patient) {
        Node current = findPatientNode(patient);
        if (current == null) return null;

        do {
            current = current.parent;
        } while (current != null && current.patient.getPastMedicalRecord() == null);
        return current == null ? null : current.patient;
    }

    private Node findPatientNode(Patient patient) {
        for (Node node : nodes) {
            if (node.patient.equals(patient)) {
                return node;
            }
        }
        return null;
    }
}
