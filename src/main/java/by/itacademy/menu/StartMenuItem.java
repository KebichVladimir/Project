package by.itacademy.menu;

import by.itacademy.menu.item.ExitMenuItem;
import by.itacademy.menu.item.InformationAboutDiscountItem;
import by.itacademy.menu.item.InformationAboutOrderItem;
import by.itacademy.menu.item.InformationOnBirthdayItem;
import by.itacademy.menu.item.SearchFirstNameItem;
import by.itacademy.menu.item.SearchMakeCarItem;
import by.itacademy.menu.item.SortLastOrderItem;
import by.itacademy.menu.item.SortNameItem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StartMenuItem implements MenuItem {
    private Map<Integer, BaseMenuItem> items = new HashMap<>();

    {
        items.put(1, new SortNameItem(this));
        items.put(2, new SortLastOrderItem(this));
        items.put(3, new SearchFirstNameItem(this));
        items.put(4, new SearchMakeCarItem(this));
        items.put(5, new InformationOnBirthdayItem(this));
        items.put(6, new InformationAboutOrderItem(this));
        items.put(7, new InformationAboutDiscountItem(this));
        items.put(8, new ExitMenuItem());
    }

    @Override
    public void execute() {
        for (Map.Entry<Integer, BaseMenuItem> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().name());
        }
        Scanner scanner = new Scanner(System.in);
        items.get(scanner.nextInt()).execute();
        scanner.nextLine();
    }
}
