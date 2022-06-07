package tutorial9;

public class Q1 {
    /*
     * The base case of f(n) is n == 1, in which the method stops the recursion.
     * When evaluate f(n = 0), every subsequent recursive call will decrement the n by 1.
     * Since n is always lower than 1, the method will not reach the base case and will not terminate.
     * (StackOverflowError will be thrown first before n is overflowed back to 0.)
     */
    public static void main(String[] args) {
        f(0);
    }

    public static int f(int n) {
        if (n == 1)
            return n;
        else
            return n * f(n-1);
    }
}
