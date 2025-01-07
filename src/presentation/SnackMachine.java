package presentation;

import aplication.FileSnackServices;
import aplication.ISnacksServices;
import aplication.ListSnackServices;
import domain.Snack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnackMachine {
    public static void main(String[] args) {
        snackMachine();
    }

    static void snackMachine() {
        Scanner read = new Scanner(System.in);
        ISnacksServices snacksServices = new FileSnackServices();
        List<Snack> products = new ArrayList<>();
        int option = 0;
        boolean exit = false;
        System.out.println("--SNACK MACHINE--");
        snacksServices.showSnacks();

        while (!exit) {
            try{
                option = showMenu(read);
                exit = executeOptions(option, read, products, snacksServices);
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

    static boolean executeOptions (int option, Scanner read, List<Snack> products, ISnacksServices snacksServices) {
            boolean exit = false;

            switch (option) {
                case 1 -> addProduct(read, products, snacksServices);
                case 2 -> showTicket(products);
                case 3 -> addSnack(read, snacksServices);
                case 4 -> exit = true;
                default -> System.out.println("An error was ocurred, invalid option");
            }

            return exit;
    }

    static void addProduct (Scanner read, List<Snack> products, ISnacksServices snacksServices ) {
        System.out.println("Select product to buy");

        snacksServices.showSnacks();

        int id = Integer.parseInt(read.nextLine());
            boolean productFound = false;
            for(Snack snack : snacksServices.getSnacks()) {
                if(snack.getIdSnack() == id) {
                    products.add(snack);
                    System.out.println("Product added correctly");
                    System.out.println();
                    productFound = true;
                    break;
                }
            }

            if(!productFound) {
                System.out.println("Product not found");
                System.out.println();
            }
    }

    static void showTicket(List<Snack> products) {
        System.out.println("--Purchase receipt--");
        for (Snack product : products) {
            System.out.println();
            System.out.println("Product Id: " + product.getIdSnack());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println();
        }
    }

    static void addSnack (Scanner read, ISnacksServices snacksServices) {
        System.out.println("Enter the name");
        String name = read.nextLine();
        System.out.println("Enter the price");
        double price = Double.parseDouble(read.nextLine());
        Snack newSnack = new Snack(name, price);
        snacksServices.setSnack(newSnack);
        System.out.println("Snack added correctly");
        snacksServices.showSnacks();
    }
}



