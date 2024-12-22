package snack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnackMachine {
    public static void main(String[] args) {
        snackMachine();
    }

    static void snackMachine() {
        Scanner read = new Scanner(System.in);
        List<Snack> products = new ArrayList<>();
        int option = 0;
        boolean exit = false;
        System.out.println("--SNACK MACHINE--");
        Snacks.showSnacks();

        while (!exit) {
            try{
                option = showMenu(read);
                exit = executeOptions(option, read, products);
            }
            catch (Exception e) {
                System.out.println("An error was ocurred " + e.getMessage());
            }

        }
    }

    static int showMenu(Scanner read) {
        System.out.println("""
                1. Buy Snack
                2. Show ticket
                3. Ad new snack
                4, Exit
                """);

        return Integer.parseInt(read.nextLine());
    }

    static boolean executeOptions (int option, Scanner read, List<Snack> products) {
            boolean exit = false;

            switch (option) {
                case 1 -> addProduct(read, products);
            }

            return exit;
    }

    static void addProduct (Scanner read, List<Snack> products ) {
        System.out.println("Select product to buy");

        Snacks.showSnacks();

        int id = Integer.parseInt(read.nextLine());
            boolean productFound = false;
            for(Snack snack : Snacks.getSnacks()) {
                if(snack.getIdSnack() == id) {
                    products.add(snack);
                    System.out.println("Product added correctly");
                    productFound = true;
                    break;
                }
            }

            if(!productFound) {
                System.out.println("Product not found");
            }
    }
}



