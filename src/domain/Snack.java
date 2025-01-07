package domain;

import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {
    private static int snackCounter = 0;
    private int idSnack;
    private String name;
    private double price;

    public Snack() {
        this.idSnack = Snack.snackCounter++;
    }

    public Snack(String name, double price) {
        this();
        this.name = name;
        this.price = price;
    }

    public static int getSnackCounter() {
        return Snack.snackCounter;
    }

    public int getIdSnack() {
        return this.idSnack;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String writeSnackToFile() { return idSnack + "," + name + "," + price; }

    @Override
    public String toString() {
        return "Snack{" +
                "idSnack=" + this.idSnack +
                ", name='" + this.name + '\'' +
                ", price=" + this.price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return idSnack == snack.idSnack && Double.compare(price, snack.price) == 0 && Objects.equals(name, snack.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSnack, name, price);
    }
}
