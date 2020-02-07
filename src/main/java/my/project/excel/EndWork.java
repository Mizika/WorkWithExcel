package my.project.excel;

import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class EndWork {
    public static void main(String[] args) throws Exception {
        //Список кода бюджета для поиска из конфига
        ArrayList<String> codeFromFile = GetCFG.searchCodeCFG();
        //Доступ к файлу
        Sheet stSheet = StreamExcel.streamSheet("C:\\Users\\mzame\\Desktop\\1\\", "Копенкин А.А. январь.xlsx");
        //Номер колонки
        int columnNumber = SearchColumn.getColumn(stSheet);
        //Код-бюджета из экселя
        Map<Integer, String> codeFromExcel =  SearchValue.getValue(stSheet, columnNumber);
        //Поиск времени из колонки Итого за период
        Map<String, Double> time = SearchAndSumTime.getTime(stSheet, codeFromExcel,codeFromFile);

        System.out.println(Arrays.asList(time));


    }
}
