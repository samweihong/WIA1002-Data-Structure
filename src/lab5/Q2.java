package lab5;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();

        System.out.println("Enter your student name list. Enter 'n' to end.....");
        String input;
        while (!(input = sc.nextLine()).equals("n"))
            list.add(input);
        System.out.println();

        System.out.println("You have entered the following students' name :");
        list.printList();
        System.out.println();

        System.out.println("The number of students entered is : " + list.getSize());
        System.out.println();

        System.out.println("All the names entered are correct? Enter 'r' to rename the student name, 'n' to proceed.");
        input = sc.nextLine();
        System.out.println();

        if (input.equals("r")) {
            System.out.println("Enter the existing student name that u want to rename : ");
            String oldName = sc.nextLine();
            System.out.println();
            System.out.println("Enter the new name : ");
            String newName = sc.nextLine();
            System.out.println();
            list.replace(oldName, newName);
            System.out.println("The new student list is : ");
            list.printList();
            System.out.println();
        }

        System.out.println("Do you want to remove any of your student name? Enter 'y' for yes, 'n' to proceed.");
        input = sc.nextLine();
        System.out.println();

        if (input.equals("y")) {
            System.out.println("Enter a student name to remove :");
            String name = sc.nextLine();
            list.removeElement(name);
            System.out.println();

            System.out.println("The number of updated student is : " + list.getSize());
            System.out.println("The updated students list is :");
            list.printList();
            System.out.println();
        }

        System.out.println("All student data captured complete. Thank you!");
    }
}

class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node() {}

        public Node(E item) {
            this.item = item;
        }
    }

    public void add(E e) {
        Node<E> node = new Node<>(e);
        if (tail != null) tail.next = node;
        tail = node;
        if (head == null) head = tail;
        size++;
    }

    public void removeElement(E e) {
        Node<E> dummy = new Node<>();
        dummy.next = head;

        Node<E> current = dummy;
        while (current.next != null) {
            if (e.equals(current.next.item)) {
                current.next = current.next.next;
                size--;
            }
            else
                current = current.next;
        }
        head = dummy.next;
        tail = (current == dummy ? null : current);
    }

    public void printList() {
        if (size == 0) {
            System.out.println();
            return;
        }
        System.out.print(head.item);
        for (Node<E> node = head.next; node != null; node = node.next)
            System.out.print(", " + node.item);
        System.out.println(".");
    }

    public int getSize() {
        return size;
    }

    public boolean contains(E e) {
        for (Node<E> node = head; node != null; node = node.next)
            if (e.equals(node.item))
                return true;
        return false;
    }

    public void replace(E e, E newE) {
        for (Node<E> node = head; node != null; node = node.next)
            if (e.equals(node.item))
                node.item = newE;
    }
}
