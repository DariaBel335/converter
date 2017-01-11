import constants.Constants;

import java.io.File;

import converter.ListToDocConverter;
import reader.CSVReader;
import reader.Reader;

public class Demo {
    public static void main(String[] args) throws Exception {
        File myDirectory = new File(Constants.CSV_DIR);
        String[] containingFileNames = myDirectory.list();
        Reader reader = new CSVReader();

        for (String fileName : containingFileNames) {
            if (fileName.matches("input_\\d*.csv")) {
                ListToDocConverter converter = new ListToDocConverter();
                converter.generate(reader.read(Constants.CSV_DIR + fileName), fileName);
            }
        }
    }
}