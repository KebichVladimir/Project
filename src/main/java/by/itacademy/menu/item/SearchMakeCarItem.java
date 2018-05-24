package by.itacademy.menu.item;

import by.itacademy.menu.MenuItem;
import by.itacademy.menu.StartBaseMenuItem;
import by.itacademy.search.SearchMakeCar;

public class SearchMakeCarItem extends StartBaseMenuItem implements MenuItem {

    public SearchMakeCarItem(MenuItem startMenuItem) {
        super(startMenuItem);
    }

    @Override
    protected void baseExecute() {
        new SearchMakeCar().find();
    }

    @Override
    public String name() {
        return "Поиск записи по региону производства автомобиля";
    }
}
