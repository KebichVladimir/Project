package by.itacademy.elements;

import java.util.HashSet;

public class ServiceStation {
    private String nameService;
    private String location;
    private HashSet<Customer> customers;

    public ServiceStation(String nameService, String location, HashSet<Customer> customers) {
        this.nameService = nameService;
        this.location = location;
        this.customers = customers;
    }

    public String getNameService() {
        return nameService;
    }

    public String getLocation() {
        return location;
    }

    public HashSet<Customer> getCustomers() {
        return customers;
    }

    public void addCustomers(HashSet<Customer> newCustomers) {
        customers.addAll(newCustomers);
    }
}

