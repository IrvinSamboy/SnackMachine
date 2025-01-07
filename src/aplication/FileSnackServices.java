package aplication;

import domain.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileSnackServices implements  ISnacksServices{

    private final String fileName = "snacks.txt";
    private final File file = new File(fileName);
    List<Snack> snacks = new ArrayList<>();

    @Override
    public void setSnack(Snack snack) {
        this.snacks.add(snack);
        this.addSnacksToFile(snack);
    }

    private void addSnacksToFile(Snack snack) {
        boolean append = false;
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            writer.println(snack.writeSnackToFile());
            writer.close();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private List<Snack> getSnacksFromFile() {
        List<Snack> snacks = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            lines.forEach((item) -> {
                String[] itemSplited = item.split(",");
                snacks.add(new Snack(itemSplited[1], Double.parseDouble(itemSplited[2])));
            });
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return  snacks;
    }


    @Override
    public void showSnacks() {

    }

    @Override
    public List<Snack> getSnacks() {
        return List.of();
    }
}
