package tutorial1;

public class Q1 {
    public static void main(String[] args) {
        Telephone t1 = new Telephone("03", "79676300");
        Telephone t2 = new Telephone("03", "79676301");
        Telephone t3 = new Telephone("03", "79676302");
        Telephone t4 = new Telephone("03", "79676303");
        Telephone t5 = new Telephone("03", "79676304");
        Telephone[] arr = {t1,t2,t3,t4,t5};

        for (Telephone t : arr)
            System.out.println(t.makeFullNumber());
    }
}

class Telephone {
    private String areaCode;
    private String number;
    private static int numberOfTelephoneObject = 0;

    public Telephone(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
        numberOfTelephoneObject++;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getNumber() {
        return number;
    }

    public String makeFullNumber() {
        return areaCode + "-" + number;
    }
}
