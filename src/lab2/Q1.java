package lab2;

public class Q1 {
    public static void main(String[] args) {
        StorePairGeneric<Integer> pair1 = new StorePairGeneric<>(6, 4);
        StorePairGeneric<Integer> pair2 = new StorePairGeneric<>(2, 2);
        StorePairGeneric<Integer> pair3 = new StorePairGeneric<>(6, 3);

        System.out.println(pair1.compareTo(pair2));
        System.out.println(pair1.compareTo(pair3));
        System.out.println(pair2.compareTo(pair1));
        System.out.println(pair2.compareTo(pair3));
        System.out.println(pair3.compareTo(pair1));
        System.out.println(pair3.compareTo(pair2));

        System.out.println(pair1.equals(pair2));
        System.out.println(pair1.equals(pair3));
        System.out.println(pair2.equals(pair3));
    }
}

class StorePairGeneric<T extends Comparable<T>> implements Comparable<StorePairGeneric<T>> {
    private T first, second;

    public StorePairGeneric(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "first = " + first + " second = " + second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorePairGeneric<?> that = (StorePairGeneric<?>) o;
        return first.equals(that.first);
    }

    @Override
    public int compareTo(StorePairGeneric<T> that) {
        return first.compareTo(that.first);
    }
}
