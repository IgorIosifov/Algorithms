package Lesson_5;

public class Items {

    private String name;
    private int cost;
    private float weight;

    public Items(String name, int cost, float weight) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public float getWeight() {
        return weight;
    }
}
