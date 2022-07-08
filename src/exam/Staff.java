package exam;

public class Staff {
    private int staffID;
    private String staffName;
    private String position;

    public Staff() {
    }

    public Staff(int id, String name, String post) {
        staffID= id;
        staffName = name;
        position = post;
    }

    public int getID () {
        return staffID;
    }

    public String getName () {
        return staffName;
    }

    public String getPosition () {
        return position;
    }
}
