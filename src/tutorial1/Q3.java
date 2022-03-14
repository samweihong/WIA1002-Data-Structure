package tutorial1;

public class Q3 {
    /*
     * The output is a.:
     * AB
     * 
     * Explanation:
     * Java uses polymorphism where the implementation of methods is determined during runtime (dynamic binding).
     * When the o[0] is printed, the toString method of o[0] = new A() is called.
     * Since A extends B and overrides its toString method, its toString method will be called.
     * Therefore, "A" is printed.
     * On the other hand, when the o[1] is printed, the toString method of o[1] = new B() is called.
     * Since B extends Object and overrides its toString method, its toString method will be called.
     * Therefore, "B" is printed.
     */
    public static void main(String[] args) {
        C.main(args);
    }
}
