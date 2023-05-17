package lab7;

import java.util.LinkedList;
import java.util.Queue;

public class Q2 {
    public static void main(String[] args) {
        String[] inputs = {"T_T", "abcba", "uvvwu", "xyzzyx", "pppqpp"};
        for (String input : inputs)
            System.out.printf("%s is palindrome: %b\n", input, isPalindrome(input));
    }

    private static boolean isPalindrome(String s) {
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length() / 2; i++)
            q.offer(s.charAt(i));
        for (int i = s.length() - 1; !q.isEmpty(); i--)
            if (s.charAt(i) != q.poll())
                return false;
        return true;
    }
}
