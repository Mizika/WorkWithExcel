package my.project.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.HashMap;
import java.util.Map;

public class SearchValue {
    private static int codeNumber;
    private static String columnName = "Код_бюджета";
    private static Map<Integer, String> hashmap = new HashMap<>();
    public static Map<Integer, String> getValue(Sheet sheet, int patchColumn) {
        for (Row row : sheet) {
            Cell cell = row.getCell(patchColumn);
            String code = cell.getStringCellValue();
            if(!"".equals(code) && !columnName.equals(code)) {
                codeNumber = cell.getRowIndex();
            }
            hashmap.put(codeNumber, code);
        }
        return hashmap;
    }
}
