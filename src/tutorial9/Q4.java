package tutorial9;

public class Q4 {
    public static void main(String[] args) {
        System.out.println(sum(5));
        /*
         * sum(5)
         * 5 + sum(4)
         * 5 + 4 + sum(3)
         * 5 + 4 + 3 + sum(2)
         * 5 + 4 + 3 + 2 + sum(1)
         * 5 + 4 + 3 + 2 + 1
         * 5 + 4 + 3 + 3
         * 5 + 4 + 6
         * 5 + 10
         * 15
         */
    }

    public static int sum(int n) {
        if (n == 1) return 1;
        return n + sum(n-1);
    }
}
