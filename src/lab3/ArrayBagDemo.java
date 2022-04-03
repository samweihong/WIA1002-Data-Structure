package lab3;

public class ArrayBagDemo {
    public static void main(String[] args) {
        System.out.println("bag1:");
        ArrayBag<String> bag1 = new ArrayBag<>();
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        testAdd(bag1, contentsOfBag1);
        displayBag(bag1);
        System.out.println();

        System.out.println("bag2:");
        ArrayBag<String> bag2 = new ArrayBag<>();
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};
        testAdd(bag2, contentsOfBag2);
        displayBag(bag2);
        System.out.println();

        System.out.println("bag3, test the method union of bag1 and bag2:");
        ArrayBag<String> bag3 = (ArrayBag<String>) bag1.union(bag2);
        displayBag(bag3);
        System.out.println();

        System.out.println("bag4, test the method intersection of bag1 and bag2:");
        ArrayBag<String> bag4 = (ArrayBag<String>) bag1.intersection(bag2);
        displayBag(bag4);
        System.out.println();

        System.out.println("bag5, test the method difference of bag1 and bag2:");
        ArrayBag<String> bag5 = (ArrayBag<String>) bag1.difference(bag2);
        displayBag(bag5);

//        ArrayBag<Double> bagg = new ArrayBag<>();
//        bagg.add(new Byte((byte) 40));
//        bagg.add(new Integer(50));
//        ArrayBag<Integer> bagg2 = new ArrayBag<>();
//        bagg.add(new Double(40.5));
//        bagg.add(new Integer(50));
//        displayBag(bagg.union(bagg2));
//        displayBag(bagg.intersection(bagg2));

    }

    private static void testAdd(BagInterface<String> aBag, String[] content) {
        System.out.print("Adding ");
        for (String s : content) {
            aBag.add(s);
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static void displayBag(BagInterface<String> aBag) {
        Object[] arr = aBag.toArray();
        System.out.printf("The bag contains %d string(s), as follows:\n", aBag.getCurrentSize());
        for (Object o : arr)
            System.out.print(o + " ");
        System.out.println();
    }
}
