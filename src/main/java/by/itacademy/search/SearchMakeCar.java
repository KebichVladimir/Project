package by.itacademy.search;

import by.itacademy.annotations.Bean;
import by.itacademy.base.CommonBase;
import by.itacademy.elements.Customer;
import by.itacademy.base.Singleton;
import by.itacademy.elements.CarManufacturer;
import by.itacademy.elements.Cars;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Bean()
public class SearchMakeCar implements SearchInBase {
    private Set<Customer> customers = new HashSet<>();
    private CarManufacturer carManufacturer = new CarManufacturer();
    private String countryOfOrigin;
    private Map<String, String> carsManufacturer = new HashMap<>();
    private String carOrigin;
    private List<String> parts = new ArrayList<>();

    @Override
    public void find() {
        inputInfo();
        customers = Singleton.getInstance(new CommonBase().getBase()).getAllCustomers();
        for (Customer customer : customers) {
            List<Cars> carsList = customer.getCarList();
            for (Cars car : carsList) {
                String carBrand = car.getCarName();
                parts = Arrays.asList(carBrand.split(" "));
            }
            for (String carName : parts) {
                if (carName.equals(getCarOrigin()))
                    System.out.print(customer.toString());
            }
        }
        System.out.println();
    }

    public String getCarOrigin() {
        carsManufacturer = carManufacturer.addManufacturersCar();
        for (Map.Entry<String, String> entry : carsManufacturer.entrySet())
            if (countryOfOrigin.equals(entry.getValue()))
                carOrigin = entry.getKey();
        return carOrigin;
    }

    public void inputInfo() {
        System.out.println("Введите регион производства:");
        carManufacturer.getManufacturers();
        Scanner scanner = new Scanner(System.in);
        countryOfOrigin = scanner.nextLine();
    }
}

