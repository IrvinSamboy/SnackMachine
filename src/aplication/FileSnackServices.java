package aplication;

import domain.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileSnackServices implements  ISnacksServices{

    private final String fileName = "snacks.txt";
    private File file = new File(fileName);
    List<Snack> snacks = new ArrayList<>();

    @Override
    public void setSnack(Snack snack) {
        this.snacks.add(snack);
        this.addSnacksToFile(snack);
    }

    private void addSnacksToFile(Snack snack) {
        boolean append = false;
        PrintWriter writer = new PrintWriter(new FileWriter(file));
        writer.println(snack);
        writer.close();
    }

    @Override
    public void showSnacks() {

    }

    @Override
    public List<Snack> getSnacks() {
        return List.of();
    }
}
