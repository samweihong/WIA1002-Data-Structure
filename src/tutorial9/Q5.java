package tutorial9;

public class Q5 {
    public static void main(String[] args) {
        printDigit(4567);
    }

    public static void printDigit(int num) {
        if (num == 0) return;
        printDigit(num / 10);
        System.out.print(num % 10 + " ");
    }
}
