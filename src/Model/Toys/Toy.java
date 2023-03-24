package Model.Toys;

abstract class Toy {
    protected int id = 0;
    protected double weight = 0.1;

    private static int IdCount = 0;


    public Toy() {
        this.id = IdCount;
                IdCount++;
    }



    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id  + "; Вес: " + weight;
    }

}
