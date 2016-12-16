package converter;

import model.User;

import java.util.List;

public interface Converter {
    void generateDoc(List<User> users, String outFilePath) throws Exception;
}
