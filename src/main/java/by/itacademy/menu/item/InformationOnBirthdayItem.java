package by.itacademy.menu.item;

import by.itacademy.information.InformationOnBirthday;
import by.itacademy.menu.MenuItem;
import by.itacademy.menu.StartBaseMenuItem;

public class InformationOnBirthdayItem extends StartBaseMenuItem implements MenuItem {

    public InformationOnBirthdayItem(MenuItem startMenuItem) {
        super(startMenuItem);
    }

    @Override

    protected void baseExecute() {
        System.out.println(new InformationOnBirthday().find().toString());
    }

    @Override
    public String name() {
        return "Вывод клиентов с днем рождения в этом месяце";
    }
}
