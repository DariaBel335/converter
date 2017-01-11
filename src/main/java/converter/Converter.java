package converter;

import model.CSVLine;

import java.util.List;

/**
 * Converter.java
 * Interface that has the generate method
 * */
public interface Converter {
    void generate(List<CSVLine> lines, String outFilePath) throws Exception;
}
