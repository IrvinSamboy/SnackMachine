package snack;

import java.util.Scanner;

public class SnackMachine {
    public static void main(String[] args) {
        snackMachine();
    }

    static void snackMachine() {
        Scanner read = new Scanner(System.in);
        int option = 0;
        boolean exit = false;
        System.out.println("--SNACK MACHINE--");
        Snacks.showSnacks();

        while (!exit) {
            try{
                option = showMenu(read);
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
}



