import java.util.Comparator;

public class SpecialComparator<E extends CharSequence> implements Comparator<E> {
    private static final String EN = "ABC.DE..FGHIJ..KLMNOPQRS..TUVWXY.Z..";
    private static final String RU = "АБЧЧДЕЁЭФГХИЙЯЮКЛМНОП.РСШЩТУВ..ЫЖЗЬЪ";

    @Override
    public int compare(E o1, E o2) {
        int n = Math.min(o1.length(), o2.length());
        for (int i = 0; i < n; i++) {
            int rank1 = getPrecedence(o1.charAt(i));
            int rank2 = getPrecedence(o2.charAt(i));
            if (rank1 != rank2) {
                return Integer.compare(rank1, rank2);
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }

    private int getPrecedence(char c) {
        if (EN.indexOf(c) != -1) {
            return EN.indexOf(c);
        }
        return RU.indexOf(c);
    }
}
