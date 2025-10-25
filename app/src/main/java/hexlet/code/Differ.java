package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс с методами для генерации diff.
 */
public final class Differ {

    private Differ() {
    }

    /** Чтение файла.
     * @param path путь до файла
     * @return содержимое файла
     * @throws Exception если чтение не удалось
     */
    public static String readFile(final String path) throws Exception {
        final Path p = Path.of(path);
        return Files.readString(p);
    }

    /** Парсинг JSON в Map.
     *
     * @param dataJson строка JSON
     * @return отображение в формате ключ-значение
     * @throws Exception если парсинг не удался
     */
    public static Map<String, Object> parsingJson(
            final String dataJson) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(dataJson, Map.class);
    }

    /** Генерация diff.
     *
     * @param p1 путь к файлу №1
     * @param p2 путь к файлу №2
     * @return diff в формате "stylish"
     * @throws Exception при ошибке чтения или парсинга
     */
    public static String generate(
            final String p1, final String p2) throws Exception {
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

        for (String key : keys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (data1.containsKey(key) && data2.containsKey(key)) {
                if (value1.equals(value2)) {
                    result.append("    ").append(key).append(": ")
                            .append(value1.toString())
                            .append(System.lineSeparator());
                } else {
                    result.append("  - ").append(key).append(": ")
                            .append(value1.toString())
                            .append(System.lineSeparator());
                    result.append("  + ").append(key).append(": ")
                            .append(value2.toString())
                            .append(System.lineSeparator());
                }
            } else if (data1.containsKey(key)) {
                result.append("  - ").append(key).append(": ")
                        .append(value1.toString())
                        .append(System.lineSeparator());
            } else {
                result.append("  + ").append(key).append(": ")
                        .append(value2.toString())
                        .append(System.lineSeparator());
            }
        }
        result.append("}");

        return result.toString();
    }
}
