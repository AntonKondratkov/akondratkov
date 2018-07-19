package ru.job4j.tracker.actions;
/**
 * @author Anton Kondratkov
 * @since 20.07.18.
 * В данном абстрактном классе реализованы два метода key и info из интерфейса UserAction. *
 */
public abstract class BaseAction implements UserAction {
    private int key;
    private String name;

    protected BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }
    @Override
    public int key() {
        return this.key;
    }
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
