package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Differ {
    public static String readFile(String path) throws Exception {
        Path p = Path.of(path);
        return Files.readString(p);
    }

    public static Map<String, Object> parsingJson(String dataJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(dataJson, Map.class);
    }

    public static String generate(String p1, String p2) throws Exception {
        String json1 = readFile(p1);
        String json2 = readFile(p2);

        Map<String, Object> data1 = parsingJson(json1);
        Map<String, Object> data2 = parsingJson(json2);

        Set<String> keys = new TreeSet<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());

        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append(System.lineSeparator());

        for (String key : keys ) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (data1.containsKey(key) && data2.containsKey(key)) {
                if (value1.equals(value2)) {
                    result.append("    ").append(key).append(": ")
                            .append(value1.toString()).append(System.lineSeparator());
                } else {
                    result.append("  - ").append(key).append(": ")
                            .append(value1.toString()).append(System.lineSeparator());
                    result.append("  + ").append(key).append(": ")
                            .append(value2.toString()).append(System.lineSeparator());
                }
            } else if (data1.containsKey(key)) {
                result.append("  - ").append(key).append(": ")
                        .append(value1.toString()).append(System.lineSeparator());
            } else {
                result.append("  + ").append(key).append(": ")
                        .append(value2.toString()).append(System.lineSeparator());
            }
        }
        result.append("}");

        return result.toString();
    }
}
