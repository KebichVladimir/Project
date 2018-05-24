package by.itacademy.elements;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CarManufacturer {
    private Map<String, String> carsManufacturer = new HashMap<>();
    private Set<String> manufacturer = new TreeSet<>();

    public Map<String, String> addManufacturersCar() {
        carsManufacturer.put("Audi", "Немецкие авто");
        carsManufacturer.put("BMW", "Немецкие авто");
        carsManufacturer.put("Opel", "Немецкие авто");
        carsManufacturer.put("Mercedes", "Немецкие авто");
        carsManufacturer.put("Toyota", "Японские авто");
        carsManufacturer.put("Lexus", "Японские авто");
        carsManufacturer.put("Mazda", "Японские авто");
        carsManufacturer.put("Nissan", "Японские авто");
        carsManufacturer.put("Mitsubishi", "Японские авто");
        carsManufacturer.put("Chevrolet", "Американские авто");
        carsManufacturer.put("Dodge", "Американские авто");
        carsManufacturer.put("Chrysler", "Американские авто");
        carsManufacturer.put("Jeep", "Американские авто");
        carsManufacturer.put("Citroen", "Французские авто");
        carsManufacturer.put("Peugeot", "Французские авто");
        carsManufacturer.put("Renault", "Французские авто");
        carsManufacturer.put("Fiat", "Итальянские авто");
        carsManufacturer.put("ВАЗ", "Российские авто");
        carsManufacturer.put("Lada", "Российские авто");
        return carsManufacturer;
    }

    public void getManufacturers() {
        addManufacturersCar();
        for (String key : carsManufacturer.keySet())
            manufacturer.add(carsManufacturer.get(key));
        System.out.println(manufacturer);
    }
}
