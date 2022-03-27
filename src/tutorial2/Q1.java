package tutorial2;

public class Q1 {
    public static void main(String[] args) {
        Container.main(args);
    }
}

class Container<T> {
    private T t;

    public Container() {}

    public void add(T t) {
        this.t = t;
    }

    public T retrieve() {
        return t;
    }

    public static void main(String[] args) {
        Container<Integer> intContainer = new Container<>();
        Container<String> strContainer = new Container<>();
        intContainer.add(50);
        strContainer.add("Java");
        System.out.println(intContainer.retrieve());
        System.out.println(strContainer.retrieve());
    }
}
