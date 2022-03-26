package lab2;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(CompareMax.maximum(3, 4, 1));
        System.out.println(CompareMax.maximum(false, false, true));
        System.out.println(CompareMax.maximum("JoJo", "Bizarre", "Adventure"));
    }
}

class CompareMax {
    public static <E extends Comparable<E>> E maximum(E e1, E e2, E e3) {
        if (e1.compareTo(e2) > 0 && e1.compareTo(e3) > 0)
            return e1;
        if (e2.compareTo(e1) > 0 && e2.compareTo(e3) > 0)
            return e2;
        return e3;
    }
}
