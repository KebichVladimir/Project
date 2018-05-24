package by.itacademy.menu.item;

import by.itacademy.menu.BaseMenuItem;
import by.itacademy.menu.MenuItem;

public class ExitMenuItem extends BaseMenuItem implements MenuItem {

    @Override
    public String name() {
        return "Выход";
    }

    @Override
    public void execute() {
    }
}
