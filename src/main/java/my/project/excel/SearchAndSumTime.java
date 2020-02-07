package my.project.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SearchAndSumTime {
    private static String columnNameToSum = "Итого за период";
    private static int pathWork = 0;
    private static ArrayList<Double> myArrayList = new ArrayList<>();
    private static ArrayList<String> nameCodeAr = new ArrayList<>();
    private static Map<String, Double> hashmapOut = new HashMap<>();

    public static Map<String, Double> getTime(Sheet sheet, Map<Integer, String> hashmap, ArrayList<String> codeFromFile) {
        double sum=0;
        String nameCode = null;
        Row rw = sheet.getRow(0);
        for (int numberColumn = 0; numberColumn < rw.getLastCellNum(); numberColumn++) {
            Cell cll = rw.getCell(numberColumn);
            String text = cll.getStringCellValue();
            if (columnNameToSum.equals(text)) {
                pathWork = numberColumn;
                for (Map.Entry<Integer, String> key : hashmap.entrySet()) {
                    for(int i = 0; i < codeFromFile.size(); i++) {
                        nameCode = codeFromFile.get(i);
                        if (key.getValue().equals(nameCode)) {
                            Row r = sheet.getRow(key.getKey());
                            cll = r.getCell(pathWork);
                            String result = cll.getStringCellValue();
                            String endResult = result.replaceAll("ч","").replaceAll(",",".");
                            Double converToIntEndResult = Double.parseDouble(endResult);
                            myArrayList.add(converToIntEndResult);
                            System.out.println(Arrays.asList(myArrayList));
                    }
                }
            }
                for(int ii=0; ii<myArrayList.size(); ii++) {
                    sum=sum+ myArrayList.get(ii);
                    hashmapOut.put(nameCode, sum);
                }
        }
        }
        return hashmapOut;
    }
}
