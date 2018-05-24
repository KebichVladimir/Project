package by.itacademy.parsing;

import by.itacademy.elements.ServiceStation;
import by.itacademy.exceptions.ReaderBaseException;

import java.io.IOException;

public interface ParsingBase {
    ServiceStation readBase() throws IOException, ReaderBaseException;
}
