package reader;

import model.User;
import utils.UserUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements Reader {

    public List<User> read(String filePath) {
        List<User> users = new ArrayList<User>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            br.readLine(); // skip the first example line

            String line;
            while ((line = br.readLine()) != null) {
                User user = UserUtils.createUser(line.split(","));
                users.add(user);
            }

            return users;
        } catch (IOException e) {
            throw new RuntimeException("File cannot be read", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}