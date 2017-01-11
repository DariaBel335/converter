package reader;

import model.CSVLine;

import java.util.List;


/**Reader.java
 * Interface that has the generate method
 * */
public interface Reader {
    List<CSVLine> read(String path);
}