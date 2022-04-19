package lab5.SList;

public class TestSList {
    public static void main(String[] args) {
        SList<String> list = new SList<>();
        list.appendEnd("Linked list");
        list.appendEnd("is");
        list.appendEnd("easy.");

        list.display();

        System.out.println(list.removeInitial());

        System.out.print("\"difficult\" is in the list: ");
        System.out.println(list.contains("difficult"));

        list.clear();
    }
}
