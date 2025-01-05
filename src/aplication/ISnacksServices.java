package aplication;

import domain.Snack;

import java.util.List;

public interface ISnacksServices {
    void setSnack(Snack snack);
    void showSnacks();
    List<Snack> getSnacks();
}
