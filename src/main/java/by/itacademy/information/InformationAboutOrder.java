package by.itacademy.information;

import by.itacademy.annotations.Bean;
import by.itacademy.base.CommonBase;
import by.itacademy.base.Singleton;
import by.itacademy.elements.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

@Bean()
public class InformationAboutOrder implements Information {
    private HashSet<Customer> customers = new HashSet<>();
    private HashSet<Customer> customersSearch = new HashSet<>();
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private Date lastOrder;
    Date todayDate = new Date();

    @Override
    public HashSet<Customer> find() {
        customers = Singleton.getInstance(new CommonBase().getBase()).getAllCustomers();
        long today = todayDate.getTime();
        long sixMonths = 15768000000L;
        for (Customer customer : customers) {
            try {
                lastOrder = format.parse(customer.getLastOrderAsString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long timeOrder = lastOrder.getTime();
            if ((today - sixMonths) > timeOrder)
                customersSearch.add(customer);
        }
        return customersSearch;
    }
}


