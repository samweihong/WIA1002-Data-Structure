import java.util.Comparator;

public class Q5 {
    public static void main(String[] args) {
        String[] names = {
                "DAVID", "ELIZABETH", "JAMES", "JENNIFER", "JOHN",
                "LINDA", "MARIA", "MICHAEL", "PATRICIA", "ROBERT",
                "АНТОНОВ", "ВОЛКОВ", "ГУРИН", "ИВАНОВ", "КОММОГОРОВ",
                "МАРИА", "МАРКОВ", "ПЕТРОВ", "ПУТИН", "СТЕПАНОВ"
        };

        Comparator<String> comparator = new SpecialComparator<>();
        sort(names, comparator);
        System.out.print("# Sorted name list:\n - ");
        printArray(names, "\n - ");

        System.out.println("\n");

        System.out.println("# Search");
        String[] namesToSearch = {
                "АНТОНОВ", "MARKOV", "МАРИА", "ВОЛКОВ"
        };
        for (String name : namesToSearch) {
            System.out.printf("    Index of %s: %d\n", name, search(names, name));
        }

        System.out.println();

        System.out.println("# Longest name");
        System.out.println(findMax(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        }));
    }

    public static <E> void sort(E[] arr, Comparator<E> comparator) {
        // stable bubble sort
        int n = arr.length;
        for (int pass = 1; pass < n; pass++) {
            for (int i = 0; i < n - pass; i++) {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    E temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    public static <E> void printArray(E[] arr, String delimiter) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(delimiter);
            }
        }
    }

    public static <E> int search(E[] arr, E el) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(el)) return i;
        }
        return -1;
    }

    public static <E> E findMax(E[] arr, Comparator<E> cmp) {
        if (arr.length == 0) return null;
        
        E max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (cmp.compare(arr[i], max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }
}
