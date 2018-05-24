package by.itacademy.parsing;

import by.itacademy.elements.Cars;
import by.itacademy.elements.Customer;
import by.itacademy.exceptions.CustomerBuilderException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CustomerDeserializer implements JsonDeserializer<Customer> {

    @Override
    public Customer deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        List<Cars> carList = new ArrayList<>();
        JsonObject jsonObject = json.getAsJsonObject();
        String firstName = jsonObject.get("firstName").getAsString();
        String secondName = jsonObject.get("secondName").getAsString();
        String lastOrder = jsonObject.get("lastOrder").getAsString();
        String dateOfBirth = jsonObject.get("dateOfBirth").getAsString();
        JsonArray cars = jsonObject.get("car").getAsJsonArray();
        for (JsonElement car : cars) {
            carList.add(new Cars(car.getAsString()));
        }
        String discount = jsonObject.get("discount").getAsString();
        try {
            return Customer.builder()
                    .firstName(firstName)
                    .secondName(secondName)
                    .lastOrder(lastOrder)
                    .dateOfBirth(dateOfBirth)
                    .carList(carList)
                    .discount(discount)
                    .build();
        } catch (CustomerBuilderException e) {
            throw new JsonParseException(e);
        }
    }
}

