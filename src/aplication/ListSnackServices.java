package aplication;

import domain.Snack;

import java.util.ArrayList;
import java.util.List;

public class ListSnackServices implements ISnacksServices {
    private static final List<Snack> snacks;

    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Soda", 50));
        snacks.add(new Snack("Sandwich", 120));
        snacks.add(new Snack("Chips", 50));
    }

    public void setSnack(Snack snack) {
        ListSnackServices.snacks.add(snack);
    }

    public List<Snack> getSnacks() {
        return ListSnackServices.snacks;
    }

    public void showSnacks() {
        StringBuilder snacksInventory = new StringBuilder();

        for(Snack snack : snacks) {
            snacksInventory.append(snack.toString()).append("\n");
        }
        System.out.println(snacksInventory);
    }

}
