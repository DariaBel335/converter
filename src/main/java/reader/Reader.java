package reader;

import model.User;

import java.util.List;

/**Reader.java
 * Interface that has the generate method
 * */
public interface Reader {
    List<User> read(String path);
}
