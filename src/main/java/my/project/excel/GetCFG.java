package my.project.excel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetCFG {
    private static Map<String, String> hashMap;
    private static ArrayList<String> arrayList = new ArrayList<>();
    private static String path = "C:\\Users\\mzame\\Desktop\\1";

    public static ArrayList<String> searchCodeCFG() {
        hashMap = new HashMap<>();
        File file=new File(path + "//" + "config.cfg");
        try (BufferedReader readFromFile = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = readFromFile.readLine())!= null){
                String[] tmp = line.split(" ");
                hashMap.put(tmp[0], tmp[1]);
            }
            String value = hashMap.getOrDefault("Код_бюджета:", "Значение с данным ключом не существует!");
            String[] subStr = value.split(",");
            for(int i = 0; i < subStr.length; i++) {
                arrayList.add(subStr[i]);
            }
            return arrayList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
