package converter;

import model.User;

import java.util.List;

/**Converter.java
 * Interface that has the generate method
 * */
public interface Converter {
    void generate(List<User> users, String outFilePath) throws Exception;
}
