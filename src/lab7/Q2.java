package lab7;

import java.util.LinkedList;
import java.util.Queue;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("T_T"));
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("uvvwu"));
        System.out.println(isPalindrome("xyzzyx"));
        System.out.println(isPalindrome("pppqpp"));
    }

    private static boolean isPalindrome(String s) {
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length()/2; i++)
            q.offer(s.charAt(i));
        for (int i = s.length()-1; !q.isEmpty(); i--)
            if (s.charAt(i) != q.poll())
                return false;
        return true;
    }
}
