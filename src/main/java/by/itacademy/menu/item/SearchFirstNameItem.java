package by.itacademy.menu.item;

import by.itacademy.menu.MenuItem;
import by.itacademy.menu.StartBaseMenuItem;
import by.itacademy.search.SearchFirstName;

public class SearchFirstNameItem extends StartBaseMenuItem implements MenuItem {
    public SearchFirstNameItem(MenuItem startMenuItem) {
        super(startMenuItem);
    }

    @Override
    protected void baseExecute() {
        new SearchFirstName().find();
    }

    @Override
    public String name() {
        return "Поиск записи по фамилии клиента";
    }
}
