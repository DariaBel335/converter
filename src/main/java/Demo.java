import converter.ListToDocConverter;
import model.User;
import reader.CSVReader;
import reader.Reader;
import converter.Converter;
import utils.UserUtils;

import java.util.List;

import static constants.Constants.FileConstants.IN_FILE_NAME;
import static constants.Constants.FileConstants.OUT_FILE_NAME;

/** Main class
 *
 */
public class Demo {
    /** Method to start converting
     *
     */
    public static void main(String[] args) throws Exception {
        Reader reader = new CSVReader();
        Converter converter = new ListToDocConverter();

        List<User> users = reader.read(IN_FILE_NAME);
        UserUtils.printDetails(System.out, users);

        converter.generate(users, OUT_FILE_NAME);
    }
}