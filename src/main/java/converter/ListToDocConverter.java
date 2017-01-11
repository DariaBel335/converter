package converter;

import constants.Constants;
import model.CSVLine;
import model.Unit;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * ListToDocConverter.java which implements interface Converter
 */
public class ListToDocConverter implements Converter {

    /**
     * @param lines
     * @param fileName
     */
    public void generate(List<CSVLine> lines, String fileName) {
        // Create Blank Document
        XWPFDocument document = new XWPFDocument();
        //Write the Document in file system
        String output = Constants.OUTPUT_DIR + fileName + ".docx";
        try (FileOutputStream out = new FileOutputStream(new File(output))) {
            for (int i = 0; i < lines.size(); i++) {
                List<Unit> units = lines.get(i).getUnits();
                for(int ui = 0; ui < units.size(); ui++){
                    XWPFParagraph paragraph = document.createParagraph();
                    XWPFRun run=paragraph.createRun();
                    run.setText(units.get(ui).getField()+ ": " + units.get(ui).getValue());
                }
                XWPFParagraph paragraph = document.createParagraph();
                XWPFRun run=paragraph.createRun();
                run.addBreak();
            }

            document.write(out);
        } catch (IOException ex) {
            throw new RuntimeException("File was not read properly", ex);
        }

        System.out.println(output + " written successfully");
    }
}