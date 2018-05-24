package by.itacademy.base;

import by.itacademy.elements.ServiceStation;
import by.itacademy.exceptions.ReaderBaseException;
import by.itacademy.parsing.ParsingJSON;
import by.itacademy.parsing.ParsingXML;

public class CommonBase {
    private ServiceStation serviceStation;

    public ServiceStation getBase() {
        Thread jsonReaderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ParsingXML parsingXML = new ParsingXML();
                    serviceStation = parsingXML.readBase();
                } catch (ReaderBaseException e) {
                    e.printStackTrace();
                }
            }
        });
        jsonReaderThread.start();
        if (serviceStation == null)
            try {
                jsonReaderThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        try {
            serviceStation.addCustomers(new ParsingJSON().readBase().getCustomers());
        } catch (ReaderBaseException e) {
            e.printStackTrace();
        }
        return serviceStation;
    }
}
