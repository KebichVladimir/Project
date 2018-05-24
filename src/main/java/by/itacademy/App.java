package by.itacademy;

import by.itacademy.annotations.BeanAnnotationAnalyzer;
import by.itacademy.menu.Menu;

public class App {
    public static void main(String[] args) {
       new BeanAnnotationAnalyzer().analyze();
        new Menu().start();
    }
}