package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static hexlet.code.Parser.parsingJson;
import static hexlet.code.Parser.parsingYml;

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

        if (!Files.exists(p)) {
            throw new IllegalArgumentException("Файл не найден или путь не верный: " + path);
        }

        return Files.readString(p);
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
        String file1 = readFile(p1);
        String file2 = readFile(p2);

        Map<String, Object> data1;
        Map<String, Object> data2;
        if (determineFileType(p1).equals("yml")
                && determineFileType(p2).equals("yml")) {
            data1 = parsingYml(file1);
            data2 = parsingYml(file2);
        } else if (determineFileType(p1).equals("json")
                && determineFileType(p2).equals("json")) {
            data1 = parsingJson(file1);
            data2 = parsingJson(file2);
        } else {
            throw new IllegalArgumentException("Расширения файлов разные.");
        }

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

    /** Проверка расширения файла.
     *
     * @param p путь до файла
     * @return расширение файла
     */
    public static String determineFileType(final String p) {
        int indexDot = p.lastIndexOf('.');
        if (indexDot == -1) {
            throw new IllegalArgumentException("Путь файл указан с ошибкой.");
        }

        String endFile = p.substring(indexDot).toLowerCase();
        return switch (endFile) {
            case ".json" -> "json";
            case ".yml", ".yaml" -> "yml";
            default -> throw new IllegalArgumentException(
                    "Расширение не является YML, YAML, JSON.");
        };
    }
}
