package labtest1;

public class Pet implements Comparable<Pet>{
    private String breed;
    private int weight;
    private String sickness;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    /**
     * Compare the pets' weights.
     * @param that the pet to be compared
     * @return a negative integer, zero, or a positive integer as this pet has a weight less than, equal to, or greater than that pet
     */
    @Override
    public int compareTo(Pet that) {
        // Without using Integer.compare():
        if (weight < that.weight)
            return -1;
        else if (weight > that.weight)
            return 1;
        else
            return 0;
//        return Integer.compare(weight, that.weight);
    }
}
