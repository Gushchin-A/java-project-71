package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;


public class Differ {
    public static String readFile(String path) throws Exception {
        Path p = Path.of(path);
        return Files.readString(p);
    }

    public static Map<String, Object> parsingJson (String dataJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(dataJson, Map.class);
    }

    public static String generate(String p1, String p2) throws Exception {
        String json1 = readFile(p1);
        String json2 = readFile(p2);

        Map<String, Object> data1 = parsingJson(json1);
        Map<String, Object> data2 = parsingJson(json2);

        return "Прочитали файл1. Все ключи: " + data1.keySet() + "\n"
                + "Прочитали файл2. Длина файла: " + data2.size();
    }
}
