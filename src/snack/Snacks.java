package snack;

import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks;

    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Soda", 50));
        snacks.add(new Snack("Sandwich", 120));
        snacks.add(new Snack("Chips", 50));
    }

    public static void setSnack(Snack snack) {
        Snacks.snacks.add(snack);
    }

    public static List<Snack> getSnacks() {
        return Snacks.snacks;
    }

    public static void showSnacks() {
        StringBuilder snacksInventory = new StringBuilder();

        for(Snack snack : snacks) {
            snacksInventory.append(snack.toString()).append("\n");
        }
        System.out.println(snacksInventory);
    }

}
