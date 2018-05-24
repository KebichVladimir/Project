package by.itacademy.parsing;

import by.itacademy.elements.Cars;
import by.itacademy.elements.Customer;
import by.itacademy.elements.ServiceStation;
import by.itacademy.exceptions.CustomerBuilderException;
import by.itacademy.exceptions.ReaderBaseException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ParsingXML implements ParsingBase {
    private HashSet<Customer> customers = new HashSet<>();
    private String nameService;
    private String location;

    @Override
    public ServiceStation readBase() throws ReaderBaseException {
        HttpURLConnection myUrlCon = null;
        try {
            URL myUrl = new URL("https://raw.githubusercontent.com/KebichVladimir/Files/master/ClientBase.xml");
            myUrlCon = (HttpURLConnection) myUrl.openConnection();
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(myUrlCon.getInputStream());
            document.getDocumentElement().normalize();
            NodeList nodeServiceStation = document.getElementsByTagName("ServiceStation");
            getServiceStation(nodeServiceStation.item(0));
            NodeList nodeCustomers = document.getElementsByTagName("customers");
            for (int i = 0; i < nodeCustomers.getLength(); i++) {
                getCustomer(nodeCustomers.item(i));
            }
            return new ServiceStation(nameService, location, customers);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new ReaderBaseException(e);
        } finally {
            myUrlCon.disconnect();
        }
    }

    public void getServiceStation(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            nameService = getTagValue("nameService", element);
            location = getTagValue("location", element);
        }
    }

    public void getCustomer(Node node) {
        List<Cars> carList = new ArrayList<>();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            String firstName = getTagValue("firstName", element);
            String secondName = getTagValue("secondName", element);
            String lastOrder = getTagValue("lastOrder", element);
            String dateOfBirth = getTagValue("dateOfBirth", element);
            NodeList nodeCars = element.getElementsByTagName("car");
            for (int j = 0; j < nodeCars.getLength(); j++) {
                carList.add(new Cars(nodeCars.item(j).getTextContent()));
            }
            String discount = getTagValue("discount", element);
            try {
                customers.add(Customer.builder()
                        .firstName(firstName)
                        .secondName(secondName)
                        .lastOrder(lastOrder)
                        .dateOfBirth(dateOfBirth)
                        .carList(carList)
                        .discount(discount)
                        .build());
            } catch (CustomerBuilderException e) {
                e.printStackTrace();
            }
        }
    }

    public String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
