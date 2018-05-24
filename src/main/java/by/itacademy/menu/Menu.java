package by.itacademy.menu;

public class Menu {
    private MenuItem startMenu = new StartMenuItem();

    public void start() {
        startMenu.execute();
    }
}
