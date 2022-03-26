package lab2;

public class Q4 {
    public static <E extends Comparable<E>> String minmax(E[] array) {
        E min = array[0];
        E max = array[0];
        for (E e : array) {
            if (e.compareTo(min) < 0)
                min = e;
            if (e.compareTo(max) > 0)
                max = e;
        }
        return String.format("Min = %s Max = %s", min, max);
    }

    public static void main(String[] args) {
        Integer[] intArray = {5,3,7,1,4,9,8,2};
        String[] strArray = {"red","blue","orange","tan"};
        System.out.println(minmax(intArray));
        System.out.println(minmax(strArray));
    }
}
