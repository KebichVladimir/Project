package by.itacademy.search;

import by.itacademy.annotations.Bean;
import by.itacademy.base.CommonBase;
import by.itacademy.elements.Customer;
import by.itacademy.base.Singleton;

import java.util.HashSet;
import java.util.Scanner;

@Bean()
public class SearchFirstName implements SearchInBase {
    private HashSet<Customer> customers = new HashSet<>();
    private HashSet<Customer> customersSearch = new HashSet<>();
    private String firstName;

    public void inputInfo() {
        System.out.println("Введите фамилию клиента");
        Scanner scanner = new Scanner(System.in);
        firstName = scanner.nextLine();
    }

    @Override
    public void find() {
        inputInfo();
        customers = Singleton.getInstance(new CommonBase().getBase()).getAllCustomers();
        for (Customer customer : customers) {
            if (firstName.equals(customer.getFirstName()))
                customersSearch.add(customer);
        }
        for (Customer customer : customersSearch)
            System.out.print(customer.toString());
        System.out.println();
        if (customersSearch.size() == 0)
            System.out.println("Клиенты с фамилией \"" + firstName + "\" не найдены");
    }
}

