package my.project.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class SearchColumn {
    public static int getColumn(Sheet sheet) {
        String columnName = "Код_бюджета";
        int patchColumn = 0;
        Row rw = sheet.getRow(0);
        for (int numberColumn = 0; numberColumn < rw.getLastCellNum(); numberColumn++) {
            Cell cll = rw.getCell(numberColumn);
            String text = cll.getStringCellValue();
            if (columnName.equals(text)) {
                patchColumn = numberColumn;
            }
        }
        return patchColumn;
    }
}
