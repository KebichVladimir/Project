package by.itacademy.information;

import static org.junit.Assert.assertEquals;

import by.itacademy.elements.Customer;
import by.itacademy.exceptions.CustomerBuilderException;
import org.junit.Test;

import java.util.HashSet;

public class InformationOnBirthdayTest {

    @Test
    public void findShouldReturnOne() {
        HashSet<Customer> expectedList = new HashSet<>();
        InformationOnBirthday informationOnBirthday = new InformationOnBirthday();
        try {
            expectedList.add(Customer.builder().firstName("Шевелев").secondName("Михаил").dateOfBirth("1992-12-01").lastOrder("2017-10-13").build());
        } catch (CustomerBuilderException e) {
            e.printStackTrace();
            assertEquals(expectedList, informationOnBirthday.find());
        }
    }
}
