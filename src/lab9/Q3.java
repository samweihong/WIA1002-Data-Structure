package lab9;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(exponent(10, 3));
    }

    public static long exponent(int x, int y) {
        if (y == 0) return 1;
        return x * exponent(x, y-1);
    }
}
