package pl.akvelon.akvelontask.model.container;

public interface Removable {

    void remove(int volumeToRemove);

    boolean canRemove(int volumeToRemove);

}
