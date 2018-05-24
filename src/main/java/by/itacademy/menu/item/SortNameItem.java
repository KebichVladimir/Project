package by.itacademy.menu.item;

import by.itacademy.menu.MenuItem;
import by.itacademy.menu.StartBaseMenuItem;
import by.itacademy.sorting.SortingFirstName;

public class SortNameItem extends StartBaseMenuItem implements MenuItem {

    public SortNameItem(MenuItem menuItem) {
        super(menuItem);
    }

    @Override
    public String name() {
        return "Сортировка базы по фамилии";
    }

    @Override
    protected void baseExecute() {
        new SortingFirstName().sort();
    }
}
