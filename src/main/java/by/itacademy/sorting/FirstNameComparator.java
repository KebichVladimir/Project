package by.itacademy.sorting;

import by.itacademy.elements.Customer;

import java.util.Comparator;

public class FirstNameComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer obj1, Customer obj2) {
        int result = obj1.getFirstName().compareTo(obj2.getFirstName());
        if (result != 0) {
            return result;
        } else
            return obj1.getSecondName().compareTo(obj2.getSecondName());
    }
}

