package lab4;

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Character> list = new MyLinkedList<>();
        // a.
        for (char c = 'a'; c <= 'e'; c++)
            list.addLast(c);

        // b.
        list.print();

        // c.
        list.reverse();

        // d.
        int size = list.lastIndexOf(list.getLast())+1;
        System.out.println(size);

        // e.
        System.out.println("First value: " + list.getFirst());
        System.out.println("Last value: " + list.getLast());

        // f.
//        list.remove(size/2);
//        list.print();

        // g.
        System.out.println("Second value: " + list.get(1));
        System.out.println("Third value: " + list.get(2));

        // h.
        System.out.println(list.contains('c'));

        // i.
        list.set(0, 'h');
        list.set(1, 'e');
        list.set(2, 'l');
        list.set(3, 'l');
        list.set(4, 'o');
        list.print();
    }
}
