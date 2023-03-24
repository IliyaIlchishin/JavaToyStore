package Model.Toys;
import static Controller.Input.GetDataFromUser;


public class Tiger extends Animal {

    protected double weight = 0.45;
    private String Name = "Tiger";

    public Tiger () {
        super();
    }

    public double getWeight() {
        return weight;
    }
    public String getName() {
        return Name;
    }


}
