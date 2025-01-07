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

    public FileSnackServices() {
        boolean exits = false;

        try {
            exits = file.exists();
            if(exits){
                this.snacks = getSnacksFromFile();
            }
            else {
                PrintWriter out = new PrintWriter(new FileWriter(file));
                out.close();
                initialSnacks();

            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void initialSnacks() {
        setSnack(new Snack("Soda", 50));
        setSnack(new Snack("Sandwich", 120));
        setSnack(new Snack("Chips", 50));
    }

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
        StringBuilder snacksInventory = new StringBuilder();

        snacks.forEach((item) -> {
            snacksInventory.append(item.toString()).append("\n");
        });

        System.out.println(snacksInventory);
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}
