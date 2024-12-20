package snack;

import java.util.Scanner;

public class SnackMachine {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int options = 0;

        System.out.println("--SNACK MACHINE--");
        Snacks.showSnacks();

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("Menu:");
        System.out.println("1. Buy snack");
        System.out.println("2. Show ticket");
        System.out.println("3. Add new snack");
        System.out.println("4. Exit");

        options = read.nextInt();


    }
}



