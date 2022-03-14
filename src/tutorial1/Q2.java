package tutorial1;

public class Q2 {
    /*
     * Output:
     * (1) Performs Person's tasks
     * (2) Invoke Employee's overloaded constructor
     * (3) Performs Employee's tasks
     * (4) Performs Faculty's tasks
     *
     * Explanation:
     * When a Faculty object is created, the constructor of Faculty class is called.
     * As Faculty extends Employee, it will call the super constructor of Employee class in its constructor.
     * Likewise, as Employee extends Person, it will call the super constructor of Person class in its constructor.
     * In the Person constructor, the first line of output "(1) Performs Person's tasks" is printed.
     * The program returns to the Employee's constructor where it invokes the overloaded constructor with a String parameter.
     * In this overloaded constructor, the argument, s = "(2) Invoke Employee's overloaded constructor" is printed as second line.
     * The program returns to the no-arg constructor where it prints the third line "(3) Performs Employee's tasks".
     * Finally, the program returns to the Faculty's constructor and prints the last line "(4) Performs Faculty's tasks".
     */
    public static void main(String[] args) {
        Faculty.main(args);
    }
}
