package by.itacademy.base;

import by.itacademy.elements.Customer;
import by.itacademy.elements.ServiceStation;

import java.util.HashSet;

public final class Singleton {
    private static Singleton instance;
    private ServiceStation serviceStation;

    private Singleton(ServiceStation serviceStation) {
        this.serviceStation = serviceStation;
    }

    public static Singleton getInstance(ServiceStation serviceStation) {
        if (instance == null) {
            instance = new Singleton(serviceStation);
        }
        return instance;
    }

    public HashSet<Customer> getAllCustomers() {
        return serviceStation.getCustomers();
    }

    public String getNameService() {
        return serviceStation.getNameService();
    }

    public String getLocation() {
        return serviceStation.getLocation();
    }
}

