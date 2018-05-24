package by.itacademy.information;

import by.itacademy.annotations.Bean;
import by.itacademy.base.CommonBase;
import by.itacademy.elements.Customer;
import by.itacademy.base.Singleton;

import java.util.HashSet;

@Bean()
public class InformationAboutDiscount {
    private HashSet<Customer> customers = new HashSet<>();
    private HashSet<Customer> discountedCustomers = new HashSet<>();

    public void find() {
        customers = Singleton.getInstance(new CommonBase().getBase()).getAllCustomers();
        String valueDiscount = "true";
        for (Customer customer : customers) {
            if ((customer.isDiscountAsString()).equals(valueDiscount))
                discountedCustomers.add(customer);
        }
        System.out.println(((discountedCustomers.size()) * 100 / customers.size()) + "% клиентов имеют скидку");
    }
}

