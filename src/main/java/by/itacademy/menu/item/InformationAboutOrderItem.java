package by.itacademy.menu.item;

import by.itacademy.information.InformationAboutOrder;
import by.itacademy.menu.MenuItem;
import by.itacademy.menu.StartBaseMenuItem;

public class InformationAboutOrderItem extends StartBaseMenuItem implements MenuItem {

    public InformationAboutOrderItem(MenuItem startMenuItem) {
        super(startMenuItem);
    }

    @Override
    protected void baseExecute() {
        System.out.println(new InformationAboutOrder().find().toString());
    }

    @Override
    public String name() {
        return "Вывод клиентов, которые обращались на СТО больше чем 6 месяцев назад";
    }
}
