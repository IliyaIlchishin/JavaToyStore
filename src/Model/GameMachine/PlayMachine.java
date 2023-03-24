package Model.GameMachine;
import java.util.*;
import Model.Player.Player;
import Model.Toys.Animal;
import Model.Toys.Bear;
import Model.Toys.Horse;
import Model.Toys.Tiger;
import Model.SaveLoad;

import static Controller.Input.GetDataFromUser;


public class PlayMachine {
    int MaxToysInside = 50;
    int QtytoysInside =0;
    int WinRate = 10;
    public int RoundCost = 5;

    Map <Integer, String> ToysInside =  new HashMap<>();


    public PlayMachine(){
        this.ToysInside = new HashMap<>();
    }

    public void PutToyInside(Animal name){
        if (this.QtytoysInside<MaxToysInside)
        {
        this.QtytoysInside++;
        this.ToysInside.put(QtytoysInside, name.getName());
        }
        else{
            System.out.print("Больше игрушек не поместится");
        }
    }


    // общее кол-во всех игрушек
    public int QtyToysInside(){
        return this.QtytoysInside;
    }

    // возвращаем коллекцию
    public Map <Integer, String> GetToysInside(){
        return this.ToysInside;
    }

    // кол-во игрушек определенного типа
    public int QtyOfToysInside(String toy) {
        int quantity = 0;
        for (String value : this.ToysInside.values()) {
            if (value.equals(toy)) {
                quantity++;
            }
        }
        return quantity;
    }

    protected int GetKey( Animal animal){
        int key = 1;

        for (Map.Entry<Integer, String> entry : this.ToysInside.entrySet()) {
            if (entry.getValue().equals(animal.getName())) {
                key = entry.getKey();

            }
        }
        return key;
    }

    public void TakeToy (PlayMachine a, Player player){

        boolean hasmoney = true;
        while (hasmoney == true) {
            System.out.print("Выберите игрушку, которую попытаетесь выиграть\n");
            System.out.print("1 - Медведь\n2 - Лошадь\n3 - Тигр\n");
            int choice = GetDataFromUser();
            int quantity =0;
            Random chance = new Random();


            if (choice == 1){

                Animal animal = new Bear();
                //кол-во животных конкретного типа
                quantity = a.QtyOfToysInside(animal.getName());

                if (quantity > 0) {
                    //задаем вин рэйт на выигрыш
                    int winchance = (int) (a.WinRate / animal.getWeight() * player.getLuck() * player.getSkill());
                    // шансы - рандомное число от винрейта до 100
                    int win = chance.nextInt(winchance,100);

                    // Берем с игрока деньги
                    hasmoney = player.PayMoney(a.RoundCost);
                    if (win < 50){System.out.printf("Не печалься, попробуй еще\n",quantity);}
                    if (win > 50){
                        System.out.printf("Ты везунчик! Ты вытащил %s \n", animal.getName());
                        // добавляем выигранную игрушку в список выигрышей игрока
                        player.AddPrizes(animal,player);

                        // удаляем игрушку из автома (по ключу значение)
                        a.ToysInside.remove(GetKey(animal));

                    }

                    if (quantity == 0)  {System.out.print("Таких игрушек внутри нет");}
                        }
            }
            if (choice == 2){
                Animal animal = new Horse();
                //кол-во животных конкретного типа
                quantity = a.QtyOfToysInside(animal.getName());

                if (quantity > 0) {
                    //задаем вин рэйт на выигрыш
                    int winchance = (int) (a.WinRate / animal.getWeight() * player.getLuck() * player.getSkill());
                    // шансы - рандомное число от винрейта до 100
                    int win = chance.nextInt(winchance,100);

                    // Берем с игрока деньги
                    hasmoney = player.PayMoney(a.RoundCost);

                    if (win < 90){System.out.printf("Не печалься, попробуй еще\n",quantity);}
                    if (win > 90){
                        System.out.printf("Ты везунчик! Ты вытащил %s \n", animal.getName());
                        // добавляем выигранную игрушку в список выигрышей игрока
                        player.AddPrizes(animal,player);

                        // удаляем по ключу значение
                        a.ToysInside.remove(GetKey(animal));

                    }

                    if (quantity == 0)  {System.out.print("Таких игрушек внутри нет");}
                }
            }
            if (choice == 3){
                Animal animal = new Tiger();
                //кол-во животных конкретного типа
                quantity = a.QtyOfToysInside(animal.getName());

                if (quantity > 0) {
                    //задаем вин рэйт на выигрыш
                    int winchance = (int) (a.WinRate / animal.getWeight() * player.getLuck() * player.getSkill());
                    // шансы - рандомное число от винрейта до 100
                    int win = chance.nextInt(winchance,100);

                    // Берем с игрока деньги
                    hasmoney = player.PayMoney(a.RoundCost);

                    if (win < 90){System.out.printf("Не печалься, попробуй еще\n",quantity);}
                    if (win > 90){
                        System.out.printf("Ты везунчик! Ты вытащил %s \n", animal.getName());
                        // добавляем выигранную игрушку в список выигрышей игрока
                        player.AddPrizes(animal,player);

                        // удаляем по ключу значение
                        a.ToysInside.remove(GetKey(animal));

                    }

                    if (quantity == 0)  {System.out.print("Таких игрушек внутри нет");}
                }
            }

        }

    }




}





