package Model.Toys;
import static Controller.Input.GetDataFromUser;


public class Bear extends Animal {

    protected double weight = 0.4;
    private String Name = "Bear";

    public Bear () {
        super();
    }

    public double getWeight() {
        return weight;
    }


    public String getName() {
        return Name;
    }


}


