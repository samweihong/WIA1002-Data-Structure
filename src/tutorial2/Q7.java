package tutorial2;

import java.util.ArrayList;

public class Q7 {
    public static <T> void allTransportation(ArrayList<? extends T> list1, ArrayList<T> list2) {}

    public static void main(String[] args) {
        ArrayList<String> vehicle = new ArrayList<>();
        ArrayList<Object> transportation = new ArrayList<>();
        allTransportation(vehicle, transportation);
    }
}
