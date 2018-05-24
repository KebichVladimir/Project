package by.itacademy.parsing;

import by.itacademy.annotations.Bean;
import by.itacademy.elements.Customer;
import by.itacademy.elements.ServiceStation;
import by.itacademy.exceptions.ReaderBaseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ParsingJSON implements ParsingBase {

    @Override
    public ServiceStation readBase() throws ReaderBaseException {
        HttpURLConnection myUrlCon = null;
        try {
            URL myUrl = new URL("https://raw.githubusercontent.com/KebichVladimir/Files/master/ClientBase.json");
            myUrlCon = (HttpURLConnection) myUrl.openConnection();
            myUrlCon.connect();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(myUrlCon.getInputStream(), StandardCharsets.UTF_8));
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Customer.class, new CustomerDeserializer())
                    .create();
            ServiceStation serviceStation = gson.fromJson(bufferedReader, ServiceStation.class);
            return serviceStation;
        } catch (IOException e) {
            throw new ReaderBaseException(e);
        } finally {
            myUrlCon.disconnect();
        }
    }
}

