package tutorial9;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(reverse("String"));
    }

    public static String reverse(String s) {
        if (s.isEmpty()) return "";
        return reverse(s.substring(1)) + s.charAt(0);
    }
}
