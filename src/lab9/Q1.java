package lab9;

public class Q1 {
    public static void main(String[] args) {
        System.out.println(substituteAI("flabbergasted"));
        System.out.println(substituteAI("Astronaut"));
    }

    public static String substituteAI(String s) {
        if (s.isEmpty()) return "";
        return (s.charAt(0) == 'a' ? 'i' : s.charAt(0)) + substituteAI(s.substring(1));
    }
}
