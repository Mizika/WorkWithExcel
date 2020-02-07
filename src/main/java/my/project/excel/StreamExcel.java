package my.project.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamExcel {
    public static Sheet streamSheet(String excelFolder, String nameFile) throws IOException, InvalidFormatException {
        InputStream inp = new FileInputStream(excelFolder + nameFile);
        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(0);
        return sheet;
    }
}
