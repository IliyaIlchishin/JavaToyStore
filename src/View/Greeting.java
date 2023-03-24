package View;
import Controller.Input;
import Model.GameMachine.PlayMachine;
import Model.Player.Player;
import Model.Toys.Animal;
import Model.Toys.Bear;
import Model.Toys.Horse;
import Model.Toys.Tiger;
import Model.SaveLoad;

import java.util.List;


public class Greeting {


    public void greeting(){

        System.out.print("Добра пожаловать в логова однорукого бандита");
        System.out.print("Здесь за совершенно символическую цены в 5 золотых луидоров ты можешь попытать удачу и достать золотые статуэтки животных");

    }
    public static void StartGame(){

        System.out.print("Нажми 1, чтобы начать игру\n");
        int choice = Input.GetDataFromUser();

        if (choice == 1) {
            Game();
        }
        else {

        }

    }

    public static void Game(){
        Player YourPlayer = new Player();


        // наполняем автомат игрушками
        PlayMachine bandit = new PlayMachine();


        for (int i =0; i <20; i++)
        {
            bandit.PutToyInside(new Bear());
            i++;
            bandit.PutToyInside(new Horse());
            i++;
            bandit.PutToyInside(new Tiger());
        }

        System.out.printf("Внутри %d игрушек \n",bandit.QtyToysInside());
        System.out.println(bandit.GetToysInside());
        System.out.printf("Стоимость попытки - 5 монет\n");

        bandit.TakeToy(bandit,YourPlayer);
        SaveLoad.save(YourPlayer.GetPrizes());

        YourPlayer.VicroryPrint(YourPlayer.Ranks(YourPlayer.GetPrizes(),YourPlayer));


    }


}
