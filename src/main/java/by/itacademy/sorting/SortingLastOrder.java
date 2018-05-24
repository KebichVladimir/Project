package by.itacademy.sorting;

import by.itacademy.annotations.Bean;
import by.itacademy.base.CommonBase;
import by.itacademy.elements.Customer;
import by.itacademy.base.Singleton;

import java.util.Set;
import java.util.TreeSet;

@Bean()
public class SortingLastOrder implements SortingBase {
    private Set<Customer> customersSorting = new TreeSet<>(new LastOrderComparator());

    @Override
    public void sort() {
        customersSorting.addAll(Singleton.getInstance(new CommonBase().getBase()).getAllCustomers());
        System.out.println(Singleton.getInstance(new CommonBase().getBase()).getNameService());
        System.out.println(Singleton.getInstance(new CommonBase().getBase()).getLocation());
        System.out.println(customersSorting.toString());
    }
}

