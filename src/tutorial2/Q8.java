package tutorial2;

import java.util.ArrayList;

public class Q8 {
    public static void displayList(ArrayList<?> list) {
        for (Object o : list)
            System.out.print(o + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> numOfCars = new ArrayList<>();
        ArrayList<Double> milesPerHour = new ArrayList<>();
        displayList(numOfCars);
        displayList(milesPerHour);
    }
}
