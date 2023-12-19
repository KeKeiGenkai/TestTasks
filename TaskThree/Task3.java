package TaskThree;
/*
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Task3 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: JsonProcessor <tests.json> <values.json>");
            return;
        }

        String testsJsonPath = args[0];
        String valuesJsonPath = args[1];

        try {
            // Чтение содержимого файлов
            String testsJson = new String(Files.readAllBytes(Paths.get(testsJsonPath)));
            String valuesJson = new String(Files.readAllBytes(Paths.get(valuesJsonPath)));

            // Преобразование JSON строк в объекты
            JSONObject testsObject = new JSONObject(testsJson);
            JSONArray valuesArray = new JSONArray(valuesJson);

            // Обработка данных
            processJson(testsObject, valuesArray);

            // Сохранение результата в report.json
            Files.write(Paths.get("report.json"), testsObject.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processJson(JSONObject testsObject, JSONArray valuesArray) {
        if (testsObject.has("values")) {
            JSONArray testValues = testsObject.getJSONArray("values");

            for (int i = 0; i < testValues.length(); i++) {
                JSONObject testValue = testValues.getJSONObject(i);
                int id = testValue.getInt("id");

                for (int j = 0; j < valuesArray.length(); j++) {
                    JSONObject valueObject = valuesArray.getJSONObject(j);
                    if (valueObject.getInt("id") == id) {
                        testValue.put("value", valueObject.getString("value"));
                        break;
                    }
                }
            }
        }

        if (testsObject.has("children")) {
            JSONArray childrenArray = testsObject.getJSONArray("children");
            for (int i = 0; i < childrenArray.length(); i++) {
                processJson(childrenArray.getJSONObject(i), valuesArray);
            }
        }
    }
}*/