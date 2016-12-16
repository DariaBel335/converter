package reader;

import model.User;

import java.util.List;

public interface Reader {
    List<User> read(String path);
}
