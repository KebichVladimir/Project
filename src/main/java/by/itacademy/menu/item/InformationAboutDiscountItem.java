package by.itacademy.menu.item;

import by.itacademy.information.InformationAboutDiscount;
import by.itacademy.menu.MenuItem;
import by.itacademy.menu.StartBaseMenuItem;

public class InformationAboutDiscountItem extends StartBaseMenuItem implements MenuItem {

    public InformationAboutDiscountItem(MenuItem startMenuItem) {
        super(startMenuItem);
    }

    @Override
    protected void baseExecute() {
        new InformationAboutDiscount().find();
    }

    @Override
    public String name() {
        return "Вывести % клиентов имеющих скидку от общего числа клиентов";
    }
}
