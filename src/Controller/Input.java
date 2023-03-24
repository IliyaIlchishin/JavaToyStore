package Controller;
import java.util.Scanner;

public class Input {

    public static int GetDataFromUser(){
        Scanner newscan = new Scanner(System.in);

        return newscan.nextInt();
    }

    public static String GetStringFromUser(){
        Scanner newscan = new Scanner(System.in);
        return newscan.nextLine();
    }


}
