package converter;

import model.User;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static constants.Constants.FileFieldsNamesConstants.DEPARTMENT;
import static constants.Constants.FileFieldsNamesConstants.EMAIL;
import static constants.Constants.FileFieldsNamesConstants.FIRST_NAME;
import static constants.Constants.FileFieldsNamesConstants.LAST_NAME;
import static constants.Constants.FileFieldsNamesConstants.PASSWORD;
import static constants.Constants.FileFieldsNamesConstants.PHONE;
import static constants.Constants.FileFieldsNamesConstants.SECONDARY_EMAIL;

public class ListToDocConverter implements Converter {

    public void generateDoc(List<User> users, String outFilePath) {
        //Blank Document
        XWPFDocument document = new XWPFDocument();

        //Write the Document in file system
        try(FileOutputStream out = new FileOutputStream(new File(outFilePath))) {

            //create table
            XWPFTable table = document.createTable();

            //create first row
            XWPFTableRow tableRowOne = table.getRow(0);
            tableRowOne.getCell(0).setText(FIRST_NAME);
            tableRowOne.addNewTableCell().setText(LAST_NAME);
            tableRowOne.addNewTableCell().setText(EMAIL);
            tableRowOne.addNewTableCell().setText(PHONE);
            tableRowOne.addNewTableCell().setText(DEPARTMENT);
            tableRowOne.addNewTableCell().setText(SECONDARY_EMAIL);
            tableRowOne.addNewTableCell().setText(PASSWORD);

            for (int i = 1; i < users.size(); i++) {
                //create second row
                XWPFTableRow row = table.createRow();
                row.getCell(0).setText(users.get(i).getFirstName());
                row.getCell(1).setText(users.get(i).getLastName());
                row.getCell(2).setText(users.get(i).getEmail());
                row.getCell(3).setText(users.get(i).getPhone());
                row.getCell(4).setText(users.get(i).getDepartment());
                row.getCell(5).setText(users.get(i).getSecondaryEmail());
                row.getCell(6).setText(users.get(i).getPassword());
            }

            document.write(out);
        } catch (IOException ex) {
            throw new RuntimeException("File was not read properly", ex);
        }

        System.out.println(outFilePath + " written successully");
    }
}