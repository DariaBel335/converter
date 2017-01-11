package reader;

import model.CSVLine;
import model.Unit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/** CSVReader.java implements interface Reader.java
 *
 */
public class CSVReader implements Reader {

    /**Method for parsing users
     *
     * @param filePath initial path to file
     * @return users parsed users
     */
    public List<CSVLine> read(String filePath) {
        List<CSVLine> result = new ArrayList<CSVLine>();
        String[] head = {};
        int count_row = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                if(count_row == 0){
                    head = line.split(",");
                }
              String[]  row = line.split(",");
                CSVLine ln = new CSVLine();
                List<Unit> units = new ArrayList<Unit>();
                for (int i =0; i< row.length; i++){
                    Unit unit = new Unit();
                    unit.setField(head[i]);
                    unit.setValue(row[i]);
                    units.add(unit);
                }
                ln.setUnits(units);
                count_row++;
                result.add(ln);
            }

        return result;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}