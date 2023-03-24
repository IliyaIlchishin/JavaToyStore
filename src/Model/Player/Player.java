package Model.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.*;
import Controller.Input;
import Model.Toys.Animal;

public class Player {
    String name;
    double luck;
    double skill;
    int money = 50;
    public static List <Animal> prizes;


    public Player(){
        this.skill = RandomSkill();
        this.luck = RandomLuck();
        this.name = SetName();
        this.prizes = new ArrayList<>(1);
    }

    public double getLuck(){
        return this.luck;
    }
    public double getSkill(){
        return this.skill;
    }

    protected double RandomSkill(){
        Random r = new Random();
        double skill = r.nextDouble(1.4, 2);
        return skill;
    }

    protected double RandomLuck(){
        Random r = new Random();
        double luck = r.nextDouble(1.4, 2);
        return luck;
    }
    public String SetName(){
        System.out.printf("Введи имя игрока\n");
        return Input.GetStringFromUser();
    }

    public String GetName(){
        return this.name;
    }

    public Boolean PayMoney(int cost){
        if (money > 0){
            this.money = money - cost;
            System.out.printf("Осталось %d монет\n", money);
            return true;
        }

        if (money <= 0){
            System.out.print("У тебя закончились деньги, приходи в следующий раз\n");
            return false;
        }
        return null;
    }

    public void AddPrizes (Animal a, Player player ){
        player.prizes.add(a);

    }

    public List <Animal> GetPrizes(){
        return this.prizes;
    }

    public String [] Ranks(List <Animal> prizes, Player player){
        // Player name
        // q-ty of animals
        // scores
        String [] Ranks = new String[3];
        Ranks[0] = player.GetName();


        String qtyOfprizes = ""+(prizes.size());
        Ranks[1] = qtyOfprizes;

        int scores = Scores(prizes);
        Ranks[2] = ""+scores;

        return Ranks;
    }

    protected int Scores (List <Animal> prizes){
        double scores = 0;
        for (int i =0; i < prizes.size(); i++){
            scores = scores + prizes.get(i).getWeight();
        }
        int iScore = (int)scores;

        return iScore;
    }

    public void VicroryPrint(String [] Ranks){
        System.out.printf("Ваши результаты\n");
        System.out.printf("-------------------------------\n");
        System.out.printf("Имя -  " + Ranks[0]);
        System.out.printf(",вытащил игрушек -  " + Ranks[1]);
        System.out.printf(",рейтинг -  " + Ranks[2]);
        System.out.printf("\n");
        System.out.printf("-------------------------------\n");

    }



}
