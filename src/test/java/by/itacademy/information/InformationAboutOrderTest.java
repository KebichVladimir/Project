package by.itacademy.information;

import static org.junit.Assert.assertEquals;

import by.itacademy.elements.Customer;
import by.itacademy.exceptions.CustomerBuilderException;
import org.junit.Test;

import java.util.HashSet;

public class InformationAboutOrderTest {

    @Test
    public void findShouldReturnEverything() {
        HashSet<Customer> expectedList = new HashSet<>();
        InformationAboutOrder informationAboutOrder = new InformationAboutOrder();
        try {
            expectedList.add(Customer.builder().firstName("Сафьян").secondName("Илья").dateOfBirth("1965-05-30").lastOrder("2017-06-05").build());
            expectedList.add(Customer.builder().firstName("Лаппо").secondName("Виталий").dateOfBirth("1999-05-02").lastOrder("2017-05-12").build());
        } catch (CustomerBuilderException e) {
            e.printStackTrace();
            assertEquals(expectedList, informationAboutOrder.find());
        }
    }
}
