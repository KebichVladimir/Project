package by.itacademy.menu.item;

import by.itacademy.menu.MenuItem;
import by.itacademy.menu.StartBaseMenuItem;
import by.itacademy.sorting.SortingLastOrder;

public class SortLastOrderItem extends StartBaseMenuItem implements MenuItem {

    public SortLastOrderItem(MenuItem menuItem) {
        super(menuItem);
    }

    @Override
    public String name() {
        return "Сортировка базы по дате заказа";
    }

    @Override
    protected void baseExecute() {
        new SortingLastOrder().sort();
    }
}

