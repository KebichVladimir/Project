package by.itacademy.elements;

import by.itacademy.exceptions.CustomerBuilderException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Customer {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private String firstName;
    private String secondName;
    private Date dateOfBirth;
    private Date lastOrder;
    private List<Cars> carList;
    private boolean discount;

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getDateOfBirthAsString() {
        return format.format(dateOfBirth);
    }

    public String getLastOrderAsString() {
        return format.format(lastOrder);
    }

    public List<Cars> getCarList() {
        return carList;
    }

    public String isDiscountAsString() {
        return String.valueOf(discount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return discount == customer.discount &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(secondName, customer.secondName) &&
                Objects.equals(dateOfBirth, customer.dateOfBirth) &&
                Objects.equals(lastOrder, customer.lastOrder) &&
                Objects.equals(carList, customer.carList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, dateOfBirth, lastOrder, carList, discount);
    }

    @Override
    public String toString() {
        return "\nФамилия: '" + firstName + "', " +
                "Имя: '" + secondName + "', " +
                "Дата рождения: " + format.format(dateOfBirth) + ", " +
                "Последний заказ: " + format.format(lastOrder) + ", " +
                "Список автомобилей: " + carList + ", " +
                "Скидка: " + discount;
    }

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public static class CustomerBuilder {
        private Customer customer = new Customer();

        public CustomerBuilder firstName(String firstName) {
            customer.firstName = firstName;
            return this;
        }

        public CustomerBuilder secondName(String secondName) {
            customer.secondName = secondName;
            return this;
        }

        public CustomerBuilder lastOrder(String lastOrder) throws CustomerBuilderException {
            try {
                customer.lastOrder = format.parse(lastOrder);
            } catch (ParseException e) {
                throw new CustomerBuilderException(e);
            }
            return this;
        }

        public CustomerBuilder dateOfBirth(String dateOfBirth) throws CustomerBuilderException {
            try {
                customer.dateOfBirth = format.parse(dateOfBirth);
            } catch (ParseException e) {
                throw new CustomerBuilderException(e);
            }
            return this;
        }

        public CustomerBuilder carList(List<Cars> carList) {
            customer.carList = carList;
            return this;
        }

        public CustomerBuilder discount(String discount) {
            customer.discount = Boolean.valueOf(discount);
            return this;
        }

        public Customer build() {
            return customer;
        }
    }
}
