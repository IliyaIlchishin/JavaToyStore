package Model.Toys;
import static Controller.Input.GetDataFromUser;


public class Horse extends Animal {

    protected double weight = 0.35;
    private String Name = "Horse";

    public Horse () {
        super();
    }

    public String getName() {
        return Name;
    }

    public double getWeight() {
        return weight;
    }

}


