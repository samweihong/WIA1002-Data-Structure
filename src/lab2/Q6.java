package lab2;

public class Q6 {
    public static void main(String[] args) {
        Integer[][] numbers = {{4,5,6},{1,2,3}};
        System.out.println(MinMaxTwoDArray.min(numbers));
        System.out.println(MinMaxTwoDArray.max(numbers));
    }
}

class MinMaxTwoDArray {
    public static <E extends Comparable<E>> E min(E[][] list) {
        E min = list[0][0];
        for (E[] row : list)
            for (E e : row)
                if (e.compareTo(min) < 0)
                    min = e;
        return min;
    }

    public static <E extends Comparable<E>> E max(E[][] list) {
        E max = list[0][0];
        for (E[] row : list)
            for (E e : row)
                if (e.compareTo(max) > 0)
                    max = e;
        return max;
    }
}
