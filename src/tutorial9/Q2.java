package tutorial9;

public class Q2 {
    /*
     * The base case of f(n) is n == 0, in which the method stops the recursion.
     * When evaluate f(n > 0), every subsequent recursive call will increment the n by 1.
     * Since n is always larger than 0, the method will not reach the base case and will not terminate.
     * (StackOverflowError will be thrown first before n is overflowed back to 0.)
     */
    public static void main(String[] args) {
        f(1);
    }

    public static int f(int n) {
        if (n == 0)
            return n;
        else
            return f(n+1) + n;
    }
}
