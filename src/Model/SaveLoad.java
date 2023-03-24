package Model;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import Model.GameMachine.PlayMachine;
import Model.Toys.Animal;
import java.nio.file.StandardOpenOption;

public class SaveLoad {
    private static final String path = "/Users/iliyailchishin/Desktop/GB/Q2/JAVA/ToyShop/ToyShop/src/win.csv";



    public static void save(List<Animal> animal) {

        try {
                Path filePath = Paths.get("./win.csv");
                if (Files.notExists(filePath)) {
                    filePath.toFile().createNewFile(); }

                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < animal.size();)
                {

                    stringBuilder.append(animal.get(i).getId());
                    stringBuilder.append(',');
                    stringBuilder.append(animal.get(i).getName());
                    stringBuilder.append(',');
                    stringBuilder.append(animal.get(i).getWeight());
                    stringBuilder.append(System.lineSeparator());
                    animal.remove(i);
                }
                Files.write(filePath, stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void removeEverything() {
            try {
                Path filePath = Paths.get("./win.csv");
                    Files.delete(filePath);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }



}
