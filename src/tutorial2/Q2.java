package tutorial2;

public class Q2 {
    public static void main(String[] args) {
        MyArray.main(args);
    }
}

class MyArray {
    public static void main(String[] args) {
        Integer[] numbers = {1,2,3,4,5};
        String[] names = {"Jane", "Tom", "Bob"};
        Character[] alphabets = {'a', 'b', 'c'};

        listAll(numbers);
        listAll(names);
        listAll(alphabets);
    }

    public static <E> void listAll(E[] list) {
        for (E e : list)
            System.out.print(e + " ");
        System.out.println();
    }
}
