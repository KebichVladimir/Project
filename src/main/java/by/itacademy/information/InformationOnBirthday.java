package by.itacademy.information;

import by.itacademy.annotations.Bean;
import by.itacademy.base.CommonBase;
import by.itacademy.base.Singleton;
import by.itacademy.elements.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;

@Bean()
public class InformationOnBirthday implements Information {
    private HashSet<Customer> customers = new HashSet<>();
    private HashSet<Customer> customersSearch = new HashSet<>();
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private Date dateOfBirth;
    Calendar calendar = new GregorianCalendar();


    @Override
    public HashSet<Customer> find() {
        customers = Singleton.getInstance(new CommonBase().getBase()).getAllCustomers();
        int todayMonth = calendar.get(Calendar.MONTH);
        for (Customer customer : customers) {
            try {
                dateOfBirth = format.parse(customer.getDateOfBirthAsString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            calendar.getInstance();
            calendar.setTime(dateOfBirth);
            int month = calendar.get(Calendar.MONTH);
            if (month == todayMonth)
                customersSearch.add(customer);

        }
        return customersSearch;
    }
}

